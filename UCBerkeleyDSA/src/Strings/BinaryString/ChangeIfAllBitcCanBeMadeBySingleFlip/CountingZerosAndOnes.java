package Strings.BinaryString.ChangeIfAllBitcCanBeMadeBySingleFlip;

/*If all digits of a string can be made identical by doing exactly one flip, that means the string has all its digits
* equal to one another except this digit which has to be flipped, and this digit must be different than all other
* digits of the string. The value of this digit could be either zero or one. Hence, this string will either have
* exactly one digit equal to zero, and all other digits equal to one, or exactly one digit equal to one, and all
* other digit equal to zero.*/

//Time Complexity: O(N), where N is the length of the string
//Auxiliary Space: O(1)

public class CountingZerosAndOnes {

    //This function returns true if we can bits same in given binary string str
    static boolean canMakeAllSame(String str) {
        int zeros = 0, ones = 0;

        //Traverse through given string and count numbers of 0's and 1's
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0')
                ++zeros;
            else
                ++ones;
        }

        //Return true if any of the two counts is 1
        return (zeros == 1 || ones == 1);
    }

    //Driver code
    public static void main(String[] args) {
        System.out.println(canMakeAllSame("101") ? "Yes" : "No");
    }
}