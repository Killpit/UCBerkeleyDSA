package Recursion;

/*What is Recursion
*
* The process in which a function calls itself directly or indirectly is called recursion and the corresponding
* function is called a recursive function. A recursive function solves a particular problem by calling a copy of itself
* and solving smaller subproblems of the original problems. Many more recursive calls can be generated as and when
* required.
* */

/*Need of recursion
*
* Recursion is an amazing technique with the help of which we can reduce the length of our code and make it easier to
* read and write. It has certain advantages over the iteration technique.*/

/*Properties of Recursion
*
* Performing the same operations multiple times with different inputs.
* In every step, we try smaller inputs to make the problem smaller.
* Base condition is needed to stop the recursion, otherwise infinite loop will occur.*/

/*Algorithm
*
* Step 1 - Define a base case: Identify the simplest case for which the solution is known or trivial. This is the
* stopping condition for the recursion, as it prevents the function from infinitely calling itself.
*
* Step 2 - Define a recursive case: Define the problem in terms of smaller subproblems. Break the problem down into
* smaller versions of itself, and call the function recursively to solve each subproblem.
*
* Step 3 - Ensure the recursion terminates: Make sure that the recursive function eventually reaches the base case, and
* does not enter an infinite loop.
*
* Step 4 - Combine the solutions: Combine the solutions of the subproblems to solve the original problem.
* */

/*How are recursive functions stored in memory?
*
* Recursion uses more memory, because the recursive function adds to the stack with each recursive call, and keeps the
* values there until the call is finished. The recursive function uses LIFO Structure just like the stack data
* structure.*/

/*What is the base condition in recursion?
*
* In the recursive program, the solution to the base case is provided and the solution to the bigger problem is
* expressed in terms of smaller problems.*/

/*How a particular problem is solved using recursion?
*
* The idea is to represent a problem in terms of one or more smaller problems, and add one or more base conditions that
* stop the recursion.*/

/*Why Stack Overflow error occurs in recursion?
*
* If the base case is not reached or not defined, then the stack overflow problem may arise.*/

/*What is the difference between tailed and non-tailed recursion?
*
* A recursive function is tail recursive when a recursive call is the last thing executed by the function.*/

/*How memory is allocated to different function calls in recursion?
*
* When any function is called from main(), the memory is allocated to it on the stack. A recursive function calls
* itself, the memory for a called function is allocated on top of memory allocated to the calling function and a
* different copy of local variables is created for each function call. When the base case is reached, the function
* returns its value to the function by whom it is called and memory is de-allocated and the process continues.*/

/*Recursion Use Cases
*
* Tree and graph traversal: Recursion is frequently used for traversing and searching data structures such as trees and
* graphs. Recursive algorithms can be used to explore all the nodes or vertices of a tree or graph in a systematic way.
*
* Sorting algorithms: Recursive algorithms are also used in sorting algorithms such as quicksort and merge sort. These
* algorithms use recursion to divide the data into smaller subarrays or sublists, sort them, and then merge them back
* together.
*
* Divide-and-conquer algorithms: Many algorithms that use a divide-and-conquer approach such as the binary search
* algorithm, use recursion to break down the problem into smaller subproblems.
*
* Fractal generation: Fractal shapes and patterns can be generated using recursive algorithms.
*
* Backtracking algorithms: Backtracking algorithms are used to solve problems that involve making a sequence of
* decisions, where each decision depends on the previous ones. These algorithms can be implemented using recursion to
* explore all possible paths and backtrack when a solution is not found.
*
* Memoization: Memoization is a technique that involves storing the results of expensive function calls and returning
* the cached result when the same inputs occur again. Memoization can be implemented using recursive functions to
* compute and cache the results of subproblems.*/

//Time Complexity: O(1)
//Auxiliary Space: O(1)

class RecursionDemo {

    static void printfun(int test) {
        if (test < 1)
            return;
        else {
            System.out.printf("&d ", test);
            printfun(test - 1);
            System.out.printf("%d ", test);
        }
    }

    public static void main(String[] args) {
        int test = 3;
        printfun(test);
    }
}
