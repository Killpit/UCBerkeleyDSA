package Strings.BasicOperations.ProgramToCheckIfTwoStringsAreSameOrNot;

//Time Complexity: O(1)
//Auxiliary Space: O(1)

public class BruteForce {
    public static void main(String[] args) {
        //first string
        String s1 = "GeeksforGeeks";
        //second string
        String s2 = "Geeks for geeks";
        //check condition
        if (s1.equals(s2)) {
            System.out.println("Strings Are Equal");
        } else {
            System.out.println("Strings Are Not Equal");
        }
    }
}
