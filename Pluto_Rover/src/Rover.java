public class Rover {

  private Location currLocation;
  private Orientation orientation;
  private Pluto pluto;

  public Rover(Pluto pluto) {
    this.pluto = pluto;
    this.currLocation = new Location(0, 0);
    this.orientation = Orientation.NORTH;
  }

  public Location getCurrLocation() {
    return this.currLocation;
  }

  public Orientation getOrientation() {
    return this.orientation;
  }
}