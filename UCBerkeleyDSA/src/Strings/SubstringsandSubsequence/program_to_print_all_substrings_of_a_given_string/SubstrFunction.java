package Strings.SubstringsandSubsequence.program_to_print_all_substrings_of_a_given_string;

//Time Complexity: O(n^3)
//Auxiliary Space: O(1)

public class SubstrFunction {

    //Function to print all substring
    public static void subString(String str, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)
                System.out.println(str.substring(i, j));
    }

    public static void main(String[] args) {
        String str = "abcd";
        subString(str, str.length());
    }
}