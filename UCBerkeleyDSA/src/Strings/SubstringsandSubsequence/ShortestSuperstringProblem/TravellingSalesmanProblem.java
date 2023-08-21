package Strings.SubstringsandSubsequence.ShortestSuperstringProblem;
import java.util.Arrays;
import java.util.Stack;

//Time Complexity: O(n^2 * 2^n), where N is the length of the string array
//Auxiliary Space: O(2^n * N)

class TravellingSalesmanProblem {

    //Function to calculate shortest super string
    public static String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];

        //Build the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }

        //Creating dp array
        int[][] dp = new int[1 << n][n];

        //Creating path array
        int[][] path = new int[1 << n][n];
        int last = -1, min = Integer.MAX_VALUE;

        //start TSP DP
        for (int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);

            //Iterate j from 0 to n - 1
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);

                    //Check if prev is zero
                    if (prev == 0) {
                        dp[i][j] = A[j].length();
                    }
                    else {

                        //Iterate k from 0 to n - 1
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if (i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }

        //Build the path
        StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;

        //Creating a stack
        Stack<Integer> stack = new Stack<>();

        //Until cur is zero, push last
        while (cur > 0) {
            stack.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }

        //Build the result
        int i = stack.pop();
        sb.append(A[i]);

        //Until the stack is empty
        while (!stack.isEmpty()) {
            int j = stack.pop();
            sb.append(A[j].substring(A[j].length() - graph[i][j]));
            i = j;
        }
        return sb.toString();
    }

    //Function to check
    public static int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }

        //Return the size of b
        return b.length();
    }

    //Driver Code
    public static void main(String[] args) {
        String[] arr = { "catgc", "ctaagt",
                "gcta", "ttca", "atgcatc" };

        System.out.println("The Shortest Superstring is " + shortestSuperstring(arr));
    }
}