package Strings.Palindrome.online_algorithm_for_checking_palindrome_in_a_stream;

/*Steps for Rabin Karp

1-The first character is always a palindrome, so print yes for first character.
2-Initialize reverse of first half as "a" and second half as "b". Let the hash value of first half reverse be 'firstr'
and that of second half be 'second'.
3-Iterate through string starting from second character, do following for every character str[i]
    a) If 'firstr' and 'second' are same, then character by character, check the substring ending with current
    character and print "Yes" if palindrome.
    Note that if values match, then strings need not be same.
    b)Update 'firstr' and 'second' for next iteration.
    If 'i' is even, then add next character to the beginning of 'firstr' and end of second half and update hash values.
    If 'i' is odd, then keep 'firstr' as it is, remove leading character from second and append a next character at end
*/

//Time Complexity: O(N*N), worst case time complexity
//Space Complexity: O(1), the algorithm uses a fixed number of variables (which is independent of the size of the
//input string). Hence, the space complexity of the algorithm is O(1)

public class RabinKarp {
    //d is the number of characters in input alphabet
    static final int d = 256;

    //q is a prime number used for evaluating Rabin Karp's Rolling hash
    static final int q = 103;

    static void checkPalindrome(String str) {
        //Length of input string
        int N = str.length();

        //A single character is always a palindrome
        System.out.println(str.charAt(0)+ " Yes");

        //Return if string has only one character
        if (N == 1) return;

        //Initialize first half reverse and second half for as firstr and second characters
        int firstr = str.charAt(0) % q;
        int second = str.charAt(1) % q;

        int h = 1, i, j;

        //Now check for palindromes from second character onward
        for (i = 1; i < N; i++) {
            //If the hash values of 'firstr' and 'second' match, then only check individual characters
            if (firstr == second) {
                //Check if str[0..i] is palindrome using simple character by character match
                for (j = 0; j < i/2; j++) {
                    if (str.charAt(j) != str.charAt(i-j))
                        break;
                }
                System.out.println((j == i/2) ? str.charAt(i) + " Yes": str.charAt(i) + " No");
            }
            else System.out.println(str.charAt(i) + " No");

            //Calculate hash values for next iteration. Don't calculate hash for next characters if this is the last
            //character of string
            if (i != N - 1) {
                //If i is even (next i is odd)
                if (i % 2 == 0) {
                    //Add next character after first half at beginning of 'firstr'
                    h = (h * d) % q;
                    firstr = (firstr + h *str.charAt(i / 2)) % q;

                    //Add next character after seconf half at the end of second half
                    second = (second * d + str.charAt(i + 1)) % q;
                }
                else {
                    //If next i is odd(next i is even), then we need not to change firstr, we need to remove first
                    //character of second and append a character to it
                    second = (d * (second + q - str.charAt(i + 1) / 2) * h) % q + str.charAt(i + 1) % q;
                }
            }
        }
    }

    //Driver program
    public static void main(String[] args) {
        String txt = "aabaacaabaa";
        checkPalindrome(txt);
    }
}