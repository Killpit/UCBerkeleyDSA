package Strings.BinaryString.CheckIfAllBitsCanBeMadeSameBySingleFlip;

//Time Complexity: O(N)
//Auxiliary Space: O(1)

public class CountingZerosAndOnes {
    static boolean isOneFlip(String str) {
        int sum = 0;
        int n = str.length();

        //Traverse through given string and count the total sum of numbers
        for (int i = 0; i < n; i++)
            sum += str.charAt(i) - '0';

        //Return true if any of the two counts is 1
        return (sum == n - 1 || sum == 1);
    }

    //Main function
    public static void main(String[] args) {
        System.out.println(isOneFlip("101111111111") ? "Yes" : "No");
    }
}