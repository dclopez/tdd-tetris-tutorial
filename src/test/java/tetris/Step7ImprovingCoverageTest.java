package tetris;

import org.junit.Assert;
import org.junit.Test;



//@RunWith(NestedJUnit.class)
public class Step7ImprovingCoverageTest extends Assert {

  // private final Board board = new Board(6, 8);
  private final Block block = new Block('a');

  @Test
  public void is_hollow_at_test() {
    assertTrue(block.is_hollow_at(1, 1));
  }

}
