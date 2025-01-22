/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeSolver
{
    //Creates a maze object
    private Maze maze;

    //Keeps track of the number of times the traverse method is called
    public static int count;

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }


    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(int row, int column)
    {
        boolean done = false;


        if (maze.validPosition(row, column))
        {
            System.out.println("The rat is located at: " + row + "," + column);
            maze.tryPosition(row, column);   // mark this cell as tried
            count++;

            if (row == maze.endRow && column == maze.endCol)
                done = true;  // the maze is solved

            else
            {
                if (!done)
                    done = traverse(row-1, column);  // north

                if (!done)
                    done = traverse(row+1, column);    // south

                if (!done)
                    done = traverse(row, column+1);  // east

                if (!done)
                    done = traverse(row, column-1);  // west
            }

            if (done)  // this location is part of the final path
                maze.markPath(row, column);
        }

        return done;
    }

    //Returns the number of times the traverse method was called
    public static int getCount(){
        return count;
    }
}
