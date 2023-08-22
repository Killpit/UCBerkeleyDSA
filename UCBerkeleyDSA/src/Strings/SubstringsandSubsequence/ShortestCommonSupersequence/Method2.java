package Strings.SubstringsandSubsequence.ShortestCommonSupersequence;

/*

Let X[0..m-1] and Y[0..n-1] be two strings and m and n be respective lengths.

    if (m == 0) return n;
    if (n == 0) return m;

    //If last characters are same, then add 1 to result and recur for X[]
    if (X[m-1] == Y[n-1])
        return 1 + SCS(X, Y, m - 1, n - 1);

    // Else, find the shortest of following two
    //  a) Remove last character from X and recur
    //  b) Remove last character from Y and recur
    else
        return 1 + min(SCS(X, Y, m - 1, n), SCS(X, Y, m, n - 1));

*/

//Time Complexity: O(2^min(m,n)), since there are overlapping problems
//Auxiliary Space: O(min(m,n)), due to recursive call stack

class Method2 {
    static int superSeq(String X, String Y, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + superSeq(X, Y, m - 1, n - 1);

        return 1 + Math.min(superSeq(X, Y, m - 1, n), superSeq(X, Y, m, n - 1));
    }

    //Driver Code
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of the shortest" + "supersequence is: " + superSeq(X, Y, X.length(), Y.length()));
    }
}