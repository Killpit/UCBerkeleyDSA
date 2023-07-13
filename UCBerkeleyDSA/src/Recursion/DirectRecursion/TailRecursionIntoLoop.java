package Recursion.DirectRecursion;

//Time Complexity: O(n)
//Space Complexity: O(1)

class TailRecursionIntoLoop {
    static void fun(int y) {
        while (y > 0) {
            System.out.print(" " + y);
            y--;
        }
    }

    //Driver code
    public static void main(String[] args) {
        int y = 3;
        fun(y);
    }
}