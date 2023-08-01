package Strings.Palindrome.check_if_characters_of_a_given_string_can_be_rearranged_to_form_a_palindrome;
import java.util.ArrayList;
import java.util.List;

/*Steps for O(N) time

1-Create a character list
2-Traverse the given string
3-For every character in the string, remove the character if the list already contains else to add to the list
4-If the string length is even, the list is expected to be empty
5-Or if the string length is odd, the list size is expected to be 1
6-On the above, two conditions (3) or (4) return true else return false
*/

//Time Complexity: O(N*N) as we are using a loop to traverse N times and in each traversal, we are using the find
//function to get the position of a character which will cost O(N) time. Where N is the length of the string
//Auxiliary Space: O(N), as we are using extra space for the array of characters list. Where N is the length of the
//string

class ListApproach {

    //function to check whether characters of a string can form a palindrome
    static boolean canFormPalindrome(String str) {

        //Create a list
        List<Character> list = new ArrayList<>();

        //For each character in input strings, remove character if list contains, else, add character to list
        for (int i = 0; i < str.length(); i++) {
            if (list.contains(str.charAt(i)))
                list.remove((Character) str.charAt(i));
            else
                list.add(str.charAt(i));
        }

        //If character length is even, list is expected to be empty or if character length is odd list size is
        //expected to be 1

        //If string length is even
        //if string length is off
        return str.length() % 2 == 0 && list.isEmpty() || (str.length() % 2 == 1 && list.size() == 1);
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