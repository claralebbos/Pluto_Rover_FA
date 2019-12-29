import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RoverTests {

  Pluto pluto = new Pluto(4, 4);
  Rover rover = new Rover(pluto);

  //Output

  private final ByteArrayOutputStream out = new ByteArrayOutputStream();
  private final ByteArrayOutputStream err = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;


  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(out));
    System.setErr(new PrintStream(err));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  //////TESTS///////

  @Test
  public void plutoHeightAndWidthInitialized() {
    assertEquals(pluto.getHeight(), 4);
    assertEquals(pluto.getWidth(), 4);
  }

  @Test
  public void roverIsInitiallyFacingNorth() {
    Location initialLocation = new Location(0,0);
    Orientation initialOrientation = Orientation.NORTH;

    assertEquals(rover.getCurrLocation().toString(), initialLocation.toString());
    assertEquals(rover.getOrientation(), initialOrientation);
  }

  @Test
  public void roverDoesNotExecuteInvalidCommand() {
    rover.commandParser("JF");
    assertEquals("Invalid Command J\n",
        out.toString());
  }

  @Test
  public void roverMovesForward() {
    rover.commandParser("F");
    assertEquals(rover.getCurrLocation(), new Location(0, 1));
    rover.commandParser("F");
    assertEquals(rover.getCurrLocation(), new Location(0, 2));
  }

  @Test
  public void roverMovesBackward() {
    rover.commandParser("FF");
    assertEquals(rover.getCurrLocation(), new Location(0, 2));
    rover.commandParser("B");
    assertEquals(rover.getCurrLocation(), new Location(0, 1));
  }

  @Test
  public void roverMovesForwardWithWrap() {
    rover.commandParser("FFFFR");
    assertEquals(rover.getCurrLocation(), new Location(0, 0));
  }

  @Test
  public void roverMovesBackwardWithWrap() {
    rover.commandParser("B");
    assertEquals(rover.getCurrLocation(), new Location(0, 3));
  }
}
