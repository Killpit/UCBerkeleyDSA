package Recursion.DirectRecursion;

/*Head Recursion
* If a recursive function calling itself and that recursive call is the first statement in the function, then it's known
* as Head Recursion. There's no statement, no operation before the call. The function doesn't have to process of perform
* any operation at the time of calling and all operations are done at returning time*/

//Time Complexity for Head Recursion: O(n)
//Space Complexity for Head Recursion: O(n)

class HeadRecursion {

    //Recursive function
    static void fun(int n) {

        if (n > 0) {

            //First statement in the function
            fun(n - 1);

            System.out.print(" " + n);
        }
    }

    //Driver code
    public static void main(String[] args) {
        int x = 3;
        fun(x);
    }
}