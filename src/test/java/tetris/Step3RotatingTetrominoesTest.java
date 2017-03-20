// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * @author Esko Luontola.
 */
// @RunWith(NestedJUnit.class)
public class Step3RotatingTetrominoesTest extends Assert {

  // Step 3: The actual rotation algorithms
  // - Remove the @Ignore annotation from this class
  // - See README for how "Tetromino" is different from "Piece"
  // - Next step: FallingPiecesTest

  private Tetromino shapeT;
  private Tetromino shapeI;
  private Tetromino shapeO;

  @Before
  public void createAnyShape() {
    shapeT = Tetromino.T_SHAPE;
  }

  @Test
  public void are_immutable() {
    String original = shapeT.toString();
    shapeT.rotateRight();
    assertEquals(original, shapeT.toString());
    shapeT.rotateLeft();
    assertEquals(original, shapeT.toString());
  }

  @Before
  public void createTShape() {
    shapeT = Tetromino.T_SHAPE;
  }

  @Test
  public void is_shaped_like_T() {
    assertEquals("" + ".T.\n" + "TTT\n" + "...\n", shapeT.toString());
  }

  @Test
  public void can_be_rotated_right_3_times() {
    shapeT = shapeT.rotateRight();
    assertEquals("" + ".T.\n" + ".TT\n" + ".T.\n", shapeT.toString());
    shapeT = shapeT.rotateRight();
    assertEquals("" + "...\n" + "TTT\n" + ".T.\n", shapeT.toString());
    shapeT = shapeT.rotateRight();
    assertEquals("" + ".T.\n" + "TT.\n" + ".T.\n", shapeT.toString());
  }

  //
  @Test
  public void can_be_rotated_left_3_times() {
    shapeT = shapeT.rotateLeft();
    assertEquals("" + ".T.\n" + "TT.\n" + ".T.\n", shapeT.toString());
    shapeT = shapeT.rotateLeft();
    assertEquals("" + "...\n" + "TTT\n" + ".T.\n", shapeT.toString());
    shapeT = shapeT.rotateLeft();
    assertEquals("" + ".T.\n" + ".TT\n" + ".T.\n", shapeT.toString());
  }

  @Test
  public void rotating_it_4_times_will_go_back_to_the_original_shape() {
    String originalShape = shapeT.toString();
    shapeT = shapeT.rotateRight().rotateRight().rotateRight().rotateRight();
    assertEquals(originalShape, shapeT.toString());
    shapeT = shapeT.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
    assertEquals(originalShape, shapeT.toString());
  }

  @Before
  public void createIShape() {
    shapeI = Tetromino.I_SHAPE;
  }

  @Test
  public void is_shaped_like_I() {
    assertEquals("" + "....\n" + "IIII\n" + "....\n" + "....\n", shapeI.toString());
  }

  @Test
  public void can_be_rotated_right_four_times() {
    shapeI = shapeI.rotateRight();
    assertEquals("" + "..I.\n" + "..I.\n" + "..I.\n" + "..I.\n", shapeI.toString());
    shapeI = shapeI.rotateRight();
    assertEquals("" + "....\n" + "....\n" + "IIII\n" + "....\n", shapeI.toString());
    shapeI = shapeI.rotateRight();
    assertEquals("" + ".I..\n" + ".I..\n" + ".I..\n" + ".I..\n", shapeI.toString());
    shapeI = shapeI.rotateRight();
    assertEquals("" + "....\n" + "IIII\n" + "....\n" + "....\n", shapeI.toString());
  }

  @Test
  public void can_be_rotated_left_four_times() {
    shapeI = shapeI.rotateLeft();
    assertEquals("" + ".I..\n" + ".I..\n" + ".I..\n" + ".I..\n", shapeI.toString());
    shapeI = shapeI.rotateLeft();
    assertEquals("" + "....\n" + "....\n" + "IIII\n" + "....\n", shapeI.toString());
    shapeI = shapeI.rotateLeft();
    assertEquals("" + "..I.\n" + "..I.\n" + "..I.\n" + "..I.\n", shapeI.toString());
    shapeI = shapeI.rotateLeft();
    assertEquals("" + "....\n" + "IIII\n" + "....\n" + "....\n", shapeI.toString());
  }

  @Test
  public void rotating_it_four_times_will_get_back_to_the_original_shape() {
    String originalShape = shapeI.toString();
    shapeI = shapeI.rotateRight().rotateRight().rotateRight().rotateRight();
    assertEquals(originalShape, shapeI.toString());
    shapeI = shapeI.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
    assertEquals(originalShape, shapeI.toString());
  }

  @Test
  public void rotating_it_twice_right_or_left_is_equivalent() {
    assertEquals(shapeI.rotateRight().rotateRight().toString(), shapeI.rotateLeft().rotateLeft()
        .toString());
  }

  @Before
  public void createOShape() {
    shapeO = Tetromino.O_SHAPE;
  }

  @Test
  public void is_shaped_like_O() {
    assertEquals("" + ".OO\n" + ".OO\n" + "...\n", shapeO.toString());
  }

  @Test
  public void can_be_rotated_right_four_times1() {
    shapeO = shapeO.rotateRight();
    assertEquals("" + "...\n" + ".OO\n" + ".OO\n", shapeO.toString());
    shapeO = shapeO.rotateRight();
    assertEquals("" + "...\n" + "OO.\n" + "OO.\n", shapeO.toString());
    shapeO = shapeO.rotateRight();
    assertEquals("" + "OO.\n" + "OO.\n" + "...\n", shapeO.toString());
    shapeO = shapeO.rotateRight();
    assertEquals("" + ".OO\n" + ".OO\n" + "...\n", shapeO.toString());
  }

  @Test
  public void can_be_rotated_left_four_times1() {
    shapeO = shapeO.rotateLeft();
    assertEquals("" + "OO.\n" + "OO.\n" + "...\n", shapeO.toString());
    shapeO = shapeO.rotateLeft();
    assertEquals("" + "...\n" + "OO.\n" + "OO.\n", shapeO.toString());
    shapeO = shapeO.rotateLeft();
    assertEquals("" + "...\n" + ".OO\n" + ".OO\n", shapeO.toString());
    shapeO = shapeO.rotateLeft();
    assertEquals("" + ".OO\n" + ".OO\n" + "...\n", shapeO.toString());
  }

  @Test
  public void rotating_it_four_times_will_get_back_to_the_original_shape1() {
    String originalShape = shapeO.toString();
    shapeO = shapeO.rotateRight().rotateRight().rotateRight().rotateRight();
    assertEquals(originalShape, shapeO.toString());
    shapeO = shapeO.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
    assertEquals(originalShape, shapeO.toString());
  }

  @Test
  public void rotating_it_twice_right_or_left_is_equivalent1() {
    assertEquals(shapeO.rotateRight().rotateRight().toString(), shapeO.rotateLeft().rotateLeft()
        .toString());
  }

}