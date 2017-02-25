package tetris;

public class Tetromino {

	public static final Tetromino T_SHAPE = new Tetromino("" + ".T.\n"
															 + "TTT\n" 
			                                                 + "...\n");
	public static final Tetromino I_SHAPE = new Tetromino("" +
                                                          "....\n" +
                                                          "IIII\n" +
                                                          "....\n" +
                                                          "....\n");
	public static final Tetromino O_SHAPE = new Tetromino("" +
                                                          ".OO\n" +
                                                          ".OO\n" +
                                                          "...\n");

	private String shape;

	public Tetromino(String shape) {
		this.shape = shape;
	}
	
	public String toString(){
		return this.shape;
	}
	
	public Tetromino rotateRight(){
		String pointingTop=null;
		String pointingRight=null;
		String pointingDown=null;
		String pointingLeft=null;
		if(this.shape.length()<13 && this.shape.toCharArray()[5]=='T'){
			pointingTop="" +
	                ".T.\n" +
	                "TTT\n" +
	                "...\n";
			pointingRight = "" +
	                ".T.\n" +
	                ".TT\n" +
	                ".T.\n";
			pointingDown = "" +
	                "...\n" +
	                "TTT\n" +
	                ".T.\n";
			pointingLeft= "" +
	                ".T.\n" +
	                "TT.\n" +
	                ".T.\n";
		}
		
		if(this.shape.length()<13 && this.shape.toCharArray()[5]=='O'){
			pointingTop="" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n";
			pointingRight = "" +
                    "...\n" +
                    ".OO\n" +
                    ".OO\n";
			pointingDown = "" +
                    "...\n" +
                    "OO.\n" +
                    "OO.\n";
			pointingLeft= "" +
                    "OO.\n" +
                    "OO.\n" +
                    "...\n";
		}
		
		if (this.shape.length()>13){
			pointingTop="" +
                    "....\n" +
                    "IIII\n" +
                    "....\n" +
                    "....\n";
			pointingRight ="" +
                    "..I.\n" +
                    "..I.\n" +
                    "..I.\n" +
                    "..I.\n";
			pointingDown ="" +
                    "....\n" +
                    "....\n" +
                    "IIII\n" +
                    "....\n";
			pointingLeft= "" +
                    ".I..\n" +
                    ".I..\n" +
                    ".I..\n" +
                    ".I..\n";
		}
		

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
	
	public Tetromino rotateLeft(){
		String pointingTop=null;
		String pointingRight=null;
		String pointingDown=null;
		String pointingLeft=null;
		if(this.shape.length()<13 && this.shape.toCharArray()[5]=='T'){
			pointingTop="" +
	                ".T.\n" +
	                "TTT\n" +
	                "...\n";
			pointingRight = "" +
	                ".T.\n" +
	                ".TT\n" +
	                ".T.\n";
			pointingDown = "" +
	                "...\n" +
	                "TTT\n" +
	                ".T.\n";
			pointingLeft= "" +
	                ".T.\n" +
	                "TT.\n" +
	                ".T.\n";
		}
		
		if(this.shape.length()<13 && this.shape.toCharArray()[5]=='O'){
			pointingTop="" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n";
			pointingRight = "" +
                    "...\n" +
                    ".OO\n" +
                    ".OO\n";
			pointingDown = "" +
                    "...\n" +
                    "OO.\n" +
                    "OO.\n";
			pointingLeft= "" +
                    "OO.\n" +
                    "OO.\n" +
                    "...\n";
		}
		
		if (this.shape.length()>13){
			pointingTop="" +
                    "....\n" +
                    "IIII\n" +
                    "....\n" +
                    "....\n";
			pointingRight ="" +
                    "..I.\n" +
                    "..I.\n" +
                    "..I.\n" +
                    "..I.\n";
			pointingDown ="" +
                    "....\n" +
                    "....\n" +
                    "IIII\n" +
                    "....\n";
			pointingLeft= "" +
                    ".I..\n" +
                    ".I..\n" +
                    ".I..\n" +
                    ".I..\n";
		}

		Tetromino tetro = null;

		if (this.shape.equals(pointingTop)){
			tetro= new Tetromino(pointingLeft);
		}
		if (this.shape.equals(pointingRight)){
			tetro= new Tetromino(pointingTop);
		}
		if (this.shape.equals(pointingDown)){
			tetro= new Tetromino(pointingRight);
		}
		if(this.shape.equals(pointingLeft)){
			tetro= new Tetromino(pointingDown);
		}

		return tetro;
	}

	

}
