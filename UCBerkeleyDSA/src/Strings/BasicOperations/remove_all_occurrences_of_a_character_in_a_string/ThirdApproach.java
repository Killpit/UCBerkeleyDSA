package Strings.BasicOperations.remove_all_occurrences_of_a_character_in_a_string;

//Time Complexity: O(N), where N is the length of the input string
//Auxiliary Space: O(1)

public class ThirdApproach {
    //function for removing the occurrence of character using replace() function
    public static void removeChar(String word, char ch) {
        word = word.replace(Character.toString(ch), "");
        System.out.println(word);
    }

    //Driver code
    public static void main(String[] args) {
        String word = "geeksforgeeks";
        removeChar(word, 'k');
    }
}