// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import static org.junit.Assert.assertEquals;

import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Test;

/**
 * @author Esko Luontola.
 */
// @RunWith(NestedJUnit.class)
public class Step2RotatingPiecesOfBlocksTest extends ExecutionContext {

  // Step 2: Stepping stone for rotation algorithms
  // - Remove the @Ignore annotation from this class
  // - See README for motivation
  // - Next step: RotatingTetrominoesTest

  private Piece piece;

  @Test
  public void consists_of_many_blocks() {
    piece = new Piece("" + ".X.\n" + ".X.\n" + "...\n");
    assertEquals("" + ".X.\n" + ".X.\n" + "...\n", piece.toString());
  }

  @Test
  public void can_be_rotated_right() {
    piece = new Piece("" + ".X.\n" + ".X.\n" + "...\n");
    piece = piece.rotateRight();
    assertEquals("" + "...\n" + ".XX\n" + "...\n", piece.toString());
  }

  @Test
  public void can_be_rotated_left() {
    piece = new Piece("" + ".X.\n" + ".X.\n" + "...\n");
    piece = piece.rotateLeft();
    assertEquals("" + "...\n" + "XX.\n" + "...\n", piece.toString());
  }

  @Test
  public void consists_of_many_blocks1() {
    piece = new Piece("" + "..XXX\n" + "..XX.\n" + "..X..\n" + ".....\n" + ".....\n");
    assertEquals("" + "..XXX\n" + "..XX.\n" + "..X..\n" + ".....\n" + ".....\n", piece.toString());
  }

  @Test
  public void can_be_rotated_right1() {
    piece = new Piece("" + "..XXX\n" + "..XX.\n" + "..X..\n" + ".....\n" + ".....\n");
    piece = piece.rotateRight();
    assertEquals("" + ".....\n" + ".....\n" + "..XXX\n" + "...XX\n" + "....X\n", piece.toString());
  }

  @Test
  public void can_be_rotated_left1() {
    piece = new Piece("" + "..XXX\n" + "..XX.\n" + "..X..\n" + ".....\n" + ".....\n");
    piece = piece.rotateLeft();
    assertEquals("" + "X....\n" + "XX...\n" + "XXX..\n" + ".....\n" + ".....\n", piece.toString());
  }

}
