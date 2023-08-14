package Strings.SubstringsandSubsequence.count_distinct_occurrences_as_a_subsequence;

/*
Algorithm:

1-Create a 2D array mat[m+1][n+1] where m is length of string T and n is length of string S. mat[i][j] denotes the number of
distinct subsequence of substring S(1..i) and substring T(1..j) so mat[m][n] contains our solution.
2-Initialize the first column with all 0s. An empty string can't have another string as subsequence
3-Initialize the first row with all 1s. An empty string is a subsequence of all
4-Fill the matrix in bottom-up manner
5-Traverse the string T from start to end (counter is i)
6-For every iteration of the outer loop, traverse the string S from start to end (counter is j)
7-If the character at ith index of string T matches with jth character of string S, the value is obtained considering two
cases. First, is all the substrings without last character in S and second is the substrings without last characters in
both
8-Else, the value will be same even if jth character of S removed
9-Print the value of mat[m][n] as the answer
*/

//Time Complexity: O(m*n), only one traversal of the matrix is needed, so the time Complexity is O(m*n)
/*Auxiliary Space: O(m*n), A matrix of size m*n is needed so the space complexity is O(m*n)
* Note: Since mat[i][j] accesses elements of the current row and previous row only, we can optimize auxiliary space just by
* using two rows only reducing space from m*n to 2*n.
*/

class DynamicProgramming {
    static int findSubsequenceCount(String S, String T) {
        int m = T.length();
        int n = S.length();

        //T can't appear as a subsequence in S
        if (m > n)
            return 0;

        //mat[i][j] stores the count of occurrences of T(1..i) in S(1..j)
        int[][] mat = new int[m+1][n+1];

        //Initializing first column with all 0s. An empty string can't have another string as subsequence
        for (int i = 1; i <= m; i++)
            mat[i][0] = 0;

        //Initializing first row with all 1s. An empty string is subsequence of all
        for (int j = 0; j <= n; j++)
            mat[0][j] = 1;

        //Fill mat[][] in bottom up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //If last characters don't match, then value is same as the value without last character in S
                if (T.charAt(i - 1) != S.charAt(j - 1))
                    mat[i][j] = mat[i][j - 1];

                //Else, value is obtained considering two cases.
                //a)All substrings without last character in S
                //b)All substrings without last characters in both
                else
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
            }
        }

        return mat[m][n];
    }

    //Driver code to check above method
    public static void main(String[] args) {
        String T = "ge";
        String S = "geeksforgeeks";
        System.out.println(findSubsequenceCount(S, T));
    }
}