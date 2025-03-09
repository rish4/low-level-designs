package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter number of players: ");
        int numOfPLayers= scanner.nextInt();
        scanner.nextLine();

        List<Player> players= new ArrayList<>();
        char[] symbols={'X', 'O', 'A', 'B','C', 'D', 'E','F','G','H'};

        for(int i=0;i<numOfPLayers;i++){
            System.out.println("Enter player "+(i+1) +" name:" );
            String name=scanner.nextLine();
            Player player= new Player(name,symbols[i]);
            players.add(player);
        }

        System.out.println("Enter grid size: ");
        int gridSize=scanner.nextInt();

        Game game= new Game(players,gridSize);
        game.startGame();


    }
}
