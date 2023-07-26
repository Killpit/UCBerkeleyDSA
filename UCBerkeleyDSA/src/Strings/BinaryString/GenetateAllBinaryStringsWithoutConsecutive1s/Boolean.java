package Strings.BinaryString.GenetateAllBinaryStringsWithoutConsecutive1s;

/*Time Complexity: O(2^N), as we can see that we are calling the recursive function two times for every recursion
* level. Hence, the time complexity is 2^N.*/

//Space Complexity: O(N), since we are using a boolean array of size N.

class Boolean {
    static void All_Binary_Strings(int[] arr, int num, int r) {
        if (r == num) {
            for (int i = 0; i < num; i++)
                System.out.print(arr[i]);
                System.out.print(" ");

        } else if (arr[r - 1] == 1) {
            arr[r] = 0;
            All_Binary_Strings(arr, num, r+1);
        }
        else {
            arr[r] = 0;
            All_Binary_Strings(arr, num, r+1);
            arr[r] = 1;
            All_Binary_Strings(arr, num, r+1);
        }
    }

    static void print(int[] a, int num) {
        a[0] = 0;
        All_Binary_Strings(a, num, 1);
        a[0] = 1;
        All_Binary_Strings(a, num, 1);
    }

    //Driver Code
    public static void main(String[] args) {
        int n = 2;
        int[] a = new int[n];
        print(a, n);
    }
}