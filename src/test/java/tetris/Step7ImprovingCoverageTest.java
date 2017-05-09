package tetris;

import static org.junit.Assert.assertTrue;

import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Test;



//@RunWith(NestedJUnit.class)
public class Step7ImprovingCoverageTest extends ExecutionContext {

  // private final Board board = new Board(6, 8);
  private final Block block = new Block('a');

  @Test
  public void is_hollow_at_test() {
    assertTrue(block.is_hollow_at(1, 1));
  }

}
