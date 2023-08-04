package Strings.Palindrome.make_largest_palindrome_by_changing_at_most_k_digits;
import java.text.ParseException;

/*
Approach

1-Solve this problem using two pointers method. We start from left and right and if both digits are not equal, then we
replace the smaller value with larger value and decrease k by 1.

2-Stop when the left and right pointers cross each other, after they stop if value of k is negative, then it is not
possible to make string palindrome using k changes. If k is positive, then we can further maximize the string by
looping once again in the same manner from left and right and converting both the digits to 9 and decreasing k by 2.

3-If k value remains to 1 and string length is off, then we make the middle character as 9 to maximize whole value*/

//Time Complexity: O(N),
//Auxiliary Space: O(N) because it is using extra space for creating array and string

class TwoPointers {

    // Returns maximum possible
    // palindrome using k changes
    static String maximumPalinUsingKChanges(String str, int k) {
        char[] palin = str.toCharArray();
        StringBuilder ans = new StringBuilder();

        // Initialize l and r by leftmost and
        // rightmost ends
        int l = 0;
        int r = str.length() - 1;

        // First try to make String palindrome
        while (l < r) {

            // Replace left and right character by
            // maximum of both
            if (str.charAt(l) != str.charAt(r)) {
                palin[l] = palin[r] = (char)Math.max(str.charAt(l), str.charAt(r));
                k--;
            }
            l++;
            r--;
        }

        // If k is negative then we can't make String palindrome
        if (k < 0) {
            return "Not possible";
        }

        l = 0;
        r = str.length() - 1;

        while (l <= r) {

            // At mid character, if K>0 then change it to 9
            if (l == r) {
                if (k > 0) {
                    palin[l] = '9';
                }
            }

            // If character at lth (same as rth) is less than 9
            if (palin[l] < '9') {

        /* If none of them is changed in the previous loop then subtract 2 from K and convert both to 9 */
                if (k >= 2 && palin[l] == str.charAt(l) && palin[r] == str.charAt(r)) {
                    k -= 2;
                    palin[l] = palin[r] = '9';
                }

        /* If one of them is changed in the previous loop then subtract 1 from K (1 more is subtracted already)
        and make them 9 */
                else if (k >= 1 && (palin[l] != str.charAt(l) || palin[r] != str.charAt(r))) {
                    k--;
                    palin[l] = palin[r] = '9';
                }
            }
            l++;
            r--;
        }
        for (char c : palin) ans.append(c);
        return ans.toString();
    }

    // Driver code to test above methods
    public static void main(String[] args)
            throws ParseException
    {
        String str = "43435";
        int k = 3;
        System.out.println(
                maximumPalinUsingKChanges(str, k));
    }
}