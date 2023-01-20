/**  
 * Class that runs the recursive maze solover  
 * with the hardcoded maze grid storage
 */

class Main {
  //hard-code the maze grid storage
  private static MazeContents[][] mazeContent =   
           {
                    {MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.START, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL,
                            MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN,
                            MazeContents.OPEN, MazeContents.OPEN, MazeContents.OPEN, MazeContents.WALL, MazeContents.END, MazeContents.WALL},

                    {MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL,
                            MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL, MazeContents.WALL}};

/**
 * Run the recursive maze solover with the hard-coded maze grid storage
 **/
  public static void main(String[] args) {
    Maze maze = new Maze(mazeContent);
    MazeViewer viewer = new MazeViewer(maze);
    MazeSolver solver = new MazeSolver(maze, viewer);

    boolean isSuccessful= solver.recursiveExplorer(maze.getStart());
    if (isSuccessful) {
      System.out.println("Solution was found!");
    }
    else {
      System.out.println("Solution was not found :(");
    }
  }
}
