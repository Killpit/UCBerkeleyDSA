package Strings.BasicOperations.LeftRightRotation;

/*We can use extended string which is double in size of normal string to rotate string. For left rotation, access the
* extended string from index n to the index len(string) + n. For right rotation, rotate the string left with size-d
* places.*/

/*The idea is

// Left rotate string s by d
leftRotate(s, n)
  temp = s + s; // extended string
  l1  = s.length // length of string
  return temp[n : l1+n] //return rotated string.

// Right rotate string s by n
rightRotate(s, n)
  // We can also call above reverse steps
  // with x = s.length - n.
  leftRotate(s, x-n)

*/

//Time Complexity: O(N), where N is the size of the given string
//Auxiliary Space: O(N), where N is the size of the given string

class ExtendedString {

    //Rotating the string using extended string
    static String leftrotate(String str1, int n) {

        //Creating extended string and index for new rotated string
        String temp = str1 + str1;
        int l1 = str1.length();

        String Lfirst = temp.substring(n, n + l1);

        //now returning string
        return Lfirst;
    }

    //Rotating the string using extended string
    static String rightrotate(String str1, int n) {
        return leftrotate(str1, str1.length() - n);
    }

    //Driver code
    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        System.out.println(leftrotate(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(leftrotate(str2, 2));
    }
}