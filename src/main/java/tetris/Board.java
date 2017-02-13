// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rows;
    private final int columns;
    private Boolean hasFalling;
    private Block [][] situation;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.hasFalling= false;
        this.situation = new Block[this.rows][this.columns];
        Block emptyBlock = new Block('.');
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                this.situation[row][col] = emptyBlock;
            }
        }
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s += this.situation[row][col].getName();
            }
            s += "\n";
        }
        return s;
    }
    
    public Boolean hasFalling(){
    	return this.hasFalling;
    }
    
    public void drop(Block block){
    	this.situation[0][1]=block;
    	this.hasFalling= true;
    }
    
    public void tick(){
    	Block block_to_move = this.situation[0][1];
    	Block emptyBlock=new Block('.');
    	this.situation[0][1]=emptyBlock;
    	this.situation[1][1]=block_to_move;
    }
}
