/*
 * Philip Booth
 * 04/8/2024
 * Project 5
 * CS231
 * Purpose: Board class creates the sudoku board and all its attributes
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;


public class Board {
    //fields
    private Cell[][] cells;
    public static int SIZE;
    public int gridSize = (int) Math.sqrt(SIZE);
    public boolean finished = false;
    
    public Board() {

        SIZE = 9;
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <SIZE; j++) {//nested for loop to create each individual cell
                cells[i][j] = new Cell(i,j,0);
            }
        }
    }


    //Constructor with a filename param
    public Board(String filename) {
        this();
        read(filename);
    }

    //Constructor with numlock
    public Board(int numlock) {
        this();

        while (this.numLocked() < numlock) {
            Random rand1 = new Random();
            Random rand2 = new Random();
            Random rand3 = new Random();
            int randRow = rand1.nextInt(0,SIZE);// should give a random val between 0-9. Not sure if 0 included
            int randCol = rand2.nextInt(0,SIZE);// should give a random val between 0-9. Not sure if 0 included
            int randVal = rand3.nextInt(1,SIZE+1);
            
            if (cells[randRow][randCol].isLocked()) {
                continue;
            }
            
            if (validValue(randRow, randCol, randVal)) {
                cells[randRow][randCol].setValue(randVal);
                cells[randRow][randCol].setLocked(true);

            }
        }
    }
    //Extension
    public Board(int numLocked, int size) {
        //creates a new 2D array of Cells that is size by size, 
        //initializes each location in the grid with a new Cell with value 0.
        //randomly choose numLocked cells which to give a fixed original value (1). 
        SIZE = 9;
        double sqrt = Math.sqrt(size);
        if (sqrt != Math.floor(sqrt)) {
          System.out.println("Invalid Size. Size must be a perfect square.");
          return;
        }
        if(size>25){
          System.out.println("Invalid Size. Size must be 25 or smaller. ");
        }
        SIZE = size;
        cells = new Cell[SIZE][SIZE];
        Random rand = new Random();
    
        for (int i = 0; i < SIZE; i++) {
          for (int j = 0; j < SIZE; j++) {
            cells[i][j] = new Cell(i, j, 0);
          }
        }
    
        int i = 0;
        while(i<numLocked){
          int num = rand.nextInt(SIZE)+1;
          int randRow = rand.nextInt(SIZE);
          int randCol = rand.nextInt(SIZE);
    
          if(validValue(randRow, randCol, num)){
            set(randRow, randCol, num);
            set(randRow, randCol, true);
            i++;
          }
        }
      }


    public int getCols() {
        return SIZE;
    }

    public int getRows() {
        return SIZE;
    }


    public Cell get(int row, int col) {
        return cells[row][col];
    }


    public boolean isLocked(int r, int c) {
        return cells[r][c].isLocked();
    }


    public int numLocked() {
        int counter = 0;
        for (int i = 0; i < getRows(); i++) {
            for(int j = 0; j < getCols(); j++) {

                if (get(i, j).isLocked()) {
                    counter++;
                }
            }
        }
        return counter;
    }

    //These following methods setters and getters
    public int value(int r, int c) {
        return cells[r][c].getValue();
    }

    public void set(int row, int col, int value) {
        cells[row][col].setValue(value);
    }


    public void set(int row, int col, boolean locked) {
        cells[row][col].setLocked(locked);
    }

//————————————————————————————————————————————————————————————————————————————————————————————————
    public boolean read(String filename) {
    try {
      // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
      FileReader fr = new FileReader(filename);
      // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
      BufferedReader br = new BufferedReader(fr);
      
      // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
      String line = br.readLine();
      int row = 0;
      // start a while loop that loops while line isn't null
      while(line != null){
          // print line
	  System.out.println( line );
          // assign to an array of Strings the result of splitting the line up by spaces (line.split("[ ]+"))
        String[] arr = line.split( "[ ]+" );
       // —————————————————————————————————
        for (int i = 0; i < arr.length; i++) {
            set(row, i, Integer.parseInt(arr[i]));
            if (Integer.parseInt(arr[i]) != 0) {
                set(row, i ,true);
            }
        }
        //—————————————————————————————————
          // let's see what this array holds: 
          System.out.println("the first item in arr: " + arr[0] + ", the second item in arr: " + arr[1]);
          // print the size of the String array (you can use .length)
          System.out.println( arr.length );
          // use the line to set various Cells of this Board accordingly
          // assign to line the result of calling the readLine method of your BufferedReader object.
          row+=1;
          line = br.readLine();

      }
      // call the close method of the BufferedReader
      br.close();
      return true;
    }
    catch(FileNotFoundException ex) {
      System.out.println("Board.read():: unable to open file " + filename );
    }
    catch(IOException ex) {
      System.out.println("Board.read():: error reading file " + filename);
    }

    return false;
  }
  //————————————————————————————————————————————————————————————————————————————————————————————————

  //Compares value against every other value in it's row, then column, then local grid
  public boolean validValue(int row, int col, int value) {
    if (value < 1 || value > SIZE) {
        return false; //Value is outside 1-9
    }
    if (row >= SIZE || col >= SIZE) {
        return false; //row or column is outside the grid
    }
    //iterate to your specified row and check each column
    for (int i = 0; i < SIZE; i++) {
        if (i == col) {
            continue; //line excludes checking duplicate parameter value 
        }

        if (value == cells[row][i].getValue()) {
            return false;
        } 
    }

    for (int i = 0; i < SIZE; i++) {
        if (i == row) {
            continue; //line excludes checking duplicate parameter value 
        }

        if (value == cells[i][col].getValue()) {
            return false;
        } 
    }


    //received help from professor Bender when writing this code
    
    int squareRoot = (int) Math.sqrt(SIZE);//readjusts depending on board size
    int startRow = squareRoot * (row / squareRoot);
    int startCol = squareRoot * (col / squareRoot);
    for (int i = startRow; i < startRow + squareRoot; i++){
        for(int j  = startCol; j < startCol + squareRoot; j++){
        if ((i!=row || j != col) && get(i, j).getValue() == value){
            return false;
          }
        }
      }
        return true;

}


//checks for a valid solution 
public boolean validSolution() {
    for (int i = 0; i <SIZE; i++) {
        for (int j = 0; j <SIZE; j++) {
            int val = cells[i][j].getValue();//placeholder
            if (validValue(i,j,val) == false) {
                return false;
            }
        }
    }
    return true;
}


public String toString() {
    // prints out board
    String result = "";
    int squareRoot = (int) Math.sqrt(SIZE);
    for (int row = 0; row < SIZE; row++) {
      if (row % squareRoot == 0 && row != 0) {
        result += "\n";
      }
      for (int col = 0; col < SIZE; col++) {
        if (col % SIZE == 0 && col != 0) {
          result += "\n";
        }
        else if (col % squareRoot == 0 && col != 0) {
          result += "  ";
        }
        result += cells[row][col].getValue();
        result += " ";
      }
      result += "\n";
    }
    return result;
  }

public void draw(Graphics g, int scale){
    // draws the board
    int squareRoot = (int) Math.sqrt(SIZE);
    for(int i = 0; i<getRows(); i++){
        for(int j = 0; j<getCols(); j++){
            get(i, j).draw(g, j*scale+5, i*scale+10, scale);
            if(i % squareRoot == 0 && i != 0){// checks if its time to draw a line
              g.setColor(Color.BLACK);
              g.drawLine(0, i*scale-5, 800, i*scale-5);
            }
            if(j % squareRoot == 0 && j != 0){
              g.setColor(Color.BLACK);
              g.drawLine(j*scale-5, 0, j*scale-5, 800);
            }
        }
    } 

    if(finished){
        if(validSolution()){
            g.setColor(new Color(0, 127, 0));
            g.drawChars("Hurray!".toCharArray(), 0, "Hurray!".length(), scale*3+5, scale*10+10);
        } else {
            g.setColor(new Color(127, 0, 0));
            g.drawChars("No solution!".toCharArray(), 0, "No Solution!".length(), scale*3+5, scale*10+10);
        }
    }
}

public static void main(String[] args) {
    Board sudoku = new Board();
    System.out.println(sudoku.toString());
    }


public void randomPermute() {
        int[] permutation = new int[getRows()];
        Random rand = new Random();
        for(int i = 0; i < getRows(); i++){
            int swapIndex = rand.nextInt(i + 1);
            permutation[i] = permutation[swapIndex];
            permutation[swapIndex] = i;
        }
    
        for(int r = 0; r < getRows(); r++){
            for(int c = 0; c < getCols(); c++){
                set(r, c, permutation[value(r, c) - 1] + 1);
            }
        }
    }
}

