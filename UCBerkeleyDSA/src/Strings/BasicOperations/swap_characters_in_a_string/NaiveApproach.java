package Strings.BasicOperations.swap_characters_in_a_string;

/*Algorithm:
*
* For large values of B, the naive approach of looping B times, each time swapping ith character with (i+C)%Nth
character will result in high CPU time

* The trick to solving this problem is to observe the resultant string after every N iterations, where N is the
length of the string S.

* Again, if C is greater than or equal to the N, it is effectively equal to the remainder of C divided by N

* Hereon, let's consider C to be less than N*/

//Time Complexity: O(B), to iterate B times
//Auxiliary Space: O(1)

public class NaiveApproach {
    public static String swapCharacters(String s, int B, int C) {
        int N = s.length();

        //If c is greater than n
        C = C % N;

        //loop to swap ith element with (i + C) % nth element
        char[] arr = s.toCharArray();

        for (int i = 0; i < B; i++) {
            char temp = arr[i];
            arr[i] = arr[(i + C) % N];
            arr[(i + C) % N] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "ABCDEFGH";
        int B = 4;
        int C = 3;
        s = swapCharacters(s, B, C);
        System.out.println(s);
    }
}