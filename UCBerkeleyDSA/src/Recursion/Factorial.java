package Recursion;

//Time Complexity: O(n)
//Auxiliary Space: O(n)

public class Factorial {

    //Factorial function
    static int f (int n) {

        //Stop condition
        if (n == 0 || n == 1) {
            return 1;
        }

        //Recursive condition
        else
            return n * f(n - 1);
    }

    //Driver code
    public static void main(String[] args) {
        int n = 5;
        System.out.println("factorial of " + n + " is: " + f(n));
    }
}
