<html>
<head>
    <title>Zero to Sudoku Hero: Mastering Algorithmic Strategies and Insights</title>
</head>
<body>
    <h1>Zero to Sudoku Hero: Mastering Algorithmic Strategies and Insights</h1>
    
    <h2>Abstract</h2>
    <p>In this project from Colby's data structures and algorithms class, I created a Sudoku solver in Java. The project challenged our ability to implement a stack data structure using a linked list, which we coded ourselves. By using the stack, I could hold the solution up to a certain point on the board and employ backtracking to return to previous iterations. This was a tough project, so I made use of rigorous testing files for each of my classes.</p>
    <p>Running the Sudoku.java file will prompt a user to input the number of locked Sudoku squares followed by the dimensions. Then, my program will attempt to solve the game using a depth-first search backtracking strategy.</p>
    
    <h2>Results</h2>
    <p><strong>Hypothesis:</strong> After finally completing my Sudoku board, it was time to test it out. I ran an experiment to see whether there is a correlation between the number of locked initial values and the likelihood of finding a solution for the board. I ran a total of fifty boards for differing locked values from 1-50. For increasing locked values, I hypothesized that the percentage of solutions would exponentially decrease. This experiment was conducted in Sudoku tests.</p>
    
    <table>
        <tr>
            <th>Numlocked</th>
            <th>Count (unsolvable)</th>
            <th>Sample</th>
            <th>Success Percentage</th>
        </tr>
        <tr>
            <td>5</td>
            <td>0</td>
            <td>100</td>
            <td>100%</td>
        </tr>
        <tr>
            <td>10</td>
            <td>1</td>
            <td>100</td>
            <td>99%</td>
        </tr>
        <tr>
            <td>20</td>
            <td>20</td>
            <td>100</td>
            <td>79%</td>
        </tr>
        <tr>
            <td>30</td>
            <td>97</td>
            <td>100</td>
            <td>3%</td>
        </tr>
        <tr>
            <td>40</td>
            <td>100</td>
            <td>100</td>
            <td>0%</td>
        </tr>
        <tr>
            <td>50</td>
            <td>100</td>
            <td>100</td>
            <td>0%</td>
        </tr>
    </table>
<img width="425" alt="Screenshot 2024-05-26 at 10.17.17 AM.png" src="https://github.com/philipaidanbooth/Sudoku/assets/140553270/9e098940-982a-4ddf-ba5f-e4c632d3b89d">

    <p>From the graph and experiment, there's a clear negative correlation between the number of locked Sudoku squares and the success rate of solving the puzzles. The dropoff is sharp, notably between 20 and 30 locked squares, where the success rate drops by 76%. This outcome matches my hypothesis, though I did not expect the dropoff to be so stark. The results are very intriguing!</p>
    
    <h2>Extensions</h2>
    <h3>First Extension</h3>
    <p>For my first extension, I wrote additional testing files for my code. Apologies for any confusion, but my tester files are the same for both my extension project folder and the regular project folder. The only difference is that in my extension folder, I have tests for the "generate unique solution" reflection question.</p>
    
    <h3>Second Extension</h3>
    <p>For my second extension, I embarked on creating different-sized Sudoku boards. This task was more challenging than anticipated. The main challenge was modifying my Cell class’s draw function to print double-digit numbers inside individual cells. There isn't an experiment for this extension because it would take too long, and I believe the extension itself is sufficient. To run the code, press "run" on the Sudoku class, and a scanner will ask for the number of locked squares and the board size.</p>
    
    <h2>Reflection</h2>
    <h3>Breadth-First or Depth-First?</h3>
    <p>The key factor in implementing Depth-First Search (DFS) into our Sudoku program is the Last-In-First-Out (LIFO) approach that DFS uses, versus a Breadth-First Search (BFS) First-In-First-Out (FIFO) approach. This means that DFS uses a stack data structure, which is key for creating the Sudoku solver, which needs the option to backtrack. Backtracking is essential for the Sudoku solver because it allows the program to try out multiple solutions while taking comparatively less memory.</p>
    <p>In addition, the goal of BFS is to find the fastest solution, and while that is important in Sudoku solving, it is ultimately the valid solution that is prioritized. DFS is also more memory-efficient than BFS since DFS only needs to hold info about its current trajectory (root to current).</p>
    
    <h3>Making Good Boards</h3>
    <p>I added the code to my project extension folder. This was from running the Sudoku test files under Case 2. They are 3 boards (5, 10, and 15 numlocked). Here are my results:</p>
    <p>The two main challenges of this reflection question were to modify `solve` to `numsolutions` and to create a unique solution.</p>
    <h4>Generate Unique Solution:</h4>
    <p>Creating a unique solution required me to randomly permute a board and then iterate through it, essentially adding another number lock to the board and keeping it if `numsolutions` equaled zero. The big challenge was determining whether or not to discard it, which I solved by using a temporary cell and checking if its value was zero.</p>
    
    <h4>Numsolutions:</h4>
    <p>For `numsolutions`, the first task was to add an additional conditional at the beginning of the method to lock all number locks, which I would change around later. I kept a stack of the total possible solutions, and when I found one, I would increment `numsolutions`, then backtrack to find other solutions. The main challenge was ensuring I did not find the same solution twice. I addressed this by implementing a unique identifier for each solution based on the arrangement of numbers on the board.</p>
    
    <h2>Acknowledgements</h2>
    <p>Received help from Professor Bender on the Validvalue method. I also received help from TA Sam Polyakov with my ValidSolution method.</p>
</body>
</html>
