package Strings.SubstringsandSubsequence.program_to_print_all_substrings_of_a_given_string;

//Time Complexity: O(N^3), where N is the length of the input string
//Auxiliary Space: O(1)

class UsingThreeNestedLoops {
    public static void printSubstrings(String str) {

        //finding the length of the string
        int n = str.length();

        //Outermost for loop, this is for the selection of starting point
        for (int i = 0; i < n; i++) {

            //2nd for loop is for selection of ending point
            for (int j = i; j < n; j++) {

                //3rd loop is for printing from starting point to ending point
                for (int k = i; k <= j; k++) {
                    System.out.print(str.charAt(k));
                }

                //Changing the line after printing from starting point to ending point
                System.out.println();
            }
        }
    }

    //Driver Code
    public static void main(String[] args) {
        String str = "abcd";

        //calling method for printing substring
        printSubstrings(str);
    }
}