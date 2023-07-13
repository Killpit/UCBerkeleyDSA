package Recursion.DirectRecursion;

/*
* Nested Recursion
*
* In this recursion, a recursive function will pass the parameter as a recursive call. That means "recursion inside
* recursion"*/

class NestedRecursion {
    static int fun(int n) {
        if (n > 100)
            return n - 10;

        //A recursive function passing parameter as a recursive call or recursion inside the recursion
        return fun(fun(n + 11));
    }

    //Driver code
    public static void main(String[] args) {
        int r;
        r = fun(95);
        System.out.print(" " + r);
    }
}
