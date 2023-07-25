package Strings.BasicOperations.remove_all_occurrences_of_a_character_in_a_string;

//Time Complexity: O(N), where n is length of input string
//Auxiliary Space: O(1)

public class SecondApproach {

    public static String removechar(String word, char ch) {
        StringBuilder s = new StringBuilder(word);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                s.deleteCharAt(i);
                i--;
            }
        }

        return s.toString();
    }

    //Driver code
    public static void main(String[] args) {
        String word = "geeksforgeeks";
        char ch ='e';
        System.out.println(removechar(word, ch));
    }
}