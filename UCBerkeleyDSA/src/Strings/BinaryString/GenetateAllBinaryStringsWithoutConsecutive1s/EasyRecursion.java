package Strings.BinaryString.GenetateAllBinaryStringsWithoutConsecutive1s;
import java.util.ArrayList;

//Time Complexity: O(2^n), where n is the length of the binary strings to be generated.
//Auxiliary Space: O(2^n), because at any point in time, the function stores all the binary strings generated so far
//in the result list, and as the number of strings generated is 2^n.

public class EasyRecursion {
    public static ArrayList<String> generateBinaryStrings(int n) {
        if (n == 0) {
            ArrayList<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }
        if (n == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> prevList = generateBinaryStrings(n - 1);
        for (String s : prevList) {
            result.add(s + "0");
            if (s.charAt(s.length() - 1) != '1') {
                result.add(s + "1");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> binaryStrings = generateBinaryStrings(4);
        for (String s : binaryStrings) {
            System.out.print(s + " ");
        }
    }
}