/*
 * Philip Booth
 * 04/1/2024
 * Project 5
 * CS231
 * Purpose: Cell class creates the blocks that make up board. 
 */
import java.awt.Graphics;
import java.awt.Color;


public class Cell {
    int row;
    int col;
    int value;
    boolean locked;

    //constructor 1
    public Cell() {
        row = 0;
        col = 0;
        value = 0;
        locked = false;
    }
    
    //constructor 2
    public Cell(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        locked = false;
    }

    //constructor 3
    public Cell(int row, int col, int value, boolean locked) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.locked = locked;
    }
    // Setters and getters
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newval) {
        value = newval;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean lock) {
        locked = lock;
    }

    public String toString() {
        return " " + value + " ";
    }


    public void draw(Graphics g, int x, int y, int scale){
        // draws each cell
        if(getValue() <= 9){
            char toDraw = (char) ((int) '0' + getValue());
            g.setColor(isLocked()? Color.BLUE : Color.RED);
            g.drawChars(new char[] {toDraw}, 0, 1, x, y);
        }
        else if(getValue() > 9 && getValue() <= 19){
            char toDraw1 = (char) ((int) '1');
            char toDraw2 = (char) ((int) '0' + getValue()-10);
            g.setColor(isLocked()? Color.BLUE : Color.RED);
            g.drawChars(new char[] {toDraw1}, 0, 1, x, y);
            g.drawChars(new char[] {toDraw2}, 0, 1, x+8, y);
        }
        else{
            char toDraw1 = (char) ((int) '2');
            char toDraw2 = (char) ((int) '0' + getValue()-20);
            g.setColor(isLocked()? Color.BLUE : Color.RED);
            g.drawChars(new char[] {toDraw1}, 0, 1, x, y);
            g.drawChars(new char[] {toDraw2}, 0, 1, x+8, y);

        }
    }
    public static void main(String[] args) {
        Cell dog = new Cell(1,1,5);
        dog.setValue(10);
        System.out.println(dog.toString());
    }

}
