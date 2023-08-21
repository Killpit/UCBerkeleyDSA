package Strings.SubstringsandSubsequence.PrintingShortestCommonSupersequence;

/*

Let X[0..m-1] and Y[0..n-1] be two strings and m and be respective lengths

if (m==0) return n;
if (n==0) return m;

//If the last characters are same, then add 1 to the result and recur for X[]
if(X[m-1] == Y[n-1])
    return 1 + SCS(X, Y, m-1, n-1);

//Else, find shortest of the following two
// a)Remove last character from X and recur
// b)Remove last character from Y and recur
else return 1 + min(SCS(X, Y, m-1, n), SCS(X, Y, m, n-1));

*/

/*

Method: We start from the bottom-right most cell of the matrix and push characters in output string based on below rules-

1-If the characters corresponding to current cell (i, j) in X and Y are same, then the character is part of shortest
super-sequence. We append it in output string and move diagonally to next cell

2-If the characters corresponding to current cell (i, j) in X and Y are different, we have two choices -

If matrix[i-1][j] > matrix[i][j-1], we add character corresponding to current cell (i,j) in string Y in output string and
move to the left cell, else, we add character corresponding to current cell (i,j) in string X in output string and move to
the top cell

3-If string Y reaches its end, we add remaining characters of string X in the output string, else if string X reaches its
end, we add remaining characters of string Y in the output string

*/

//Time Complexity: O(n^2)
//Auxiliary Space: O(n^2)

class DPSolutionMatrix {

    //Returns shortest super-sequence of X and Y
    static String printShortestSuperSeq(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        //dp[i][j] contains length of shortest super-sequence for X[0..i-1] and Y[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        //Fill table in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                //Below steps follow recurrence relation
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //Following code is used to print shortest super-sequence dp[m][n] stores the length of the shortest
        //super-sequence of X and Y

        //string to store the shortest super-sequence
        StringBuilder str = new StringBuilder();

        //Start from the bottom right corner and one by one push characters in output string
        int i = m, j = n;
        while (i > 0 && j > 0) {
            //If current character in X and Y are the same, then current character is the part of shortest super-sequence
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                //Put current character in result
                str.append(X.charAt(i - 1));

                //reduce values of i, j and index
                i--;
                j--;
            }

            //If current character in X and Y are different
            else if (dp[i - 1][j] > dp[i][j - 1]) {

                //Put current character of Y in result
                str.append(Y.charAt(j - 1));

                //reduce values of j and index
                j--;
            }
            else {

                //Put current character of X in result
                str.append(X.charAt(i - 1));

                //reduce values of i and index
                i--;
            }
        }

        //If X reaches its end, put remaining characters of X in the result string
        while (i > 0) {
            str.append(X.charAt(i - 1));
            i--;
        }

        //If X reaches its end, put remaining characters of Y in the result string
        while (j > 0) {
            str.append(Y.charAt(j - 1));
            j--;
        }

        //reverse the string and return it
        str = new StringBuilder(reverse(str.toString()));
        return str.toString();
    }

    static String reverse(String input) {
        char[] temparray = input.toCharArray();
        int left, right;
        right = temparray.length - 1;

        for (left = 0; left < right; left++, right--) {
            //Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        return String.valueOf(temparray);
    }

    //Driver code
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(printShortestSuperSeq(X, Y));
    }
}