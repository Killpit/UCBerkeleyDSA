package Strings.Palindrome.minimum_insertions_to_form_a_palindrome_with_permutations_allowed;

/*A palindromic string can have one off character only when the length of the string is odd otherwise all characters occur
* when the length of the string is odd, otherwise all characters occur an even number of times. So, we have to find
* characters that occur at odd times in a string.
*
* The idea is to count the occurrence of each character in a string. As a palindromic string can have one character which
* occurs odd times, so, the number of insertions will be one less than the count of characters that occur at odd times.
* And if the string is already palindrome, we do not need to add any character, so, the result will be 0*/

//Time Complexity: O(N)
//Auxiliary Space: O(1)

public class Method1 {

    //Function will return the number of characters to be added
    static int minInsertion(String str) {
        //To store string length
        int n = str.length();

        //To store number of characters occurring odd number of times
        int res = 0;

        //To store count of each character
        int[] count = new int[26];

        //To store occurrence of each character
        for (int i = 0; i < n; i++)
            count[str.charAt(i) - 'a']++;

        //To count characters with off occurrence
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1)
                res++;
        }

        //As one character can be odd return res - 1, but if string is already palindrome, return 0
        return (res == 0) ? 0 : res - 1;
    }

    //Driver program
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(minInsertion(str));
    }
}