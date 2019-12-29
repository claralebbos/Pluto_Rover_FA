import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTests {

  Pluto pluto = new Pluto(4, 4);
  Rover rover = new Rover(pluto);

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

}
