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
	
	public Tetromino rotateRight(){
		String pointingTop="" +
                ".T.\n" +
                "TTT\n" +
                "...\n";
		String pointingRight = "" +
                ".T.\n" +
                ".TT\n" +
                ".T.\n";
		String pointingDown = "" +
                "...\n" +
                "TTT\n" +
                ".T.\n";
		String pointingLeft= "" +
                ".T.\n" +
                "TT.\n" +
                ".T.\n";

		Tetromino tetro = null;

		if (this.shape.equals(pointingTop)){
			tetro= new Tetromino(pointingRight);
		}
		if (this.shape.equals(pointingRight)){
			tetro= new Tetromino(pointingDown);
		}
		if (this.shape.equals(pointingDown)){
			tetro= new Tetromino(pointingLeft);
		}
		if(this.shape.equals(pointingLeft)){
			tetro= new Tetromino(pointingTop);
			}

		return tetro;
	}
	
	public void rotateLeft(){
		
	}

}
