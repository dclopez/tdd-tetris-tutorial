// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

  public static final String ALREADY_FALLING = "already falling";
  public static final String OUT_OF_BOARD = "out of board";

  private final int rows;
  private final int columns;
  private BoardPiece fallingBlock;
  private int currentBlockRow;
  private int currentBlockColumn;
  private char[][] board;
  private boolean lastTick;

  /**
   * Constructor de Board.
   * @param rows número de filas.
   * @param columns número de columnas.
   */
  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.fallingBlock = null;
    this.board = new char[rows][columns];
    fill_with(board, BoardPiece.EMPTY);
    this.lastTick = false;
  }

  /**
   * Método toString de Board.
   */
  public String toString() {
    String s = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (falling_block_is_at(i, j)) {
          char[][] block = new char[fallingBlock.width()][fallingBlock.height()];
          fill_with(block, fallingBlock.toString());
          s += block[(i - currentBlockRow)][(j - currentBlockColumn)];
        } else {
          char[] c = { board[i][j] };
          s += new String(c);
        }
      }
      s += "\n";
    }
    return s;
  }

  public boolean hasFalling() {
    return (fallingBlock != null);
  }

  /**
   * Método para soltar una Piece en Board.
   * @param b la Piece que se quiere soltar.
   * @throws IllegalStateException salta si se intenta soltar una Piece cuando no se puede.
   */
  public void drop(BoardPiece b) throws IllegalStateException {
    if ((fallingBlock == null) || (lastTick)) {
      fallingBlock = b;
      currentBlockRow = 0;
      currentBlockColumn = (this.columns / 2) - (b.width() / 2);
    } else {
      throw new IllegalStateException(Board.ALREADY_FALLING);
    }
  }

  /**
   * Método para que la situación de Board avance un tick.
   */
  public void tick() {
    if (fallingBlock != null) {
      if (!lastTick) {
        currentBlockRow++;
        if (reached_bottom() || touched_another_block()) {
          lastTick = true;
        }
      } else {
        fill_with(board, toString());
        fallingBlock = null;
        lastTick = false;
      }
    }
  }

  private void fill_with(char[][] matrix, char c) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = c;
      }
    }
  }

  private void fill_with(char[][] matrix, String s) {
    String[] rows = s.split("\n");
    for (int i = 0; i < rows.length; i++) {
      char[] column = rows[i].toCharArray();
      for (int j = 0; j < column.length; j++) {
        matrix[i][j] = column[j];
      }
    }
  }

  private boolean reached_bottom() {
    int reachedRow = currentBlockRow;
    String[] s = fallingBlock.toString().split("\n");

    for (int i = 0; i < s.length; i++) {
      if (s[i].replace(BoardPiece.EMPTY, ' ').trim().length() != 0) {
        reachedRow++;
      }
    }

    return (reachedRow == rows);
  }

  private boolean reached_right() {
    int reachedCol = currentBlockColumn;
    String[] s = fallingBlock.toString().split("\n");

    for (int i = 0; i < s.length; i++) {
      if (s[i].replace(BoardPiece.EMPTY, ' ').trim().length() != 0) {
        reachedCol++;
      }
    }

    return (reachedCol == columns - 1);
  }

  private boolean reached_left() {
    int reachedCol = currentBlockColumn;
    String[] s = fallingBlock.toString().split("\n");

    for (int i = s.length - 1; i > 0; i--) {
      if (s[i].replace(BoardPiece.EMPTY, ' ').trim().length() != 0) {
        reachedCol--;
      }
    }

    return (reachedCol == -1);
  }

  private boolean touched_another_block() {
    for (int i = 0; i < rows - 1; i++) {
      for (int j = 0; j < columns; j++) {
        if ((board[i + 1][j] != BoardPiece.EMPTY) && falling_block_is_at(i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean falling_block_is_at(int row, int column) {
    if (fallingBlock != null) {
      return ((currentBlockRow <= row) && (row < currentBlockRow + fallingBlock.height())
          && (currentBlockColumn <= column)
          && (column < currentBlockColumn + fallingBlock.width()) && (!fallingBlock
            .is_hollow_at(row - currentBlockRow,
                column - currentBlockColumn + fallingBlock.width() / 2 - 1)));
    } else {
      return false;
    }
  }

  /**
   * Método para mover la Piece que está cayendo a la izquierda.
   * @throws IllegalStateException salta si se intenta mover la Piece cuando no se puede.
   */
  public void moveLeft() throws IllegalStateException {
    if (fallingBlock != null) {
      if (!lastTick) {
        if (reached_left()) {
          throw new IllegalStateException(Board.OUT_OF_BOARD);
        }
        currentBlockColumn--;
      } else {
        fill_with(board, toString());
        fallingBlock = null;
        lastTick = false;
      }
    }
  }


  /**
   * Método para mover la Piece que está cayendo a la derecha.
   */
  public void moveRight() {
    if (fallingBlock != null) {
      if (!lastTick) {
        if (reached_right()) {
          throw new IllegalStateException(Board.OUT_OF_BOARD);
        }
        currentBlockColumn++;
      } else {
        fill_with(board, toString());
        fallingBlock = null;
        lastTick = false;
      }
    }
  }

  /**
   * Método para mover la Piece que está cayendo hacia abajo.
   */
  public void moveDown() {
    if (fallingBlock != null) {
      if (!lastTick) {
        currentBlockRow++;
        if (reached_bottom() || touched_another_block()) {
          lastTick = true;
        }
      } else {
        fill_with(board, toString());
        fallingBlock = null;
        lastTick = false;
      }
    }
  }

}