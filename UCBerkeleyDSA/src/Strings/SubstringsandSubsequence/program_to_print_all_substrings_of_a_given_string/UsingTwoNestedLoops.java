package Strings.SubstringsandSubsequence.program_to_print_all_substrings_of_a_given_string;

//Time Complexity: O(N^2), where N is the length of the input string
//Auxiliary Space: O(N), where N is the length of the input string

class UsingTwoNestedLoops {

    static void printSubstrings(String str) {

        //First loop for starting index
        for (int i = 0; i < str.length(); i++) {
            StringBuilder subStr = new StringBuilder();

            //Second loop is generating subString
            for (int j = i; j < str.length(); j++) {
                subStr.append(str.charAt(j));
                System.out.print(subStr + "\n");
            }
        }
    }

    //Driver code
    public static void main(String[] args) {
        String str = "abcd";
        printSubstrings(str);
    }
}