package Recursion.DirectRecursion;

/*Tree Recursion
*
* If a recursive function calling itself for one time, then it's known as Linear Recursion. Otherwise, if a recursive
* function calling itself for more than one time, then it's known as TreeRecursion.
*/

/*Pseudo Code
*
*
fun(n)
{
    // some code
    if(n>0)
    {
        fun(n-1); // Calling itself only once
    }
    // some code
}
*/

//Time Complexity for Tree Recursion: O(2^n)
//Space Complexity for Tree Recursion: O(n)

class TreeRecursion {

    //Recursive function
    static void fun(int n) {

        if (n > 0) {
            System.out.print(" " + n);

            //Calling once
            fun(n - 1);

            //Calling twice
            fun(n - 1);
        }
    }

    //Driver code
    public static void main(String[] args) {
        fun(3);
    }
}
