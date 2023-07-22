package Strings.BinaryString.CheckIfAllBitsCanBeMadeSameBySingleFlip;

//Time Complexity: O(N), where N is the length of the string
//Auxiliary Space: O(1)

public class Counting0and1 {

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