package Strings.BinaryString.generate_n_bit_gray_codes;
import java.util.*;

/*
The idea is to recursively append the bit 0 and 1 each time until the number of bits is not equal to N.

Base condition: The base case for this problem will be when the value of N = 0 or 1

Recursive condition: Otherwise, for any value greater than 1, recursively generate the gray codes of the N - 1 bits
and then for each of the gray code generated, add the prefix 0 and 1
*/

//Time Complexity: O(2^N)
//Auxiliary Space: O(2^N)

class RecursiveApproach {

    //This function generates all n-bit Gray codes and prints the generated codes
    static ArrayList<String> generateGray(int n) {

        //Base case
        if (n <= 0) {
            return new ArrayList<>() {{
                add("0");
            }};
        }
        if (n == 1) {
            return new ArrayList<>() {{
                add("0");
                add("1");
            }};
        }

        //Recursive case
        ArrayList<String> recAns = generateGray(n - 1);
        ArrayList<String> mainAns = new ArrayList<>();

        //Append 0 to the first half
        for (String s : recAns) {
            mainAns.add("0" + s);
        }

        //Append 1 to the second half
        for (int i = recAns.size() - 1; i >= 0; i--) {
            String s = recAns.get(i);
            mainAns.add("1" + s);
        }
        return mainAns;
    }

    //Function to generate the Gray code of N bits
    static void generateGrayArr(int n) {
        ArrayList<String> arr;
        arr = generateGray(n);

        //print contents of arr
        for (String s : arr) {
            System.out.println(s);
        }
    }

    //Driver code
    public static void main(String[] args) {
        generateGrayArr(3);
    }
}