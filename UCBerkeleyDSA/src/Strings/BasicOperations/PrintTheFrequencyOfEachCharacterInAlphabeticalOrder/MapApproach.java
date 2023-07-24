package Strings.BasicOperations.PrintTheFrequencyOfEachCharacterInAlphabeticalOrder;

/*Approach:
*
1-Create a map to store the frequency of each of the characters of the given string
2-Iterate through the string and check if the character is present in this map
3-If the character is not present, insert it in the map with 1 as the initial value, else, increment its frequency by
1
4-Finally, print the frequency of each of the character in alphabetical order*/

//Time Complexity: O(n)
//Auxiliary Space: O(1)

class MapApproach {

    static int MAX = 26;

    //Function to print the frequency of each of the characters of s in alphabetical order
    static void compressString(String s, int n) {
        //To store the frequency of the characters
        int[] freq = new int[MAX];

        //Update the frequency array
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        //Print the frequency in alphabetical order
        for (int i = 0; i < MAX; i++) {

            //If the current alphabet doesn't appear in the string
            if (freq[i] == 0)
                continue;

            System.out.print((char) (i + 'a') + " " + freq[i]);
        }
    }

    //Driver code
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int n = s.length();

        compressString(s, n);
    }
}
