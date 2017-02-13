package tetris;

public class Piece {
	private String composition;
	
	public Piece(String composition){
		this.composition= composition;
	}
	
	public String toString(){
		return this.composition;
	}
}
