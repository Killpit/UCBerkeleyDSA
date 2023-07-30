package Strings.Palindrome.check_if_a_given_string_is_a_rotation_of_a_palindrome;

/*An Optimized Solution can work in O(N) time. The idea here is to use Manacher's algorithm to solve the above problem
 *
 * Let the given string be 's' and length of string be 'n'
 *
 * Preprocess/prepare the string to use Manacher's algorithm, to help find even length palindrome, for which we
 * concatenate the given string with itself (to find if rotation will give a palindrome) and add '$' symbol at the
 * beginning and '#' characters between letters. We end the string using '@'. So for 'aaad' input, the reformed string
 * will be - '$#a#a#a#a#d#a#a#a#a#d#@'
 *
 * Now the problem reduces to finding Longest Palindromic Substring using Manacher's algorithm of length N or greater
 * in the string
 *
 * If there is palindromic substring of length N, then return true, else return false. If we find a palindrome of
 * greater length, then we check if the size of our input is even or odd, correspondingly, our palindrome length found
 * should also be even or odd*/

//Time Complexity: O(N^2)
//Auxiliary Space: O(N)

class OptimizedSolution {

    //Function to check if we have found a palindrome of same length as the input which is a rotation of the input
    //string
    static boolean checkPal(int x, int len) {
        if (x == len) {
            return true;
        } else if (x > len) {
            return x % 2 == 0;
        }
        return false;
    }

    //Function to preprocess the string for Manacher's Algorithm
    static String reform(String  s) {
        StringBuilder s1 = new StringBuilder("$#");

        //Adding # between the characters
        for (int i = 0; i < s.length(); i++) {
            s1.append(s.charAt(i));
            s1.append('#');
        }

        s1.append('@');
        return s1.toString();
    }

    //Function to find the longest palindromic substring using Manacher's algorithm
    static boolean longestPal(String s, int len) {

        //Current Left position
        int mirror;

        //Center right position
        int R = 0;

        //Center position
        int C = 0;

        //LPS Length Array
        int[] P = new int[s.length()];

        //Get currentLeftPosition Mirror for currentRightPosition i
        for (int i = 1; i < s.length() - 1; i++) {
            mirror = 2 * C - i;

            //If currentRightPosition i is within centerRightPosition R
            if (i < R) {
                P[i] = Math.min((R - i), P[mirror]);
            }

            //Attempt to expand palindrome centered at currentRightPosition i
            while (s.charAt(i + (1 + P[i])) == s.charAt(i - (1 + P[i]))) {
                P[i]++;
            }

            //Check for palindrome
            boolean ans = checkPal(P[i], len);
            if (ans) {
                return true;
            }

            /*If palindrome centered at currentRightPosition i, expand beyond centerRightPosition R, adjust
            * centerPosition C based on expanded palindrome*/
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        return false;
    }

    //Driver code
    public static void main(String[] args) {
        String s = "aaaad";
        int len = s.length();
        s += s;
        s = reform(s);
        System.out.println(longestPal(s, len) ? 1 : 0);
    }
}