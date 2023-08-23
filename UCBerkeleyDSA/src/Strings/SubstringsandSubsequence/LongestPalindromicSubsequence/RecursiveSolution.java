package Strings.SubstringsandSubsequence.LongestPalindromicSubsequence;

/*
- Case 1: Every single character is a palindrome of length 1
    - L(i, i) = 1 (for all indexes i in given sequence)

- Case 2: If first and last characters are not same
    - If (X[i] != X[j]) L(i, j) = max{L(i + 1, j), L(i, j - 1)}

- Case 3: If there are only 2 characters and both are same
    - Else if (j == i + 1) L(i, j) = 2

- Case 4: If there are more than two characters, and the first and last characters are same
    - Else L(i, j) = L(i + 1, j - 1) + 2
*/

//Time Complexity: O(2^n), where 'n' is the length of the input sequence
//Auxiliary Space: O(n^2) as we are using a 2D array to store the solutions of the sub problems

class RecursiveSolution {

    // A utility function to get the max of two integers
    static int max(int x, int y) {return Math.max(x, y);}
    //Returns the length of the longest palindromic subsequence in seq

    static int lps(char[] seq, int i, int j) {
        //Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }

        //Base Case 2: If there are only 2 characters and both characters are same
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }

        //If the first and last characters match
        if (seq[i] == seq[j]) {
            return lps(seq, i + 1, j - 1) + 2;
        }

        //If the first and last characters do not match
        return max(lps(seq, i, j - 1), lps(seq, i + 1, j));
    }

    //Driver program to test above function
    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.printf("The length of the LPS is %d", lps(seq.toCharArray(), 0, n - 1));
    }
}