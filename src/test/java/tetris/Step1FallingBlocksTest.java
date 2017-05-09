// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Test;

/**
 * @author Esko Luontola.
 */
// @RunWith(NestedJUnit.class)
public class Step1FallingBlocksTest extends ExecutionContext {

  // Step 1: Starting small
  // - See the README for motivation
  // - Next step: RotatingPiecesOfBlocksTest

  private final Board board = new Board(3, 3);

  @Test
  public void is_empty() {
    assertEquals("" + "...\n" + "...\n" + "...\n", board.toString());
  }

  @Test
  public void has_no_falling_blocks() {
    assertFalse(board.hasFalling());
  }

  @Test
  public void the_block_is_falling() {
    board.drop(new Block('X'));
    assertTrue(board.hasFalling());
  }

  @Test
  public void it_starts_from_the_top_middle() {
    board.drop(new Block('X'));
    assertEquals("" + ".X.\n" + "...\n" + "...\n", board.toString());
  }

  @Test
  public void it_moves_down_one_row_per_tick() {
    board.drop(new Block('X'));
    board.tick();
    assertEquals("" + "...\n" + ".X.\n" + "...\n", board.toString());
  }

  @Test
  public void at_most_one_block_may_be_falling_at_a_time() {
    board.drop(new Block('X'));
    MyAsserts.assertThrows(IllegalStateException.class, "already falling",
        () -> board.drop(new Block('Y')));
    assertEquals("" + ".X.\n" + "...\n" + "...\n", board.toString());
  }

  @Test
  public void it_is_still_falling_on_the_last_row() {
    board.drop(new Block('X'));
    board.tick();
    board.tick();
    assertEquals("" + "...\n" + "...\n" + ".X.\n", board.toString());
    assertTrue("the player should still be able to move the block", board.hasFalling());
  }

  @Test
  public void it_stops_when_it_hits_the_bottom() {
    board.drop(new Block('X'));
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "...\n" + "...\n" + ".X.\n", board.toString());
    assertFalse("the block should stop moving", board.hasFalling());
  }

  @Test
  public void it_is_still_falling_right_above_the_other_block() {
    board.drop(new Block('X'));
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "...\n" + "...\n" + ".X.\n", board.toString());
    assertFalse(board.hasFalling());

    board.drop(new Block('Y'));
    board.tick();
    assertEquals("" + "...\n" + ".Y.\n" + ".X.\n", board.toString());
    assertTrue("the player should still be able to avoid landing on the other block",
        board.hasFalling());
  }

  @Test
  public void it_stops_when_it_hits_the_other_block() {
    board.drop(new Block('X'));
    board.tick();
    board.tick();
    board.tick();
    assertEquals("" + "...\n" + "...\n" + ".X.\n", board.toString());
    assertFalse(board.hasFalling());

    board.drop(new Block('Y'));
    board.tick();
    board.tick();
    assertEquals("" + "...\n" + ".Y.\n" + ".X.\n", board.toString());
    assertFalse("the block should stop moving ", board.hasFalling());
  }

}