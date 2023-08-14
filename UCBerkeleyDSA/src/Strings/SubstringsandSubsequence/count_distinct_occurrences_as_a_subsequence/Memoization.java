package Strings.SubstringsandSubsequence.count_distinct_occurrences_as_a_subsequence;
import java.util.*;

//Time Complexity: O(m*n), only one traversal of the matrix is needed, so the time Complexity is O(m*n)
//Auxiliary Space: O(m*n), ignoring recursion stack space

class Memoization {
    static int f(int i, int j, String s, String t, int[][] dp) {
        if (t.length() - j > s.length() - i)
            return 0;

        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = f(i + 1, j + 1, s, t, dp) + f(i + 1, j, s, t, dp);
        }

        return dp[i][j] = f(i + 1, j, s, t, dp);
    }

    static int findSubsequenceCount(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++)
            Arrays.fill(dp[i], -1);

        return f(0, 0, s, t, dp);
    }

    public static void main(String[] args) {
        String T = "ge";
        String S = "geeksforgeeks";
        System.out.println(findSubsequenceCount(S, T));
    }
}