package Recursion;

/*Infinite Recursion occurs when the recursion does not terminate after a finite number of recursive calls. As the base
* condition is never met, the recursion carries on infinitely.*/

//Time Complexity: non-finite as this recursion will never end
//Auxiliary Space: non-finite

class InfiniteRecursion {

    //Recursive function
    static void Geek(int N) {
        //Base condition, this condition is never met here
        if (N == 0)
            return;

        //Print the current value of N
        System.out.print(N + " ");

        //Call itself recursively
        Geek(N);
    }

    //Driver code
    public static void main(String[] args) {

        //Initial value of N
        int N = 5;

        //Call the recursive function
        Geek(N);
    }
}
