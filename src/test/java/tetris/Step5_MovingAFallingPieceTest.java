// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;

import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(NestedJUnit.class)
public class Step5_MovingAFallingPieceTest extends Assert {

    // Step 5: It's your turn now
    // - Remove the @Ignore annotation from this class
    // - The test names have been provided, you just need to fill in the test body
    // - Next step: RotatingAFallingPieceTest
	private final Board board = new Board(6, 8);

	public class Moving_falling_pieces{
		// TODO: a falling piece can be moved left
		@Before
		public void dropPieceAndLetItFall(){
			board.drop(Tetromino.T_SHAPE);
			board.tick();
			board.tick();
		}
		
		@Test
		public void falling_piece_can_be_moved_left(){
			
			board.moveLeft();
			
			assertEquals("" +
	                "........\n" +
	                "........\n" +
	                "...T....\n" +
	                "..TTT...\n" +
	                "........\n" +
	                "........\n", board.toString());
	        assertTrue(board.hasFalling());
		}
	    // TODO: a falling piece can be moved right
		@Test
		public void falling_piece_can_be_moved_right(){
			board.moveRight();
			assertEquals("" +
	                "........\n" +
	                "........\n" +
	                ".....T..\n" +
	                "....TTT.\n" +
	                "........\n" +
	                "........\n", board.toString());
	        assertTrue(board.hasFalling());
		}
	    // TODO: a falling piece can be moved down
		@Test
		public void falling_piece_be_moved_down(){
			board.moveDown();
			assertEquals("" +
	                "........\n" +
	                "........\n" +
	                "........\n" +
	                "....T...\n" +
	                "...TTT..\n" +
	                "........\n", board.toString());
	        assertTrue(board.hasFalling());
		}
	}
    
	public class Pieces_will_not_go_out_of_the_board{
		
		@Before
		public void dropPieceAndLetItFall(){
			board.drop(Tetromino.T_SHAPE);
			board.tick();
			board.tick();
		}
		
		// TODO: it will not move left over the board
		@Test
		public void will_not_go_over_left(){
			board.moveLeft();
			board.moveLeft();
			board.moveLeft();
            MyAsserts.assertThrows(IllegalStateException.class, "out of board",
                    () -> board.moveLeft());
            assertEquals("" +
	                "........\n" +
	                "........\n" +
	                ".T......\n" +
	                "TTT.....\n" +
	                "........\n" +
	                "........\n", board.toString());
	        assertTrue(board.hasFalling());
            
		}
	    // TODO: it will not move right over the board
		@Test
		public void will_not_go_over_right(){
			board.moveRight();
			board.moveRight();
            MyAsserts.assertThrows(IllegalStateException.class, "out of board",
                    () -> board.moveRight());
            assertEquals("" +
	                "........\n" +
	                "........\n" +
	                "......T.\n" +
	                ".....TTT\n" +
	                "........\n" +
	                "........\n", board.toString());
	        assertTrue(board.hasFalling());
		}
	    // TODO: it will not move down over the board (will stop falling)
		@Test
		public void will_not_move_down_the_board(){
			board.moveDown();
			board.moveDown();
			board.moveDown();
			assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
            assertFalse(board.hasFalling());
		}
	}
    
	public class Pieces_cannot_move_if_blocked{
		@Before
		public void dropPieceAndLetItFall(){
			board.drop(Tetromino.T_SHAPE);
			board.tick();
			board.tick();
			board.tick();
			board.tick();
			board.tick();
		}
	    // TODO: it cannot be moved left if another piece is in the way
		@Test
		public void cannot_be_moved_left_if_another_piece_is_in_the_way(){
			board.drop(Tetromino.T_SHAPE);
			board.moveRight();
			board.moveRight();
			board.tick();
			board.tick();
			board.tick();
			board.moveLeft();
			assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "......T.\n" +
                    "....TTTT\n" +
                    "...TTT..\n", board.toString());
            assertFalse(board.hasFalling());
		}
	    // TODO: it cannot be moved right if another piece is in the way
		@Test
		public void cannot_be_moved_right_if_another_piece_is_in_the_way(){
			board.drop(Tetromino.T_SHAPE);
			board.moveLeft();
			board.moveLeft();
			board.tick();
			board.tick();
			board.tick();
			board.moveRight();
			assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "..T.....\n" +
                    ".TTTT...\n" +
                    "...TTT..\n", board.toString());
            assertFalse(board.hasFalling());
		}
	    // TODO: it cannot be moved down if another piece is in the way (will stop falling)
		@Test
		public void cannot_be_moved_down_if_another_piece_is_in_the_way(){
			board.drop(Tetromino.T_SHAPE);
			board.tick();
			board.tick();
			board.moveDown();
			assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
            assertFalse(board.hasFalling());
		}
	}


    // P.S. Take into consideration, that part of the piece's area may be empty cells.
    // Only non-empty cells should take part in the collision checks.
}
