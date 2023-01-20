/**
 * Class that implements DisplayableMaze and contains
 * information for the maze to be displayed graphically
 */
public class Maze implements DisplayableMaze {

    //maze grid storage 
    private MazeContents [][] mazeContent;

    /**
     * Constructor for class Maze
     * @param mazeContent a 2D array of MazeContents 
     */
    public Maze(MazeContents [][] mazeContent) {
      this.mazeContent = mazeContent;
    }

    /** @return 2D array of maze grid */
    public MazeContents [][] getMazeContents() {
      return this.mazeContent;
    }
  
    /** @return height of maze grid */
    public int getHeight() {
      return mazeContent.length;
    }

    /** @return width of maze grid */
    public int getWidth() {
      return mazeContent[0].length;
    }

    /** @return contents of maze grid at row i, column j */
    public MazeContents getContents(int i, int j) {
      // returns a wall for any coordinates outside the maze boundary
      if (i >= getHeight() || j >= getWidth() || i < 0 || j < 0) {
        return MazeContents.WALL;
      }
      else {
        return mazeContent[i][j];
      }
    }

    /** @return location of maze start point */
    public MazeLocation getStart() {
      int row = 0;
      int col = 0;
      for (int i = 0; i < getHeight(); i++) {
        for (int j = 0; j < getWidth(); j++) {
          if (getContents(i,j) == MazeContents.START) {
            row = i;
            col = j;
          }
        }
      }
      return new MazeLocation(row,col);
    }

    /** @return location of maze finish point */
    public MazeLocation getFinish() {
      int row = 0;
      int col = 0;
      for (int i = 0; i < getHeight(); i++) {
        for (int j = 0; j < getWidth(); j++) {
          if (getContents(i,j) == MazeContents.END) {
            row = i;
            col = j;
          }
        }
      }
      return new MazeLocation(row,col);
    }
}
