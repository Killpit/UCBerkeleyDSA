package Strings.BasicOperations.remove_all_occurrences_of_a_character_in_a_string;
import java.lang.*;

/*Here, our recursive function's base case will be when string length's become 0. And in the recursive function, if
* the encountered character is the character is the character that we have to remove, then call the recursive
* function, if the encountered character is the character that we have to remove, then call the recursive function
* from the next character, else, store this character in answer and then call the recursive function from the next
* character*/

//Time Complexity: O(N), where N is the length of the input string
//Auxiliary Space: O(N), if we consider recursion stack space

class RecursiveApproach {
    //Function to remove all occurrences of a character in the string
    static String removeChar(String str, char ch) {
        //Base Case
        if (str.length() == 0) {
            return "";
        }

        //Check the first character of the given string
        if (str.charAt(0) == ch) {

            //Pass the rest of the string to recursion Function call
            return removeChar(str.substring(1), ch);
        }

        //Add the first character of str and string from recursion
        return str.charAt(0) + removeChar(str.substring(1), ch);
    }

    //Driver Code
    public static void main(String[] args) {
        //Given String
        String str = "geeksforgeeks";

        //Function call
        str = removeChar(str, 'g');
        System.out.println(str);
    }
}