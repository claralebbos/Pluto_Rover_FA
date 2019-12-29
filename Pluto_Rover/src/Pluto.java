public class Pluto {

  public int height;
  public int width;
  public int[][] plutoGrid;

  public Pluto(int height, int width) {
    this.plutoGrid = new int[height][width];
    this.height = height;
    this.width = width;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }
}