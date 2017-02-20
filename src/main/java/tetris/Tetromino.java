package tetris;

public class Tetromino {

	public static final Tetromino T_SHAPE = new Tetromino("" + ".T.\n"
															 + "TTT\n" 
			                                                 + "...\n");

	private String shape;

	public Tetromino(String shape) {
		this.shape = shape;
	}
	
	public String toString(){
		return this.shape;
	}
	
	public void rotateRight(){
		
	}
	
	public void rotateLeft(){
		
	}

}
