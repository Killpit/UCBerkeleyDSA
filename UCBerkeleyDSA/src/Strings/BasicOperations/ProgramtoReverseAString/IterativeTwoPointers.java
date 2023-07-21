package Strings.BasicOperations.ProgramtoReverseAString;

//Time Complexity: O(N)
//Auxiliary Space: O(1)

class IterativeTwoPointers {
    static void reverseStr(String str) {
        int n = str.length();
        char[] ch = str.toCharArray();
        char temp;

        //Swap character starting from two corners
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

        System.out.println(ch);
    }

    //Driver program
    public static void main(String[] args) {

        String str = "geeksforgeeks";
        reverseStr(str);
    }
}
