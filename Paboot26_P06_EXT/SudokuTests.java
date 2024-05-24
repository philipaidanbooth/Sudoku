/*
 * Philip Booth
 * 04/1/2024
 * Project 5
 * CS231
 * Purpose: tests all my sudoku class methods
 */

public class SudokuTests {
    
    public static void main(String[] args) throws InterruptedException {
        // Case 1: Testing the find next value
        // Sudoku test4 = new Sudoku(0);

        // System.out.println(test4.toString());
        
        // test4.board.set(0, 0, 1);
        // test4.board.set(0, 1, 2);
        // test4.board.set(0,2, 3);
        // test4.board.set(1, 0, 4);
        // test4.board.set(1, 1, 5);
        // test4.board.set(1, 2, 6);
        // test4.board.set(2, 0, 7);
        // //test4.board.set(2, 1, 8);
        // test4.board.set(2, 2, 9);

        // // System.out.println("" +test4.board.toString());
        // // System.out.println("\n" + test4.findNextValue(test4.board.get(2,1)));
        // assert test4.findNextValue(test4.board.get(0,0)) == 1: "Error1";
        // assert test4.findNextValue(test4.board.get(1,0)) == 1: "Error2";
        // assert test4.findNextValue(test4.board.get(0,2)) == 1: "Error3";
        // assert test4.findNextValue(test4.board.get(2,1)) == 8: "Error4";
       
        // //Case 2: TEsting the Solve method

        // Sudoku testC2 = new Sudoku(0);
        // System.out.println(testC2.solve(20));
        

        //Exploration hypothesis 
        //setup 5 sudoku boards 
        // int numLock = 10;
        // Sudoku test1 = new Sudoku(numLock);
        // Sudoku test2 = new Sudoku(numLock);
        // Sudoku test3 = new Sudoku(numLock);
        // Sudoku test4_ = new Sudoku(numLock);
        // Sudoku test5 = new Sudoku(numLock);
        // Sudoku test6 = new Sudoku(numLock);
        // Sudoku test7 = new Sudoku(numLock);
        // Sudoku test8 = new Sudoku(numLock);
        // Sudoku test9 = new Sudoku(numLock);
        // Sudoku test10 = new Sudoku(numLock);
        // Sudoku test11 = new Sudoku(numLock);
        // Sudoku test12 = new Sudoku(numLock);
        // Sudoku test13 = new Sudoku(numLock);
        // Sudoku test14 = new Sudoku(numLock);
        // Sudoku test15 = new Sudoku(numLock);
        // Sudoku test16 = new Sudoku(numLock);
        // Sudoku test17 = new Sudoku(numLock);
        // Sudoku test18 = new Sudoku(numLock);
        // Sudoku test19 = new Sudoku(numLock);
        // Sudoku test20 = new Sudoku(numLock);
       
        // //Test
        
        // test1.solve(0);
        // test2.solve(0);
        // test3.solve(0);
        // test4_.solve(0);
        // test5.solve(0);
    //     test6.solve(0);
    //     test7.solve(0);
    //     test8.solve(0);
    //     test9.solve(0);
    //     test10.solve(0);
    //     test11.solve(0);
    //     test12.solve(0);
    //     test13.solve(0);
    //     test14.solve(0);
    //     test15.solve(0);
    //     test16.solve(0);
    //     test17.solve(0);
    //     test18.solve(0);
    //     test19.solve(0);
    //     test20.solve(0);
        
    // }


    //Reflection Question 2 solve
        // Sudoku rand = new Sudoku(0);
        // rand.board.randomPermute();


    // Sudoku test01 = new Sudoku(5);
    // test01.solve(0);
    // test01.generateUniqueSolution();//works but it still prints "no solution!" on the board not sure why
    // System.out.println(test01.numSolutions());//should return 1

    // Sudoku test02 = new Sudoku(10);
    // test02.solve(0);
    // test02.generateUniqueSolution();//works but it still prints "no solution!" on the board not sure why
    // System.out.println(test02.numSolutions());//should return 1

    // Sudoku test03 = new Sudoku(15);
    // test03.solve(0);
    // test03.generateUniqueSolution();//works but it still prints "no solution!" on the board not sure why
    // System.out.println(test03.numSolutions());//should return 1


//Ext 2 Testing a 4 4x4 grid
int numLock = 5;
Sudoku test = new Sudoku(numLock);
test.solve(10);

}

}
