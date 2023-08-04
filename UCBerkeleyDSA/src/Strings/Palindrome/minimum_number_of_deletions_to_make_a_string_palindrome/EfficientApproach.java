package Strings.Palindrome.minimum_number_of_deletions_to_make_a_string_palindrome;

//Time Complexity: O(N^2), as the LPS subproblem is solved using dynamic programming
//Auxiliary Space: O(N^2) as a 2D array of size N * N is used to store the subproblems

class EfficientApproach {
    //Returns the length of the longest palindromic subsequence in 'str'
    static int lps(String str) {
        int n = str.length();

        //Create a table to store results of subproblems
        int[][] L = new int[n][n];

        //Strings of length 1 are palindrome of length 1
        for (int i = 0; i < n; i++)
            L[i][i] = 1;

        /*Build the table. Note that the lower diagonal values of table are useless and not filled in the process.
        * c1 is the length of substring*/
        for (int c1 = 2; c1 <= n; c1++) {
            for (int i = 0; i < n - c1 + 1; i++) {
                int j = i + c1 - 1;
                if (str.charAt(i) == str.charAt(j) && c1 == 2)
                    L[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Integer.max(L[i][j - 1], L[i + 1][j]);
            }
        }

        //Length of longest palindromic subsequence
        return L[0][n - 1];
    }

    //Function to calculate minimum number of deletions
    static int minimumNumberOfDeletions(String str) {
        int n = str.length();

        //Find longest palindromic subsequence
        int len = lps(str);

        //After removing characters other than the lps, we get palindrome
        return (n - len);
    }

    //Driver Code
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("Minimum number " + "of deletions = " + minimumNumberOfDeletions(str));
    }
}