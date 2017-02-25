// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int rows;
    private final int columns;
    private Boolean hasFalling;
    private Boolean hasFallingBlock;
    private Boolean hasFallingTetro;
    private Block [][] situation;
    private Block fallingBlock;
    private List<Block> fallingTetro;
    Block emptyBlock = new Block('.');
    

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.hasFalling= false;
        this.hasFallingTetro= false;
        this.hasFallingBlock=false;
        this.situation = new Block[this.rows][this.columns];
        this.fallingBlock=this.emptyBlock;
        this.fallingTetro=new ArrayList<Block>();
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
    	if (this.hasFalling){
    		throw new IllegalStateException("already falling");
    	}
    	this.situation[0][1]=block;
    	block.setCurrentRow(0);
    	block.setCurrentCol(1);
    	this.fallingBlock=block;
    	this.hasFallingBlock=true;
    	this.hasFalling= true;
    }
    
    public void drop(Tetromino tetro){
    	if(tetro.toString().equals(Tetromino.T_SHAPE.toString())){
    		Block t1 = new Block('T');
    		t1.setCurrentRow(1);
    		t1.setCurrentCol(3);
    		this.fallingTetro.add(t1);
    		this.situation[1][3]=t1;
    		Block t2 = new Block('T');
    		t2.setCurrentRow(1);
    		t2.setCurrentCol(4);
    		this.fallingTetro.add(t2);
    		this.situation[1][4]=t2;
    		Block t3 = new Block('T');
    		t3.setCurrentRow(1);
    		t3.setCurrentCol(5);
    		this.fallingTetro.add(t3);
    		this.situation[1][5]=t3;
    		Block t4 = new Block('T');
    		t4.setCurrentRow(0);
    		t4.setCurrentCol(4);
    		this.fallingTetro.add(t4);
    		this.situation[0][4]=t4;
    		this.hasFallingTetro=true;
    		this.hasFalling=true;
    	}
    	
    }
    
    public void tick(){
    	if (this.hasFallingBlock){
    		this.tickBlock();
    	}
    	if (this.hasFallingTetro){
    		this.tickTetro();
    	}
    }
    
    public void tickBlock(){
    	int row = this.fallingBlock.getCurrentRow();
    	int col = this.fallingBlock.getCurrentCol();
    	if (row == rows-1){
    		this.hasFalling=false;
    	}else if(this.situation[row + 1][col].getName()!='.'){
    		this.hasFalling=false;
    	}else{
    		this.situation[row][col]=this.emptyBlock;
        	this.situation[row + 1][col]=this.fallingBlock;
        	this.fallingBlock.setCurrentRow(row + 1);
    	}
    	
    }
    
    public void tickTetro(){
    	for(int i=0;i<this.fallingTetro.size();i++){
    		this.fallingBlock=this.fallingTetro.get(i);
    		this.tickBlock();
    		this.fallingBlock=this.emptyBlock;
    	}
    }
}
