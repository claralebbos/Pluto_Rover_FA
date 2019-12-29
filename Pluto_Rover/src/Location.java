import java.util.Objects;

public class Location {
  public int x;
  public int y;

  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Location location = (Location) o;
    return x == location.x &&
        y == location.y;
  }

  @Override
  public String toString() {
    return "{" + "x=" + x + ", y=" + y + '}';
  }
}
