package TicTacToe;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

public class Board {
    private char[][] grid;
    private int size;

    public Board(int size){
        this.size=size;
        grid= new char[size][size];
        for(int i=0;i<size;i++){
            Arrays.fill(grid[i],'-');
        }
    }

    public int getSize() {
        return size;
    }

    public void displayBoard(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public Boolean isValidMove(int row, int col){
         return row>=0 && row<size && col>=0 && col<size && grid[row][col]=='-';
    }
    
    public void makeMove(int row, int col, char symbol){
        grid[row][col]=symbol;
    }
    
    public boolean isFull(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkWin(char symbol){
        for(int i=0;i<size;i++){
            if(checkRow(i, symbol) || checkColumn(i, symbol)){
                return true;
            }
        }
        return checkDiagonal(symbol);
    }

    private boolean checkDiagonal(char symbol) {
        for(int i=0;i<size;i++){
            if(grid[i][i]!=symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, char symbol) {
        for(int i=0;i<size; i++){
            if(grid[row][i]!=symbol){
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, char symbol) {
        for(int i=0;i<size;i++){
            if(grid[i][col]!=symbol){
                return false;
            }
        }
        return true;
    }
}
