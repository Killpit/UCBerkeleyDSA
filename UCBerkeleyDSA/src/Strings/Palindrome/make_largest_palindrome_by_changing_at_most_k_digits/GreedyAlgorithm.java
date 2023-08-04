package Strings.Palindrome.make_largest_palindrome_by_changing_at_most_k_digits;

/*
* The time complexity of the first approach is O(N^2), where N is the length of the string,
* because we are using two nested loops to compare every pair of characters in the string.

The space complexity is O(N), because we are creating a new string of length N to store the modified palindrome.*/

public class GreedyAlgorithm {
    public static String makePalindrome(String s, int k) {
        int n = s.length();
        int replacements = 0;
        char[] arr = s.toCharArray();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                if (arr[i] > arr[j]) {
                    arr[j] = arr[i];
                } else {
                    arr[i] = arr[j];
                }
                replacements++;
                if (replacements > k) {
                    return "-1";
                }
            }
        }
        for (int i = 0, j = n - 1; i <= j; i++, j--) {
            if (i == j && replacements < k) {
                arr[i] = '9';
            }
            if (arr[i] != '9') {
                if (replacements < k && (i == 0 || i == j)) {
                    arr[i] = arr[j] = '9';
                    replacements++;
                } else if (replacements <= k - 2) {
                    arr[i] = arr[j] = '9';
                    replacements += 2;
                }
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "43435";
        int k=3;

        System.out.println(makePalindrome(s, k));
    }
}
