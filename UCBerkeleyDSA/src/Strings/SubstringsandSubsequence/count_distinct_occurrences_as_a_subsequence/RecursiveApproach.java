package Strings.SubstringsandSubsequence.count_distinct_occurrences_as_a_subsequence;

/*
Approach: Create a recursive function such that it returns count of subsequences of S that match T. Here, m is the length of
T and n is the length of S. This problem can be recursively defined as below.

1-Given the string T is an empty string, returning 1 as an empty string can be the subsequence of all
2-Given the string S is an empty string, returning 0 as no string can be the subsequence of an empty string
3-If the last character of S and T do not match, then remove the last character of S and call the recursive function again.
Because the last character of S cannot be a part of the subsequence or remove it and check for other characters.
4-If the last character of S match, then there can be two possibilities, first, there can be a subsequence where the last
character of S is a part of it and second, where it is not a part of the subsequence. So, the required value will be the
sum of both. Call the recursive function once with the last character of both the strings removed and again with only last
character of S removed
*/

class RecursiveApproach {
    static int f(int i, int j, String s, String t) {
        //base case if second string completed, then we found the matching pattern
        if (j >= t.length()) {
            return 1;
        }
        //If first string is completed, we can not find any matching pattern
        if (i >= s.length()) {
            return 0;
        }
        //If character at i'th place is equal to character at j'th place, then we can either take it or not take it
        if (s.charAt(i) == t.charAt(j)) {
            return f(i + 1, j+ 1, s, t) + f(i + 1, j, s, t);
        }
        //If characters are not equal, then we will increase only first string
        return f(i + 1, j, s, t);
    }

    //Driver code to check above method
    public static void main(String[] args) {
        String T = "ge";
        String S = "geeksforgeeks";
        System.out.println(f(0, 0, S, T));
    }
}