package Strings.SubstringsandSubsequence.program_to_print_all_substrings_of_a_given_string;

//Time Complexity: O(n^2)
//Auxiliary Space: O(n)

class GenerateSubstringUsingThePreviousSubstring {

    //Function to print all (n*(n+1)) / 2 substrings of a given String s of length n
    public static void printAllSubstrings(String s, int n) {

        //Fix start index in outer loop
        //Reveal new character in the inner loop till the end of the string
        //Print till-now-formed String
        for (int i = 0; i < n; i++) {
            char[] temp = new char[n - i + 1];
            int tempindex = 0;

            for (int j = i; j < n; j++) {
                temp[tempindex++] = s.charAt(j);
                temp[tempindex] = '\0';
                System.out.println(temp);
            }
        }
    }

    //Driver code
    public static void main(String[] args) {
        String s = "Geeky";
        printAllSubstrings(s, s.length());
    }
}