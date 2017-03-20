// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;

public class MyAsserts {

  /**
   * Método para que el assert lance excepciones.
   * @param expectedException la excepción que se espera.
   * @param expectedMessage el mensaje que se espera.
   * @param command un comando.
   */
  public static void assertThrows(Class<?> expectedException, String expectedMessage,
      Command command) {
    try {
      command.run();
    } catch (Throwable t) {
      assertThat("thrown exception", t, instanceOf(expectedException));
      assertThat("exception message", t.getMessage(), containsString(expectedMessage));
      return;
    }
    throw new AssertionError("Expected to throw " + expectedException.getName()
        + ", but did not throw anything");
  }

  public interface Command {
    void run() throws Throwable;
  }
}
