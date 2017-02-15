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
		String pointingTop5x5="" +
                "..XXX\n" +
                "..XX.\n" +
                "..X..\n" +
                ".....\n" +
                ".....\n";
		String pointingRight5x5="" +
                ".....\n" +
                ".....\n" +
                "..XXX\n" +
                "...XX\n" +
                "....X\n";
		Piece piece = null;
		//no se utiliza switch porque no permite utilizar variables y en principio el 
		//código quedaba menos legible metiendo todos los strings de arriba como constantes
		//en los case
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
		if(this.composition.equals(pointingTop5x5)){
			piece= new Piece(pointingRight5x5);
		}
		return piece;
		}
	
	public Piece rotateLeft(){
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
			piece= new Piece(pointingLeft);
		}
		if (this.composition.equals(pointingRight)){
			piece= new Piece(pointingTop);
		}
		if (this.composition.equals(pointingDown)){
			piece= new Piece(pointingRight);
		}
		if(this.composition.equals(pointingLeft)){
			piece= new Piece(pointingDown);
			}
		return piece;
		}
}
