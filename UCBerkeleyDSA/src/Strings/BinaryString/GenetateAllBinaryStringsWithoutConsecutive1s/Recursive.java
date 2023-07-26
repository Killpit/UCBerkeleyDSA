package Strings.BinaryString.GenetateAllBinaryStringsWithoutConsecutive1s;
import java.lang.*;

/*

K : size of string
First We Generate All string starts with '0'
initialize n = 1 .
GenerateALLString ( K  , Str , n )
  a. IF n == K
     PRINT str.
  b. IF previous character is '1' :: str[n-1] == '1'
     put str[n] = '0'
     GenerateAllString ( K , str , n+1 )
  c. IF previous character is '0' :: str[n-1] == '0'
     First We Put zero at end and call function
      PUT  str[n] = '0'
           GenerateAllString ( K , str , n+1 )
      PUT  str[n] = '1'
           GenerateAllString ( K , str , n+1 )

Second Generate all binary string starts with '1'
DO THE SAME PROCESS

*/

//Time Complexity: O(2^K) where K is the size of the binary string. This is due to the fact that the algorithm
//recursively generates all possible binary strings of length K
//Auxiliary space: O(K), since we are using a string array of size K to store the binary string.

public class Recursive {

    //Array conversion to String
    public static String toString(char[] a) {
        return new String(a);
    }

    static void generate(int k, char[] ch, int n) {

        //Base condition when we reached at the end of the array
        if (n == k) {

            //Printing the generated string
            //Return to the previous case
            System.out.print(toString(ch) + " ");
            return;
        }

        //If the first Character is zero, then adding
        if (ch[n - 1] == '0') {
            ch[n] = '0';
            generate(k, ch, n + 1);
            ch[n] = '1';
            generate(k, ch, n + 1);
        }

        //If the character is one, then add zero to next
        if (ch[n - 1] == '1') {

            ch[n] = '0';

            //Calling recursively for the next value of array
            generate(k, ch, n + 1);
        }
    }

    static void fun(int k) {

        if (k <= 0) {
            return;
        }

        char[] ch = new char[k];

        //Initializing first character to Zero
        ch[0] = '0';

        //Generating Strings starting with Zero--
        generate(k, ch, 1);

        //Initialized first character to one--
        ch[0] = '1';
        generate(k, ch, 1);
    }

    public static void main(String[] args) {

        int k = 3;

        //Calling function fun with argument k
        fun(k);
    }
}
