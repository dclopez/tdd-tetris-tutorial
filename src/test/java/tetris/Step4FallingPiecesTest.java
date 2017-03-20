// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author Esko Luontola.
 */
// @RunWith(NestedJUnit.class)
public class Step4FallingPiecesTest extends Assert {

  // Step 4: Safe steps
  // - Remove the @Ignore annotation from this class
  // - See the README for how to proceed with this refactoring in safe steps
  // - Next step: MovingAFallingPieceTest

  private final Board board = new Board(6, 8);

  @Test
  public void it_starts_from_top_middle() {
    board.drop(Tetromino.T_SHAPE);
    assertEquals("" + "....T...\n" + "...TTT..\n" + "........\n" + "........\n" + "........\n"
        + "........\n", board.toString());
  }

  @Test
  public void it_is_still_falling_on_the_last_row() {
    board.drop(Tetromino.T_SHAPE);
    board.tick();
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "........\n" + "........\n" + "........\n" + "........\n" + "....T...\n"
        + "...TTT..\n", board.toString());
    assertTrue(board.hasFalling());
  }

  @Test
  public void it_stops_when_it_hits_the_bottom() {
    board.drop(Tetromino.T_SHAPE);
    board.tick();
    board.tick();
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "........\n" + "........\n" + "........\n" + "........\n" + "....T...\n"
        + "...TTT..\n", board.toString());
    assertFalse(board.hasFalling());
  }

  @Test
  public void it_is_still_falling_right_above_the_other_piece() {
    board.drop(Tetromino.T_SHAPE);
    board.tick();
    board.tick();
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "........\n" + "........\n" + "........\n" + "........\n" + "....T...\n"
        + "...TTT..\n", board.toString());
    assertFalse(board.hasFalling());

    board.drop(Tetromino.T_SHAPE);
    board.tick();
    board.tick();
    assertEquals("" + "........\n" + "........\n" + "....T...\n" + "...TTT..\n" + "....T...\n"
        + "...TTT..\n", board.toString());
    assertTrue(board.hasFalling());
  }

  @Test
  public void it_stops_when_it_hits_the_other_piece() {
    board.drop(Tetromino.T_SHAPE);
    board.tick();
    board.tick();
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "........\n" + "........\n" + "........\n" + "........\n" + "....T...\n"
        + "...TTT..\n", board.toString());
    assertFalse(board.hasFalling());

    board.drop(Tetromino.T_SHAPE);
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "........\n" + "........\n" + "....T...\n" + "...TTT..\n" + "....T...\n"
        + "...TTT..\n", board.toString());
    assertFalse(board.hasFalling());
  }

}
