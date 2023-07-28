package Strings.BinaryString.FindIthIndexCharacterInABinaryStringObtainedAfterNIterations;

/*Steps

1-Change a decimal number into binary and store it in string s
2-Run loop n times in each iteration. Run another loop of string length s to convert 0 to "01" and 1 to "10" to
another string s1. After completion of each iteration, assign string s1 to s.
3-Finally, return the value of the ith index in string s.
*/

//Time Complexity: O(N^2)
//Auxiliary Space: O(N)

class FindIthIndexCharacterInABinaryStringObtainedAfterNIterations {
    static String s = "";
    static String ReverseString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return new String(arr);
    }

    //Function to store binary representation
    static void binaryConversion(int m) {
        while (m != 0) {
            int tmp = m % 2;
            s += Integer.toString(tmp);
            m = (int) (m / 2);
        }

        s = ReverseString(s);
    }

    //Function to find ith character
    static int findCharacter(int n, int m, int i) {
        //Function to change decimal to binary
        binaryConversion(m);

        String s1 = "";
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < s.length(); y++) {
                if (s.charAt(y) == '1')
                    s1 += "10";
                else
                    s1 += "01";
            }

            //Assign s1 String in s String
            s = s1;
            s1 = "";
        }

        return s.charAt(i) - '0';
    }

    //Driver code
    public static void main(String[] args) {
        int m = 5, n = 2, i = 8;
        System.out.println(findCharacter(n, m, i));
    }
}
