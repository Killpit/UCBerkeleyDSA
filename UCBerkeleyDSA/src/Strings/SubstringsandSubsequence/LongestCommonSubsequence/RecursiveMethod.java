package Strings.SubstringsandSubsequence.LongestCommonSubsequence;

/*
Follow the below steps to implement the idea:

-Create a recursive function
-Check the relation between the first characters of the strings that are not yet processed
    -Depending on the relation, call the next recursive function as mentioned above
-Return the length of the LCS received as the answer
*/

//Time Complexity: O(2^m*n)
//Auxiliary Space: O(1)

public class RecursiveMethod {

    //Returns length of LCS for X[0..m-1], Y[0..n-1]
    int lcs(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    //Utility function to get max of 2 integers
    int max(int a, int b) {return Math.max(a, b);}

    //Driver code
    public static void main(String[] args) {
        RecursiveMethod lcs = new RecursiveMethod();
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        int m = S1.length();
        int n = S2.length();

        System.out.println("Length of LCS is" + " " + lcs.lcs(S1, S2, m, n));
    }
}