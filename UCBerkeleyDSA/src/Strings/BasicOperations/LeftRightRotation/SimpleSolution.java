package Strings.BasicOperations.LeftRightRotation;

/*A simple solution is to use a temporary string to do rotations. For left rotation, first, copy last n-d characters,
* then copy first d characters in order to the temporary string. For right rotation, first, copy last d characters,
* then copy n-d characters*/

/*Reversal algorithm for rotation

// Left rotate string s by d (Assuming d <= n)
leftRotate(s, d)
  reverse(s, 0, d-1); // Reverse substring s[0..d-1]
  reverse(s, d, n-1); // Reverse substring s[d..n-1]
  reverse(s, 0, n-1); // Reverse whole string.

// Right rotate string s by d (Assuming d <= n)
rightRotate(s, d)

  // We can also call above reverse steps
  // with d = n-d.
  leftRotate(s, n-d)
*/

//Time Complexity: O(N), where N is the size of the given string
//Auxiliary Space: O(1), no extra space is required, so it is a constant

class SimpleSolution {

    //function that rotates s towards left by d
    static String leftrotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    //Function that rotates s towards right by d
    static String rightrotate(String str, int d) {
        return leftrotate(str, str.length() - d);
    }

    //Driver code
    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        System.out.println(leftrotate(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(leftrotate(str2, 2));
    }
}