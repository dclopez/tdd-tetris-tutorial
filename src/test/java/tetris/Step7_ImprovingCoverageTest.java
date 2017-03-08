package tetris;


import net.orfjackal.nestedjunit.NestedJUnit;

import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(NestedJUnit.class)
public class Step7_ImprovingCoverageTest extends Assert{

	//private final Board board = new Board(6, 8);
	private final Block block = new Block('a');
	
	@Test
	public void is_hollow_at_test(){
		assertTrue(block.is_hollow_at(1, 1));
	}

}
