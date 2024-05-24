/*
 * Philip Booth
 * 04/7/2024
 * Project 5
 * CS231
 * Purpose tests all my board methods
 */

public class BoardTests {
    

    public static void main(String[] args) {


    //Case 1: Testing getCols and setCols

    //Setup
    Board test1 = new Board();
//     System.out.println(test1.toString());

   
    //verify
    test1.set(5,5,2);//set value to 2
    System.out.println("2 ==" + test1.get(5, 5));
    System.out.println(test1.toString());
    System.out.println("————————————————————————————————————————————————");

//————————————————————————————————————————————————————————————————————————————————————————————————
    //Case 2: Testing isLocked and numLock
    
    //Setup 
    Board test2 = new Board();
    System.out.println(test2.toString());

    //verify
    test2.set(0, 0, true);
    test2.set(1, 0, true);
    test2.set(2, 0, true);
    test2.set(3, 0, true);
    test2.set(4, 0, true);
    test2.set(5, 0, true);
    System.out.println(test2.numLocked());
    System.out.println("————————————————————————————————————————————————");

//————————————————————————————————————————————————————————————————————————————————————————————————
    //Case 3: Testing value & set methods

    //Setup
    Board test3 = new Board("board2.txt");
    System.out.println(test3.toString());

    //verify
    System.out.println("8 == "+ test3.value(5,5) );
    test3.set(5,5,2);
    System.out.println(test3.toString());
    System.out.println("2 == "+ test3.value(5,5));

//—————————————————————————————————————————————————————————————————————————————
     //Case 4: Testing ValidValue and validSolution
    Board test4 = new Board();
    //System.out.println("\n" + test4.toString());


    test4.set(0, 0, 1);
    test4.set(0, 1, 2);
    test4.set(0,2, 3);
    test4.set(1, 0, 4);
    test4.set(1, 1, 5);
    test4.set(1, 2, 6);
    test4.set(2, 0, 7);
    test4.set(2, 1, 8);
    test4.set(2, 2, 9);

    System.out.println("\n" + test4.toString());
    assert test4.validValue(2,2,9) == true : "Error in board";
    assert test4.validValue(2,4,9) == false : "Error determining if value in same col ";
    assert test4.validValue(4,2,9) == false : "Error determining if value in same row ";
    assert test4.validSolution() == false : "Error in ValidSolution method";
//—————————————————————————————————————————————————————————————————————————————
    // //Case 5: Testing validsolution on the txt file
    // Board test5 = new Board("board1.txt");
    // assert test5.validSolution() == false : "Error in ValidSolution";
    // System.out.println("\n" + test5.toString());


    // //Case 6: Testing random constructor
    //  Board test6 = new Board(8);
    //  System.out.println("\n" + test6.toString());

    


     
    











    }

}
