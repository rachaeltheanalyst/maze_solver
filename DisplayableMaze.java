/**
 *  Interface for mazes to be displayed graphically
 */
public interface DisplayableMaze {
    /** @return height of maze grid */
    public int getHeight();

    /** @return width of maze grid */
    public int getWidth();

    /** @return contents of maze grid at row i, column j */
    public MazeContents getContents(int i, int j);

    /** @return location of maze start point */
    public MazeLocation getStart();

    /** @return location of maze finish point */
    public MazeLocation getFinish();
}
