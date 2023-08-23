package Strings.SubstringsandSubsequence.LongestPalindromicSubsequence;
import java.util.Arrays;

/*The idea used here is to reverse the given input string and check the length of the longest common subsequence. That would be the
* answer for the longest palindromic subsequence*/

//Time Complexity: O(n^2)
//Auxiliary Space: O(n^2)

class Memoization {

    //A utility function to get max of two integers
    static int max(int x, int y) {return Math.max(x, y);}

    //Returns the length of the longest palindromic subsequence in seq
    static int lps(char[] seq, int i, int j, int[][] dp) {

        //Base Case 1: If there is only 1 character
        if (i == j) {
            return dp[i][j] = 1;
        }

        //Base Case 2: If there are only 2 characters and both are same
        if (seq[i] == seq[j] && i + 1 == j) {
            return dp[i][j] = 2;
        }

        //Avoid extra call for already calculated sub problems, just return the saves ans from cache
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        //If the first and last characters match
        if (seq[i] == seq[j]) {
            return dp[i][j] = lps(seq, i + 1, j - 1, dp) + 2;
        }

        //If the first and last characters do not match
        return dp[i][j] = max(lps(seq, i, j - 1, dp), lps(seq, i + 1, j, dp));
    }

    //Driver program to test above function
    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        int[][] dp = new int[n][n];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        System.out.printf("The length of the LPS is %d", lps(seq.toCharArray(), 0, n - 1, dp));
    }
}