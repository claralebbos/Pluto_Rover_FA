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

  public void commandParser(String command) {
    loop:
    for (char c : command.toCharArray()) {
      switch (c) {
        case 'F':
          move(1);
          break;
        case 'B':
          move(-1);
          break;
        case 'L':
          rotate(-1);
          break;
        case 'R':
          rotate(1);
          break;
        default:
          System.out.println(
              "Invalid Command " + c);
          break loop;
      }
    }
  }

  private void rotate(int i) {

  }

  private void move(int i) {

  }


}