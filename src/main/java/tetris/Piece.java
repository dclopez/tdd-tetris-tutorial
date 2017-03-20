package tetris;

public class Piece implements BoardPiece {

  private Block[][] blocks;

  /**
   * Constructor de Piece.
   * @param piece String que nombra a Piece.
   */
  public Piece(String piece) {
    String[] rows = piece.split("\n");
    for (int i = 0; i < rows.length; i++) {
      char[] column = rows[i].toCharArray();
      for (int j = 0; j < column.length; j++) {
        if ((i == 0) && (j == 0)) {
          blocks = new Block[rows.length][column.length];
        }
        blocks[i][j] = new Block(column[j]);
      }
    }
  }

  /**
   * Método toString para Piece.
   */
  @Override
  public String toString() {
    String s = "";
    if (blocks != null) {
      for (int i = 0; i < blocks.length; i++) {
        for (int j = 0; j < blocks[i].length; j++) {
          s += blocks[i][j].toString();
        }
        s += "\n";
      }
    }
    return s;
  }

  public int width() {
    return blocks[0].length;
  }

  public int height() {
    return blocks.length;
  }

  public boolean is_hollow_at(int i, int j) {
    return blocks[i][j].toString().equals(String.valueOf(BoardPiece.EMPTY));
  }

  public Piece rotateRight() { // transpose + reverse each row
    return new Piece(reverse_rows(transpose(blocks)));
  }

  public Piece rotateLeft() { // reverse each row + transpose
    return new Piece(transpose(reverse_rows(blocks)));
  }

  /**
   * Método para transponer Bla matriz de Blocks que compone a Piece.
   * @param blocks Matriz de Blocks que se quiere transponer.
   * @return la matriz traspuesta.
   */
  private Block[][] transpose(Block blocks[][]) {
    Block[][] transposedBlocks = new Block[blocks.length][blocks[0].length];
    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks[i].length; j++) {
        transposedBlocks[j][i] = blocks[i][j];
      }
    }
    return transposedBlocks;
  }

  /**
   * Método para volver las filas de la matriz de Blocks del revés.
   * @param blocks matriz de Blocks.
   * @return la matriz de Blocks con las filas del revés.
   */
  private Block[][] reverse_rows(Block blocks[][]) {
    Block[][] reversedBlocks = new Block[blocks.length][blocks[0].length];
    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks[i].length; j++) {
        reversedBlocks[i][j] = blocks[i][blocks[i].length - j - 1];
      }
    }
    return reversedBlocks;
  }

  private Piece(Block blocks[][]) {
    this.blocks = blocks;
  }

}