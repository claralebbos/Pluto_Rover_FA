import java.util.Arrays;

public class Pluto {

  public int height;
  public int width;
  private Obstacles[][] plutoGrid;

  public Pluto(int height, int width) {
    this.plutoGrid = new Obstacles[height][width];
    this.height = height;
    this.width = width;
    //Initialize all squares in grid to not be an obstacle
    for (Obstacles[] row : plutoGrid) {
      Arrays.fill(row, Obstacles.NULL);
    }
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public Obstacles[][] getPlutoGrid() {
    return this.plutoGrid;
  }

  public Obstacles getObstacle(int x, int y) {
    int plutoHeight = this.getHeight();
    int plutoWidth = this.getWidth();
    Obstacles[][] plutoGrid = this.getPlutoGrid();

    return plutoGrid[(x + plutoWidth) % plutoWidth][(y + plutoHeight) %
        plutoHeight];
  }

  public Obstacles[][] addObstacle(int x, int y, Obstacles obstacles) {
    int plutoHeight = this.getHeight();
    int plutoWidth = this.getWidth();
    Obstacles[][] plutoGrid = this.getPlutoGrid();
    int newX = Math.abs((x + plutoWidth) % plutoWidth);
    int newY = Math.abs((y + plutoHeight) % plutoHeight);

    plutoGrid[newX][newY] = obstacles;
    return plutoGrid;
  }
}