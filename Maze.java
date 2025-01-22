/* Name: Emory Moore
# Date: 4/3/2023
# Class: CSC1120
# Pledge: I have neither given nor received unauthorized aid on this program.
# Description: Recursive Rat Maze is a program that simulates a virtual rat finding cheese in a maze.
# Input: The program reads test files from the maze.txt files.
# Output:The program will display the original maze, each position of the rat, and the overall solution to the maze.
*/

import java.util.*;
import java.io.*;
import static java.lang.Character.valueOf;

/**
 * Maze represents a maze of characters. The goal is to get from the
 * top left corner to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Maze
{
    //A variable that indicates the rat has visited that position.
    private static final int TRIED = 'T';

    //A variable that indicates a position is part of the solution.
    private static final int PATH = 'o';

    //A variable that indicates the rat has reached the cheese and the game is finished.
    private static final char DONE= 'C';

    //Variables that keep track of the starting and ending position of the rat.
    public int startRow, endRow, startCol, endCol;

    //The number of rows
    private int numberRows;

    //The number of columns
    private int numberColumns;

    //Holds the maze files' char data in a two-dimensional array
    private char[][] grid;

    //A variable that visually marks a position to be a part of the solution
    public int breadcrumb;


    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new char[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {
                grid[i][j] = scan.next().charAt(0);

                //Setting the starting position
                if (grid[i][j] == 'R') {
                    //System.out.println("The rat is located at row " + i + " column " + j);
                    startRow=getStartRow(i,j);
                    startCol=getStartCol(i,j);
                }

                //Setting the ending position
                if (grid[i][j]=='C'){
                    //System.out.println("Cheese is located at row " + i + " and column " + j);
                    endRow=getEndRow(i,j);
                    endCol=getEndCol(i,j);
                }

                /*if (grid[i][j]=='.') {
                    //System.out.println("Breadcrumb added at row " + i + " column " + j);
                    grid[i][j] = 'o';
                }*/

                }
            }
        }

        //Gets the starting row of the rat
    public int getStartRow(int row, int column){
        if (grid[row][column]=='R'){
            return row;
        }
        return 0;
    }

    //Gets the ending row of the cheese
    public int getEndRow(int r, int c){
        if (grid[r][c]=='C'){
            return r;
        }
        return 0;
    }

    //Gets the starting column of the rat
    public int getStartCol(int row, int col){
        if (grid[row][col]=='R'){
            return col;
        }
        return 0;
    }

    //Gets the ending column of the cheese
    public int getEndCol(int row, int column){
        if (grid[row][column]=='C'){
            return column;
        }
        return 0;
    }

    /**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col)
    {
        if (grid[row][col] != DONE) {
            grid[row][col] = TRIED;
        }
    }

    /**
     * Return the number of rows in this maze
     *
     * @return the number of rows in this maze
     */
    public int getRows()
    {
        return grid.length;
    }


    /**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */
    public int getColumns()
    {
        return grid[0].length;
    }


    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
        breadcrumb++;
    }

    //Gets the number of breadcrumbs
    public int getBreadcrumb(){
        return breadcrumb;
    }


    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */
    public boolean validPosition(int row, int column)
    {
        boolean result = false;

        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[row].length)

            //  check if cell is not blocked and not previously tried
            if (grid[row][column] == '.' || grid[row][column]=='R' || grid[row][column]=='C')

                result = true;

        return result;
    }


    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }

        return result;
    }
}

