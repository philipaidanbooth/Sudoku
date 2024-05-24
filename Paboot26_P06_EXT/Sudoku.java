/*
 * Philip Booth
 * 04/1/2024
 * Project 5
 * CS231
 * Purpose: combines all other classes and attempts to solve the sudoku puzzle
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    public Board board;
    public LandscapeDisplay ld;


    public Sudoku(int numLocked) {
        board = new Board(numLocked);
        ld = new LandscapeDisplay(board); // LandscapeDisplay addition
    }

    public Sudoku(int numVals, int size){
        // creates a new Board with some number of pre-determined randomly placed values.
        board = new Board(numVals, size);
        ld = new LandscapeDisplay(board);
    }


    // constructor that takes a filename
    public Sudoku(String filename) {
        board = new Board(filename);
        ld = new LandscapeDisplay(board); // LandscapeDisplay addition
    }

public int findNextValue(Cell cell) {
        // determines if there is a valid value for this cell that we haven't tried
        // returns that value if yes, returns 0 if no.
        int row = cell.getRow();
        int col = cell.getCol();

        for(int i  = cell.getValue() + 1; i <= board.SIZE; i++){
            if(board.validValue(row, col, i)){
                return i; }
            } 
            return 0;
            }
        
    
    


public Cell findNextCell() {
    for (int row = 0; row < board.getRows(); row++) {
        for (int col = 0; col < board.getCols() ; col++) {
            Cell curr = board.get(row, col);
            if (curr.getValue() == 0) {
                curr.setValue(findNextValue(curr));//set it equal to the next possible value
            
                if (curr.getValue() == 0) {//when theres no possible next val
                    return null;
                } else {
                    return curr;
                }
            }

        }     
    }
    return null;//if there are no cells with 0
}

public boolean solve(int delay) throws InterruptedException {
    LinkedList<Cell> solution = new LinkedList<>();
    long startTime = System.currentTimeMillis();// this is my timer setup so that if this method runs for >10secs, stop
    long timeout = 10000; // 10 seconds
    while(solution.size() < (board.SIZE * board.SIZE)){
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime > timeout) { //method runs for >10secs, stop
            System.out.println("Solve attempt timed out.");
            board.finished = true;
            return false; 
        }
        if(board.validSolution()){//checks if valid every iterations
            board.finished = true;
            break;
        }
        
        if (delay > 0) {//delay conditional
            Thread.sleep(delay);
            if (ld != null)
                ld.repaint();
        }
        Cell next = findNextCell();

        while (next == null && solution.size() > 0) {//backtracking while loop
            Cell last = solution.pop();
            int newVal = findNextValue(last);
            last.setValue(newVal);
            if (newVal != 0) {
                next = last;// if you find a valid val, then assign it
            }
        }

        if (next == null) {//went all the way back to 0
            System.out.println("Could not solve");
            board.finished = true;
            return false;
        } else {
            solution.push(next);
        }
        
    }
    System.out.println("Solved!" );
    board.finished = true;
    return true;
    }

    //reflection question 2
    //———————————————————————————————————————–––––––––––––––———————––––––––––––––––––––––––––––
    public int numSolutions() throws InterruptedException {
        // Lock all non-zero entries
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                Cell cell = board.get(row, col);
                if (cell.getValue() != 0) {//if val not 0,lock it to prevent modification
                    cell.setLocked(true);
                }
            }
        }
        //make counter
        int numSolutions = 0;
        LinkedList<Cell> stack = new LinkedList<>();
        //loop until cells excluding locked ones are processed
        while (stack.size() < Board.SIZE * Board.SIZE - board.numLocked()) {
            Cell next = findNextCell();
            //only change to the Solve method is to increment if the last cell filled is valid // then subtract total numlocked from board size = open spots
            if (next != null && stack.size() + 1 == Board.SIZE * Board.SIZE - board.numLocked()) {
                numSolutions++;
                next.setValue(0);
                next = null;
            }

            while (next == null && !stack.isEmpty()) {
                Cell cell = stack.pop();
                int value = findNextValue(cell);
                if (value != 0) {
                    next = cell;
                    next.setValue(value);
                } else {
                    cell.setValue(0);
                }
            }
            if (next == null) {
                return numSolutions;
            } else {
                stack.push(next);
            }
        }
        return numSolutions;
    }

    public void generateUniqueSolution() throws InterruptedException {
        // Randomly permute the symbols
        board.randomPermute();
        System.out.println("random permuted: ");
        System.out.println(board);
        int failed = 0;
        //Remove values while maintaining a unique solution 15 times
        while (failed < 15) {
            Random rand = new Random();
            int randcol = rand.nextInt(Board.SIZE);
            int randrow = rand.nextInt(Board.SIZE);
            Cell cell = board.get(randrow, randcol);
            //Know cell has a value before removing it
            if (cell.getValue() != 0) {
                int temp = cell.getValue();
                cell.setLocked(false);
                cell.setValue(0); // Temporarily remove the value
                //Check if curr board state has 1 solution, or else we'll continue to decrement
                if (numSolutions() != 1) {
                    cell.setLocked(false);
                    cell.setValue(temp);
                    failed++; // Restore the value if removing it leads to multiple solutions
                }
            }
        }
    }

        public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of locked values: ");
        int lockedVals = scanner.nextInt();

        System.out.println("Enter size (1, 4, 9, 16, 25): ");
        int size = scanner.nextInt();

        scanner.close();
        
        
        Sudoku sudoku = new Sudoku(lockedVals,size);
        System.out.println(sudoku.board);
        sudoku.solve(50);
        System.out.println(sudoku.board);
    }
}







