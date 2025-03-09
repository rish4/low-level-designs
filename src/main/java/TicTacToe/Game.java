package TicTacToe;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private int currPlayerIndex;
    private Scanner scanner;

    public Game(List<Player> players, int gridSize){
        board= new Board(gridSize);
        this.players=players;
        this.currPlayerIndex=0;
        scanner= new Scanner(System.in);
    }

    public void startGame(){
        board.displayBoard();
        Player currentPlayer= players.get(currPlayerIndex);

        System.out.println(currentPlayer.getName() + "'s turn(" + currentPlayer.getSymbol()+"). Enter row and column (0-" + (board.getSize()-1) + "):");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter numbers.");
            scanner.next(); // Consume invalid input
        }
        int row = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter numbers.");
            scanner.next(); // Consume invalid input
        }
        int col = scanner.nextInt();


        if(board.isValidMove(row, col)){
            board.makeMove(row, col, currentPlayer.getSymbol());
            if(board.checkWin(currentPlayer.getSymbol())){
                board.displayBoard();
                System.out.println(currentPlayer.getName() + "wins!!");
                return;
            }

            if(board.isFull()){
                board.displayBoard();
                System.out.println("It's a draw!!");
                return;
            }

            currPlayerIndex=(currPlayerIndex+1) % players.size();
//            This line is responsible for cycling through the players in a round-robin manner, ensuring that after each turn, the next player gets to play.
            System.out.println("Next player turn...");

        }else{
            System.out.println("Invalid move, try again!!");
        }

    }
}
