package Strings.SubstringsandSubsequence.print_all_subsequences_of_a_string;
import java.util.HashSet;

/*

Step 1: Iterate over the entire String
Step 2: Iterate from the end of the string in order to generate different substring and add the substring to the list
Step 3: Drop kth character from the substring obtained from above to generate different subsequence
Step 4: If the subsequence is not in the list, then recur
*/

//Time Complexity: O(N^3)
//Auxiliary Space: O(N)

public class NoDuplicateCharacters {

    //Set to store all the subsequences
    static HashSet<String> st = new HashSet<>();

    //Function computes all the subsequence of an string
    static void subsequence(String str) {

        //Iterate over the entire string
        for (int i = 0; i < str.length(); i++) {

            //Iterate from the end of the string to generate substrings
            for (int j = str.length(); j > i; j--) {
                String sub_str = str.substring(i, j);

                st.add(sub_str);

                //Drop kth character in the substring and if its not in the set, then recur
                for (int k = 1; k < sub_str.length() - 1; k++) {
                    StringBuilder sb = new StringBuilder(sub_str);

                    //Drop character from the string
                    sb.deleteCharAt(k);
                    subsequence(sb.toString());
                }
            }
        }
    }

    //Driver Code
    public static void main(String[] args) {
        String s = "aabc";
        subsequence(s);
        System.out.println(st);
    }
}