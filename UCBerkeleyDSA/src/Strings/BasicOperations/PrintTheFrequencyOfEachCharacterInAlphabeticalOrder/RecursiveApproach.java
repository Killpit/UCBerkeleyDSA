package Strings.BasicOperations.PrintTheFrequencyOfEachCharacterInAlphabeticalOrder;

/*Algorithm:
*
1-Take the string "s" as input and calculate size in n
2-Run a loop from 'a' to 'z' and call the "compressString" function for each time with count = 0 to store the
frequency of the letter
3-The "compressString" function check if counter i > size of the string then return the function else increment the
count if character equal to s[i] and call the "compressString" again with i+1
4-Now check if count is not equal to 0, then print the letter with count
*/

//Time Complexity: O(N)
//Auxiliary Space: O(1)

class RecursiveApproach {

    //Recursive function
    static void compressString(String s, int n, int i, char letter, int[] count) {
        //Base case: if i > size of string, then return
        if (i > n - 1) {
            return;
        }

        //If the letter is equal to s[i], then increment count by 1
        if (s.charAt(i) == letter) {
            count[0]++;
        }

        //Call the recursive function again with i+1
        compressString(s, n, i+1, letter, count);
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int n = s.length();

        for (char letter = 'a'; letter <= 'z'; letter++) {
            int[] count = {0};

            //Call the recursive function
            compressString(s, n, 0, letter, count);

            if (count[0] == 0) {
                continue;
            }
            System.out.print(letter + " " + count[0]);
        }
    }
}
