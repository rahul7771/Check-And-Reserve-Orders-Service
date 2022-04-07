package TicTacToeNxN;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {

    char board[][];
    int boardSize;
    Queue<Player> nextTurn;
    Scanner input;

    public GameBoard(int boarSize, Player[] players) {
        this.boardSize = boarSize;
        board = new char[(boarSize)][(boarSize)];
        initializeBoard(board);
        nextTurn = new LinkedList<Player>();

        nextTurn.add(players[0]);
        nextTurn.offer(players[1]);

        input = new Scanner(System.in);
    }

    private void initializeBoard(char[][] board) {
        for(int i=0 ; i<board.length ; i++) {
            for(int j=0; j<board.length ; j++) {
                    board[i][j] = '-';
            }
        }
    }

    public void startGame() {
        int count =0;
        while(true){
            count++;
            if(count== ((boardSize*boardSize)+1)) {
                System.out.println("Match draw");
                break;
            }
            Player p = nextTurn.poll();
            int position[] = getUserInput(p);
            int row = position[0]-1;
            int col = position[1]-1;
            board[row][col]= p.getPlayerSymbol();
            printBoard();
            System.out.println("Board after the move");
            if(count>=boardSize && checkEndGame(p,row,col)) break;
            nextTurn.offer(p);
        }
    }

    private int[] getUserInput(Player p){
        printBoard();
        System.out.println(p.getPlayerName() + " Please Enter a number row and column number with space in b/w ");
        int row = input.nextInt();
        int col = input.nextInt();
        while (!validateInput(row, col)){
            printBoard();
            System.out.println("Wrong Position Enter Again");
            row = input.nextInt();
            col = input.nextInt();
        }
        return new int[]{row,col};
    }

    private void printBoard(){
        for(char[] row : board){
            for(char col:row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private boolean validateInput(int row, int col){

        if (row<1 || row>boardSize) return false;

        if(board[row-1][col-1] != '-') return false;

        return true;
    }

    private boolean checkEndGame(Player p, int row, int col){
        String winString = "";
        for(int i=0;i<boardSize;i++){
            winString += String.valueOf(p.getPlayerSymbol());
        }

        String rowString="";
        String colString="";
        String diagonalString="";
        String reverseDiagonalString="";
        for(int i=0;i<board.length;i++){
            rowString += board[row][i];
            colString += board[i][col];
            if(row==col){
                diagonalString += board[i][i];
            }
            if((row+col)== board.length-1){
                reverseDiagonalString += board[board.length-1-i][i];
            }
        }

        if(winString.equals(rowString) || winString.equals(colString) || winString.equals(diagonalString) || winString.equals(reverseDiagonalString)){
            System.out.println(p.getPlayerName()+" has won the Game");
            return true;
        }

        return false;
    }
}
