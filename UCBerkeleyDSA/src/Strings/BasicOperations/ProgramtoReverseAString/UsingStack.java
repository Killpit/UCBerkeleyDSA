package Strings.BasicOperations.ProgramtoReverseAString;
import java.util.Stack;

//Time Complexity: O(N)
//Auxiliary Space: O(N)

class UsingStack {
    public static String recursiveReverse(char[] str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length; i++)
            st.push(str[i]);

        for (int i = 0; i < str.length; i++) {
            str[i] = st.peek();
            st.pop();
        }
        return String.valueOf(str);
    }

    //Driver program
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        str = recursiveReverse(str.toCharArray());
        System.out.println(str);
    }
}
