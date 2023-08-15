package Strings.SubstringsandSubsequence.LongestCommonSubsequence;

/*
Steps:

-Create a 2D array dp[][] with rows and columns equal to the length of each input string plus 1 [the number of rows
indicates the indices of S1 and the columns indicate the indices of S2].
-Initialize the first row and column of the dp array to 0.
    -For each i, iterate all the columns from j=1 to n:
        -If S1[i-1] is equal to S2[j-1], set the current element of the dp array to the value of the element to
        (dp[i-1][j-1] + 1)
        -Else, set the current element of the dp array to the maximum value of dp[i-1][j] and dp[i][j-1]
-After the nested loops, the last element of the dp array will contain the length of the LCS
*/

/*Time Complexity: O(m * n) which is much better than the worst-case time complexity of Naive Recursive implementation*/
/*Auxiliary Space: O(m * n) because the algorithm uses an array of size (m + 1) * (n + 1) to store the length of the common
* substrings*/

public class Tabulation {

    //Returns length of LCS for X[0..m-1], Y[0..n-1]
    int lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        //Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j] contains length of LCS of X[0..i-1]
        //and Y[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    //Utility function to get max of 2 integers
    int max(int a, int b) {return Math.max(a, b);}

    public static void main(String[] args) {
        Tabulation lcs = new Tabulation();
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        int m = S1.length();
        int n = S2.length();

        System.out.println("Length of LCS is" + " " + lcs.lcs(S1, S2, m, n));
    }
}