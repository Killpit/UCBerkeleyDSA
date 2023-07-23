package Strings.BasicOperations.SortStringOfCharacters;
import java.util.Arrays;

//Time Complexity: O(NlogN), where N is the length of string
//Auxiliary Space: O(1)

class SimpleApproach {

    //function to print string in sorted order
    static void sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.println(String.valueOf(arr));
    }

    //Driver program to test above function
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        sortString(s);
    }
}
