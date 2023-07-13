package Recursion;

/*Finite recursion occurs when the recursion terminates after a finite number of recursive calls. A recursion terminates
* only when a base condition is met*/

//Time Complexity: O(n)
//Auxiliary Space: O(n)

class FiniteRecursion {

    //Recursive function
    static void Geek(int N) {

        //Base condition, when this condition is met, the recursion terminates
        if (N == 0)
            return;

        //Print the current value of N
        System.out.println(N + " ");

        //Call itself recursively
        Geek(N - 1);
    }

    //Driver code
    public static void main(String[] args) {

        //Initial value of N
        int N = 5;

        //Call the recursive function
        Geek(N);
    }
}
