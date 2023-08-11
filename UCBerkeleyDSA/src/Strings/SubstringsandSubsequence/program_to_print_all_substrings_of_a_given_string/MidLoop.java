package Strings.SubstringsandSubsequence.program_to_print_all_substrings_of_a_given_string;

//Time Complexity: O(n^3)
//Auxiliary Space: O(1)

class MidLoop {

    //Function to print all substrings
    static void subString(char[] str, int n) {
        //Pick starting point
        for (int len = 1; len <= n; len++) {
            //pick ending point
            for (int i = 0; i <= n - len; i++) {
                //Print characters from current starting point to current ending point
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    System.out.print(str[k]);
                }

                System.out.println();
            }
        }
    }

    //Driver program to test above function
    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c'};
        subString(str, str.length);
    }
}