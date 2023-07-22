package Strings.BinaryString.NumberOfFlipsToMakeBinaryStringAlternative;

//Time Complexity: O(N)
//Auxiliary Space: O(1)

class NumberOfFlipsToMakeBinaryStringAlternateSet1 {

    //Utility method to flip a character
    public static char flip(char ch) {
        return (ch == '0') ? '1' : '0';
    }

    //Utility method to get minimum flips when alternate string starts with expected char
    public static int getFlipWithStartingCharacter(String str, char expected) {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++) {
            //If current character is not expected, increase flip count
            if (str.charAt(i) != expected)
                flipCount++;

            //flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }

    //method return minimum flip to make binary string alternate
    public static int minFlipToMakeStringAlternate(String str) {
        /* return minimum of following two
        * 1) flips when alternate string starts with
        * 2) flips when alternate string starts with 1 0
        */
        return Math.min(getFlipWithStartingCharacter(str, '0'),
                getFlipWithStartingCharacter(str, '1'));
    }

    //Driver code to test above method
    public static void main(String[] args) {
        String str = "0001010111";
        System.out.println(minFlipToMakeStringAlternate(str));
    }
}