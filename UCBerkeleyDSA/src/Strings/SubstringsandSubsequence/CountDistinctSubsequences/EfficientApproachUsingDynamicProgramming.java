package Strings.SubstringsandSubsequence.CountDistinctSubsequences;

import java.util.Arrays;

/*
Let countSub(n) be count of subsequences of
first n characters in input string. We can
recursively write it as below.

countSub(n) = 2*Count(n-1) - Repetition

If current character, i.e., str[n-1] of str has
not appeared before, then
   Repetition = 0

Else:
   Repetition  =  Count(m)
   Here m is index of previous occurrence of
   current character. We basically remove all
   counts ending with previous occurrence of
   current character.
*/

//Time Complexity: O(n)
//Auxiliary Space: O(n)

public class EfficientApproachUsingDynamicProgramming {

    static final int MAX_CHAR = 256;

    //Returns count of distinct subsequences of str
    static int countSub(String str) {
        //Create an array to store index of last
        int[] last = new int[MAX_CHAR];
        Arrays.fill(last, -1);

        //Length of input string
        int n = str.length();

        //dp[i] is going to store count of distinct subsequences of length i
        int[] dp = new int[n + 1];

        //Empty substring has only one subsequence
        dp[0] = 1;

        //Traverse through all lengths from 1 to n.
        for (int i = 1; i <= n; i++) {
            //Number of subsequences with substring str[0..i-1]
            dp[i] = 2 * dp[i - 1];

            //If current characters has appeared before, then remove all subsequences ending with previous occurrence
            //ending with previous occurrence
            if (last[str.charAt(i - 1)] != -1)
                dp[i] = dp[i] - dp[last[str.charAt(i - 1)]];

            //Mark occurrence of current character
            last[str.charAt(i - 1)] = (i - 1);
        }

        return dp[n];
    }

    //Driver code
    public static void main(String[] args) {
        System.out.println(countSub("gfg"));
    }
}