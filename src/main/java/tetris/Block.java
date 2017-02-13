package tetris;

public class Block {
	
	private char name;
	private int currentRow;
	private int currentCol;
	
	public Block (char name){
		this.name= name;
		this.currentRow=-1;
		this.currentCol=-1;
	}
	
	public char getName(){
		return this.name;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	
	

}
