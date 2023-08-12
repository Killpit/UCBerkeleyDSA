package Strings.SubstringsandSubsequence.print_all_subsequences_of_a_string;
import java.util.*;

/*Time Complexity: O(2^N), the time complexity of this approach is O(2^N), where N is the length of the given string.
* This is because, for a string of length N, we are generating a total of 2^N subsequences*/

/*Space Complexity: O(N), the recursive function call stack requires O(N) space for the worst case, where N is the length
* of the given string*/

public class PickAndDontPick {

    //Declare a global list
    static List<String> al = new ArrayList<>();

    //Creating a public static ArrayList such that we can store values
    //If there is any question of returning the, we can directly return too
    // public static ArrayLisy<String> al = new ArrayList<String>();
    public static void main(String[] args) {
        String s = "abcd";
        findSubsequences(s, "");
        System.out.println(al);
    }

    private static void findSubsequences(String s, String ans) {
        if (s.isEmpty()) {
            al.add(ans);
            return;
        }

        //We add adding 1st character in string
        findSubsequences(s.substring(1), ans + s.charAt(0));

        //Not adding the first chatacter of the string because the concept of subsequence either character will present
        //or not
        findSubsequences(s.substring(1), ans);
    }
}
