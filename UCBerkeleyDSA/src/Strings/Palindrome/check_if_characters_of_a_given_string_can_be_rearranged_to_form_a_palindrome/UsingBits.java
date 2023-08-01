package Strings.Palindrome.check_if_characters_of_a_given_string_can_be_rearranged_to_form_a_palindrome;

//Time Complexity: O(N), as we are using a loop traverse N times. Where N is the length of the string.
//Auxiliary Space: O(1), as we are not using any extra space.

class UsingBits {

    static boolean canFormPalindrome(String a) {

        //Bitvector to store the record of which characters appear odd and even number of times
        int bitvector = 0, mask;
        for (int i = 0; i < a.length(); i++) {
            int x = a.charAt(i) - 'a';
            mask = 1 << x;

            bitvector = bitvector ^ mask;
        }

        return (bitvector & (bitvector - 1)) == 0;
    }

    //Driver code
    public static void main(String[] args) {
        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}