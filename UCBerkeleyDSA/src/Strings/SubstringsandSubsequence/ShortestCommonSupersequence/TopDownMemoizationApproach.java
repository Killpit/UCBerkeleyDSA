package Strings.SubstringsandSubsequence.ShortestCommonSupersequence;

/*
The idea is to follow the simple recursive solution, and use a lookup table to avoid re-computations. Before computing the
result for input, we check if the result is already computed or not. If already computed, we return that result
*/

//Time Complexity: O(n*m)
//Auxiliary Space: O(n*m)

class TopDownMemoizationApproach {

    static int superSeq(String X, String Y, int n, int m, int[][] lookup) {

        if (m == 0 || n == 0) {
            lookup[n][m] = n + m;
        }

        if (lookup[n][m] == 0)
            if (X.charAt(n - 1) == Y.charAt(m - 1)) {
                lookup[n][m] = superSeq(X, Y, n - 1, m - 1, lookup) + 1;
            }

        else {
            lookup[n][m] = Math.min(
                    superSeq(X, Y, n - 1, m, lookup) + 1, superSeq(X, Y, n, m - 1, lookup) + 1);
            }

        return lookup[n][m];
    }

    //Driver Code
    public static void main(String[] args) {
        String X = "AGGTB";
        String Y = "GXGXAYB";

        int[][] lookup = new int[X.length() + 1][Y.length() + 1];

        System.out.print("Length of the shortest supersequence is " + superSeq(X, Y, X.length(), Y.length(), lookup) + "\n");
    }
}