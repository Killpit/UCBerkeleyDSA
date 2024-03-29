package Strings.SubstringsandSubsequence.LongestRepeatingSubsequence;
import java.util.Arrays;

//Time Complexity: O(m*n)
//Auxiliary Space: O(m*n)

public class UsingRecursion {

    static int[][] dp = new int[1000][1000];

    //This function mainly returns LCS(str, str), with a condition that same characters at same index are not considered
    static int findLongestRepeatingSubSeq(char[] X, int m, int n) {

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        //return if we have reached the end of either string
        if (m == 0 || n == 0) {
            return dp[m][n] = 0;
        }

        //If characters at index m and n matches and index is different
        if (X[m - 1] == X[n - 1] && m != n) {
            return dp[m][n] = findLongestRepeatingSubSeq(X, m - 1, n - 1) + 1;
        }

        //If characters at index m and n matches and index is different
        if (X[m - 1] == X[n - 1] && m != n) {
            return dp[m][n] = findLongestRepeatingSubSeq(X, m - 1, n - 1) + 1;
        }

        //else if characters at index m and n don't match
        return dp[m][n] = Math.max(findLongestRepeatingSubSeq(X, m, n - 1), findLongestRepeatingSubSeq(X, m - 1, n));
    }

    public static void main(String[] args) {
        String str = "aabb";
        int m = str.length();
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("The length of the largest subsequence that" + " repeats itself is : "
                + findLongestRepeatingSubSeq(str.toCharArray(), m, m));
    }
}