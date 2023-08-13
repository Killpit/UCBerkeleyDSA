package Strings.SubstringsandSubsequence.print_all_subsequences_of_a_string;
import java.util.*;

/*
* Implementation

* We take the string as input
* We declare a vector of strings to store each sub-sequence as a string
* Each time call the function with 1, 2, 3 and so on, and we only push those indexes in our string whose bit is set, and
we keep incrementing our index pointer.
* Once we have generated the corresponding sub-sequence for a binary representation, we can push this string into our
vector of string.
* Finally, we can print our vector of strings and get the desired output*/

//Time Complexity: O(n * 2^n)
//Auxiliary Space: O(n)

public class BinaryRepresentationOfNumbers {

    //function to find where the bit is set
    public static String print(String s, int i) {

        int j = 0;
        StringBuilder sub = new StringBuilder();

        //finding the bit is set
        while (i > 0) {
            if ((i & 1) == 1) {
                sub.append(s.charAt(j));
            }
            j++;
            i = i >> 1;
        }
        return sub.toString();
    }

    //function to create sub-sets
    public static List<String> createSubsets(String s) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < (1<<s.length()); i++) {
            //each time we create a subsequence for corresponding binary representation
            res.add(print(s, i));
        }
        return res;
    }

    //main function to call
    public static void main(String[] args) {
        String s = "abc";

        //Vector of strings to store all sub-sequences
        List<String> print = createSubsets(s);

        //print the subsets
        for (String string : print) {
            for (int j = 0; j < string.length(); j++) {
                System.out.print(string.charAt(j) + " ");
            }
            System.out.println();
        }
    }
}