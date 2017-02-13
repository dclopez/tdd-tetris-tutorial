// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private Boolean hasFalling;
    private char [][] situation;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.hasFalling= false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                this.situation[row][col] = '.';
            }
        }
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                //s += this.board[row][col];
            	s += '.';
            }
            s += "\n";
        }
        return s;
    }
    
    public Boolean hasFalling(){
    	return this.hasFalling;
    }
    
    public void drop(Block block){
    	this.situation[0][1]=block.getName();
    	this.hasFalling= true;
    }
}
