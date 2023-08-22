package Strings.SubstringsandSubsequence.ShortestCommonSupersequence;

/*

Method 1-This problem is closely related to longest common subsequence problem.
Steps:

1-Find longest common subsequence (LCS) of two given strings.

2-Insert non-LCS characters (in their original order in strings) to the LCS found above, and return the result. So "ek"
becomes "geeke" which is shortest common super-sequence.

How does this work?

We need to find a string that has both strings as subsequences and is the shortest such string. If both strings have all
characters different, then result is sum of lengths of two given strings. If there are common characters, then we don't
want them multiple times as the task is to minimize length. Therefore, we first find the longest common subsequence, take
one occurrence of this subsequence and add extra characters

Length of the shortest super-sequence = (Sum of lengths of given two strings) - (Length of LCS of two given strings)

*/

//Time Complexity: O(m*n)
//Auxiliary Space O(m*n)

class Method1 {

    //Function to find length of the shortest supersequence of X and Y
    static int shortestSuperSequence(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        // find lcs
        int l = lcs(X, Y, m, n);

        // Result is sum of input string lengths - length of lcs
        return (m + n - l);
    }

    // Returns length of LCS for X[0..m - 1], Y[0..n - 1]
    static int lcs(String X, String Y, int m, int n)
    {
        int[][] L = new int[m + 1][n + 1];
        int i, j;

        // Following steps build L[m + 1][n + 1]
        // in bottom up fashion. Note that L[i][j] contains length of LCS of X[0..i - 1]and Y[0..j - 1]
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j],
                            L[i][j - 1]);
            }
        }

        // L[m][n] contains length of LCS for X[0..n - 1] and Y[0..m - 1]
        return L[m][n];
    }

    // Driver code
    public static void main(String[] args)
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        System.out.println("Length of the shortest "
                + "supersequence is "
                + shortestSuperSequence(X, Y));
    }
}