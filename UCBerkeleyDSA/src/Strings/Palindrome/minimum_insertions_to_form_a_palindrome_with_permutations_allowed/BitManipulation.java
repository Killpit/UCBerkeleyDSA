package Strings.Palindrome.minimum_insertions_to_form_a_palindrome_with_permutations_allowed;

/*Steps
* Create a mask and initialise it to zero
* For each character in string str, toggle the bit into the mask with its corresponding position in the alphabet
* Check if mask is equal to zero, and return 0
* Otherwise, return number of setbit in mask - 1 */

//Time Complexity: O(N)
//Auxiliary Space: O(1)

public class BitManipulation {

    //Function will return number of characters to be added
    static int minInsertion(String str) {
        long mask = 0;

        for (char c: str.toCharArray())
            mask ^= (1L << (c - 'a'));

        if (mask == 0)
            return 0;
        int count = 0;

        while (mask != 0) {
            count += (int) (mask & 1);
            mask = mask >> 1;
        }

        return count - 1;
    }

    //Driver program
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(minInsertion(str));
    }
}