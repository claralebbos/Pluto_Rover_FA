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
          if (!move(1)) {
            break loop;
          }
          break;
        case 'B':
          if (!move(-1)) {
            break loop;
          }
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
    Orientation[] orientations = Orientation.values();
    int numOfOrientation = orientations.length;

    int orientationIndex = this.orientation.ordinal();
    int newIndex = (orientationIndex + i + numOfOrientation) % numOfOrientation;

    this.orientation = orientations[newIndex];
  }

  private boolean move(int i) {
    int height = pluto.getHeight();
    int width = pluto.getWidth();

    int oldX = this.currLocation.x;
    int oldY = this.currLocation.y;

    switch (this.orientation) {
      case NORTH:
        this.currLocation.y = (currLocation.y + i) % height;
        break;
      case EAST:
        this.currLocation.x = (currLocation.x + i) % width;
        break;
      case SOUTH:
        this.currLocation.y = (currLocation.y - i) % height;
        break;
      case WEST:
        this.currLocation.x = (currLocation.x - i) % width;
        break;
    }

    if (this.currLocation.y < 0) {
      this.currLocation.y = height + this.currLocation.y;
    }

    Obstacles obstacle = pluto.getObstacle(this.currLocation.x, this.currLocation.y);
    if (obstacle != Obstacles.NULL) {
      this.currLocation.x = oldX;
      this.currLocation.y = oldY;
      detectedObstacle(obstacle);
      return false;
    }
    return true;
  }

  private void detectedObstacle(Obstacles obstacle) {
    System.out.println("An Obstacle of type " + obstacle +
        " has been encountered at location" + getCurrLocation());
  }


}