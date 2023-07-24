package Strings.BasicOperations.swap_characters_in_a_string;

/*Algorithm

* If we observe the string that is formed after every N successive iterations and swaps (let's call it one full
iteration), we can start to get a pattern.

* We can find that the string is divided into two parts: the first part of length C compromising of the first C
characters of S, and the second part comprising the rest of the characters

* The two parts are rotated by some places. The first part is rotated right by (N % C) places every full iteration

* The second part is rotated left by C places every full iteration

* We can calculate the number of full iterations f by dividing B by N

* So, the first part will be rotated left by (N%C)*f. This value can go beyond C and so, it is effectively
((N%C)*f) % C

* The second part will be rotated left by C*f places. Since, this value can go beyond the length of second part
which is (N-C), it is effectively ((C*f) % (N-C)), the second part will be rotated by ((C*f) % (N-C)) places left

* After f full iterations, there may still be some iterations remaining to complete B iterations. This value is B % N
which is less than N. We can follow the naive approach on these remaining iterations after f full iterations to get
the resultant string
*/

//Time Complexity: O(N)
//Space Complexity: O(N)

class EfficientApproach {

    //Method to find the required string

    String swapChars(String s, int c, int b) {
        //Get string length
        int n = s.length();

        //If c is larger or equal to the length of the string is effectively the remainder of c divided by the
        //length of the string
        c = c % n;

        if (c == 0) {
            //No change will happen
            return s;
        }

        int f = b / n;
        int r = b % n;

        //Rotate first c characters by (n % c) places f times
        String p1 = rotateLeft(s.substring(0, c), ((n % c) * f) % c);

        //Rotate remaining character by (n * f) places
        String p2 = rotateLeft(s.substring(c), ((c * f) & (n - c)));

        //Concatenate the two parts and convert the resultant string formed after f full iterations to a character
        //array (for final swaps)
        char[] a = (p1 + p2).toCharArray();

        //Remaining swaps
        for (int i = 0; i < r; i++) {

            //Swap ith character with (i + c)th character
            char temp = a[i];
            a[i] = a[(i + c) % n];
            a[(i + c) % n] = temp;
        }

        return new String(a);
    }

    String rotateLeft(String s, int p) {
        //Rotating a string p times left is effectively cutting the first p characters and placing them at the end
        return s.substring(p) + s.substring(0, p);
    }

    //Driver code
    public static void main(String[] args) {
        //Given values
        String s1 = "ABCDEFGHIJK";
        int b = 1000;
        int c = 3;

        //get final string
        String s2 = new EfficientApproach().swapChars(s1, c, b);

        //print final string
        System.out.println(s2);
    }
}