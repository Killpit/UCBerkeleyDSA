package Strings.Palindrome.check_if_a_given_string_is_a_rotation_of_a_palindrome;

/*A simple solution is to take the input string, try every possible rotation of it and return true if a rotation is a
* palindrome, then return false*/

//Time Complexity: O(N^2)
//Auxiliary Space: O(N) for storing rotations

/*Note that the above algorithm can be optimized to work in O(1) extra space as we can rotate a string in O(N) time
* and O(1) extra space*/

class SimpleSolution {
    //A utility function is to check if a string str is palindrome
    static boolean isPalindrome(String str) {
        //Start from leftmost and rightmost corners of str
        int l = 0;
        int h = str.length() - 1;

        //Keep comparing characters while they are same
        while (h > 1)
            if (str.charAt(l++) != str.charAt(h--))
                return false;

        //If we reach here, then all characters were matching
        return true;
    }

    //Function to check if a given string is a rotation of a palindrome
    static boolean isRotationOfPalindrome(String str) {
        //If string itself is palindrome
        if (isPalindrome(str))
            return true;

        //Now try all rotations one by one
        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            String str1 = str.substring(i + 1);
            String str2 = str.substring(0, i + 1);

            //Check if this rotation is palindrome
            if (isPalindrome(str1 + str2))
                return true;
        }
        return false;
    }

    //Driver program
    public static void main(String[] args) {
        System.out.println((isRotationOfPalindrome("aab")) ? 1 : 0);
        System.out.println((isRotationOfPalindrome("abcde")) ? 1 : 0);
        System.out.println((isRotationOfPalindrome("aaaad")) ? 1 : 0);
    }
}