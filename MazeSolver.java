/** 
 * Class that implements recursive `solve` method
 * and also runs the recursive maze solover from the maze content in a file
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MazeSolver {

  // Maze
  private Maze maze;
  // MazeViewer
  private MazeViewer viewer;

  /**
   * Constructor for class MazeSolver
   * @param maze an object of Maze    
   * @param viewer an object of MazeViewer
   */
  public MazeSolver(Maze maze, MazeViewer viewer) {
    this.maze = maze;
    this.viewer = viewer;
  }

  /**
   * Run the recursive maze solover from the maze content in a file
   * 
   * @param args[0] The file that contains the maze content if provided  
   **/
  public static void main(String[] args) {
    int numRow = 0;
    int numCol = 0;
    Scanner input;

    ArrayList<Character> fileContents = new ArrayList<Character>();
    try {
      if (args.length == 0) {
        // If no command line argument is provided, read the maze from the standard input.
        input = new Scanner(System.in);
      } else {
        // If a command line argument is provided, load the maze from the file of that name
        File text = new File(args[0]);

        // Creating Scanner instance to read File in Java
        input = new Scanner(text);
      }

      while (input.hasNextLine()) {
        // Read one line of input from file
        String line = input.nextLine();
        // Convert the input to array of Chars
        char[] mazeChar = line.toCharArray();
        numCol = mazeChar.length;
        for (char ch : mazeChar) {
          fileContents.add(ch);
        }
        numRow++;
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // Convert maze content in the file to 2D array of MazeContents
    MazeContents[][] mazeContents = convertToMazeContents(fileContents, numRow, numCol);

    Maze maze = new Maze(mazeContents);
    MazeViewer viewer = new MazeViewer(maze);
    MazeSolver solver = new MazeSolver(maze, viewer);

    // Run the recursive maze solver from the maze start point
    boolean isSuccessful = solver.recursiveExplorer(maze.getStart());
    if (isSuccessful) {
      System.out.println("Solution was found!");
    } else {
      System.out.println("Solution was not found :(");
    }
  }

  /**
   * Convert maze content in the file to 2D array of MazeContents
   * @param fileContents an ArrayList contains the characters in the file 
   * @param numRow number of rows for the 2D array of MazeContents
   * @param numCol number of columns for the 2D array of MazeContents
   * @return 2D array of MazeContents
   */
  private static MazeContents[][] convertToMazeContents(ArrayList<Character> fileContents, int numRow, int numCol) {
    MazeContents[][] mazeContents = new MazeContents[numRow][numCol];
    int elementNum = 0;
    for (int i = 0; i < numRow; i++) {
      for (int j = 0; j < numCol; j++) {
        if (fileContents.get(elementNum) == '#') {
          mazeContents[i][j] = MazeContents.WALL;
        } else if (fileContents.get(elementNum) == 'S') {
          mazeContents[i][j] = MazeContents.START;
        } else if (fileContents.get(elementNum) == '.' || fileContents.get(elementNum) == ' ') {
          mazeContents[i][j] = MazeContents.OPEN;
        } else if (fileContents.get(elementNum) == 'F') {
          mazeContents[i][j] = MazeContents.END;
        }
        elementNum++;
      }
    }
    return mazeContents;
  }

  /**
   * Recursive maze `solve` method
   * @param location current location of maze grid
   * @return true if success or false if not the correct path to the exit
   */
  public boolean recursiveExplorer(MazeLocation location) {
     
    // Include a short delay
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
    };

    // If the current location is already visited or a wall then just return false 
    if (maze.getContents(location.getRow(), location.getCol()).equals(MazeContents.VISITED)
        || maze.getContents(location.getRow(), location.getCol()).equals(MazeContents.WALL) 
        || maze.getContents(location.getRow(), location.getCol()).equals(MazeContents.DEAD_END)) {
      return false;
    }

    // If the current location is the finish of the maze then return true.
    if (location.equals(maze.getFinish())) {
      // mark the current square as part of the path before returning.
      maze.getMazeContents()[location.getRow()][location.getCol()] = MazeContents.PATH;
      return true;
    }

    // Mark the current square as visited
    maze.getMazeContents()[location.getRow()][location.getCol()] = MazeContents.VISITED;

    // Make recursive calls to determine if exit is reachable through the square adjacent to the north, or the south, or the east, or the west. 
    if (recursiveExplorer(location.neighbor(MazeDirection.NORTH))
        || recursiveExplorer(location.neighbor(MazeDirection.SOUTH))
        || recursiveExplorer(location.neighbor(MazeDirection.EAST))
        || recursiveExplorer(location.neighbor(MazeDirection.WEST))) {
      maze.getMazeContents()[location.getRow()][location.getCol()] = MazeContents.PATH;
      return true;
    } else {
      maze.getMazeContents()[location.getRow()][location.getCol()] = MazeContents.DEAD_END;
      return false;
    }
  }
}
