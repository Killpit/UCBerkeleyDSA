package Strings.BasicOperations.SortStringOfCharacters;

//Time Complexity: O(MAX_CHAR*N) which becomes O(N) as MAX_CHAR is constant, So, overall time complexity: - O(N)
//where N is the length of the string
//Auxiliary space: O(1=

public class EfficientApproach{
    static final int MAX_CHAR = 26;

    // function to print string in sorted order
    static void sortString() {

        // Hash array to keep count of characters.
        int[] letters = new int[MAX_CHAR];

        // Traverse string and increment
        // count of characters
        for (char x : "geeksforgeeks".toCharArray()) {

            // 'a'-'a' will be 0, 'b'-'a' will be 1,
            // so for location of character in count
            // array we will do str[i]-'a'.
            letters[x - 'a']++;
        }

        // Traverse the hash array and print
        // characters
        for (int i = 0; i < MAX_CHAR; i++) {
            for (int j = 0; j < letters[i]; j++) {
                System.out.print((char) (i + 'a'));
            }
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        sortString();
    }
}