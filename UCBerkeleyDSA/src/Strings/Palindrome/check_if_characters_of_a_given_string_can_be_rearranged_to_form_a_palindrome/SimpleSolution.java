package Strings.Palindrome.check_if_characters_of_a_given_string_can_be_rearranged_to_form_a_palindrome;
import java.util.*;

/*A simple solution is to run two loops, the outer loop picks all characters one by one, and the inner loop counts the
* number of occurrences of the picked character. We keep track of odd counts. The time complexity of this solution is
* O(n^2)*/

/*Steps for O(N) time

1-Create a count array of alphabet size, which is typically 256. Initialize all values of the count array as 0.
2-Traverse the given string and increment count of every character.
3-Traverse the count array and if the count array has more than one odd value, return false. Otherwise, return true.*/

//Time Complexity: O(N), as we are using a loop to traverse N times. Where N is the length of the string
//Auxiliary Space: O(256), as we are using extra space for the array count

class SimpleSolution {

    static int NO_OF_CHARS = 256;

    //Function to check whether characters of a string can form a palindrome
    static boolean canFormPalindrome(String  str) {

        //Create a count array and initialize all values as 0
        int[] count = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        //For each character in input strings, increment count in the corresponding count array
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        //Count off occurring characters
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return false;
        }

        //Return true if odd count is 0 or 1,
        return true;
    }

    //Driver code
    public static void main(String[] args) {
        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (canFormPalindrome("geeksogeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}