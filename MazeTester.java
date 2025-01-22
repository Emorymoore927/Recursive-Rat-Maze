import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        //Creating a new scanner object
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();

        //Creating a maze object
        Maze labyrinth = new Maze(filename);

        //Printing out the maze
        System.out.println("");
        System.out.println("The maze:");
        System.out.println(labyrinth);

        //Creating a MazeSolver object
        MazeSolver solver = new MazeSolver(labyrinth);

        //Calling the traverse method from MazeSolver
        if (solver.traverse(labyrinth.startRow, labyrinth.startCol)) {
            System.out.println("");
            System.out.println("The maze was successfully traversed!");
            System.out.println("Number of times solver was called: " + MazeSolver.getCount());
            System.out.println("Number of breadcrumbs: " + labyrinth.getBreadcrumb());

        }
        else {
            System.out.println("There is no possible path.");
        }

        //Printing out the solution to the maze
        System.out.println("");
        System.out.println("Solution:" + labyrinth);
    }
}
