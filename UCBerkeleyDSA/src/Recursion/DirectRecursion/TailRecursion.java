package Recursion.DirectRecursion;

/*
* Tail Recursion: If a recursive function calling itself and that recursive call is the last statement in the function,
* then it's known as Tail Recursion. After that call, the recursive function performs nothing. The function has to
* process or perform any operation at the time of calling and it does nothing at returning time*/

//Time Complexity for Tail Recursion: O(n)
//Space Complexity for Tail Recursion: O(n)

class TailRecursion {

    //Recursion function
    static void fun(int n) {

        if(n > 0) {
            System.out.print(n + " ");

            //Last statement in the function
            fun(n - 1);
        }
    }

    //Driver Code
    public static void main(String[] args) {
        int x = 3;
        fun(x);
    }
}
