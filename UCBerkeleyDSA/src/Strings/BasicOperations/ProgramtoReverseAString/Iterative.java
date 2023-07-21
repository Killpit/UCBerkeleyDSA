package Strings.BasicOperations.ProgramtoReverseAString;

//Time Complexity: O(N)
//Auxiliary Space: O(1)

public class Iterative {
    //Function to reverse a string
    void stringReverse() {
        String str = "geeksforgeeks";
        int length = str.length();
        StringBuffer revString = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            revString.append(str.charAt(i));
        }
        System.out.println(revString);
    }

    //Driver code
    public static void main(String[] args) {
        Iterative s = new Iterative();
        s.stringReverse();
    }
}
