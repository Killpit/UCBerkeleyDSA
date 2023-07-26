package Strings.BinaryString.GenetateAllBinaryStringsWithoutConsecutive1s;

//Time Complexity: O(2^N)
//Auxiliary Space: O(N)

public class StringApproach {

    static void All_Binary_Strings(String str, int num) {
        int len = str.length();
        if (len == num) {
            System.out.print(str + " ");
        } else if (str.charAt(len - 1) == '1')
            All_Binary_Strings(str + '0', num);
            else {
                All_Binary_Strings(str + '0', num);
                All_Binary_Strings(str + '1', num);
            }
        }

        static void print(int num) {
        String word = "";
        word += '0';
        All_Binary_Strings(word, num);
        word = "1";
        All_Binary_Strings(word, num);
        }

        //Driver Code
    public static void main(String[] args) {
        int n = 4;
        print(n);
    }
}