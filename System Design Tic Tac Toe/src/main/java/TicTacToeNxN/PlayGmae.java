package TicTacToeNxN;

import java.util.Scanner;

public class PlayGmae {
    public static void main(String args[]) {
        System.out.println("Enter Player-1 symbol followed by Player-1 Name");
        Scanner sc = new Scanner(System.in);
        Player p1 = new Player();
        p1.setPlayerSymbol(sc.next().charAt(0));
        sc.nextLine();
        p1.setPlayerName(sc.nextLine());

        System.out.println("Enter Player-2 symbol followed by Player-2 Name");

        Player p2 = new Player();
        p2.setPlayerSymbol(sc.next().charAt(0));
        sc.nextLine();
        p2.setPlayerName(sc.nextLine());

        Player players[] = new Player[2];
        players[0]=p1;
        players[1]=p2;
        int boardSize =3;
        GameBoard gb =new GameBoard(boardSize, players);
        gb.startGame();
    }
}
