package tetris;

public class Piece {
	private String composition;
	
	public Piece(String composition){
		this.composition= composition;
	}
	
	public String toString(){
		return this.composition;
	}
	
	public Piece rotateRight(){
		String pointingTop="" +
                ".X.\n" +
                ".X.\n" +
                "...\n";
		String pointingRight = "" +
                "...\n" +
                ".XX\n" +
                "...\n";
		String pointingDown = "" +
                "...\n" +
                ".X.\n" +
                ".X.\n";
		String pointingLeft= "" +
                "...\n" +
                "XX.\n" +
                "...\n";
		Piece piece = null;
		
		if (this.composition.equals(pointingTop)){
			piece= new Piece(pointingRight);
		}
		if (this.composition.equals(pointingRight)){
			piece= new Piece(pointingDown);
		}
		if (this.composition.equals(pointingDown)){
			piece= new Piece(pointingLeft);
		}
		if(this.composition.equals(pointingLeft)){
			piece= new Piece(pointingTop);
			}
		return piece;
		}
}
