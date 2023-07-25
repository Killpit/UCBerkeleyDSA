package Strings.BasicOperations.ProgramToCheckIfTwoStringsAreSameOrNot;

import java.util.*;

//Time Complexity: O(min(a,b)) //a is the length of the first string and b is the length of the second string
//Auxiliary Space: O(100)

class FirstApproach {

    //Driver code
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Get the strings which is to be checked
        String string1 = in.nextLine();
        System.out.println("Enter the first string: " + string1);

        String string2 = in.nextLine();
        System.out.println("Enter the second string :" + string2);

        //Check if both strings are equal
        System.out.println("\nAre both strings same: ");

        if (string1.equals(string2)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}