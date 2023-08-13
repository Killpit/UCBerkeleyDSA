package Strings.SubstringsandSubsequence.CountDistinctSubsequences;
import java.util.*;

/*

Approach: Generate all the possible subsequences of a given string. The subsequences of a string can be generated in the
following manner:

1- Include a particular element (say ith) in the output array and recursively call the function for the rest of the input
string. This results in the subsequences of a string having ith character

2- Exclude a particular element (say ith) and recursively call the function for the rest of the input string. This contains
all the subsequences which don't have the ith character. Once we have generated a subsequence, in the base case of the
function, we insert that generated subsequence in an ordered set. An unordered set is a data structure, that stores
distinct elements in an unordered manner. This way, we insert all the generated subsequences in the set and print the size
of the set as our answer because at last, the set will contain only distinct subsequences*/

//Time Complexity: O(2^n)
//Auxiliary Space: O(2^n), where n is the length of the string

class NaiveApproachWithoutDynamicProgramming {
    //Function for generating the subsequences
    public static void subsequences(Set<String> sn, char[] s, char[] op, int i, int j, int n) {
        //Base Case
        if (i == n) {
            op[j] = '\0';

            //Insert each generated subsequence into the set
            sn.add(String.valueOf(op));
        }

        //Recursive case
        else {
            //When a particular character is taken
            op[j] = s[i];
            subsequences(sn, s, op, i + 1, j + 1, n);

            //When a particular character isn't taken
            subsequences(sn, s, op, i + 1, j, n);
        }
    }

    public static void main(String[] args) {
        char[] str = {'g', 'g', 'g'};
        int m = str.length;

        //Create an empty set to store the subsequences
        Set<String> sn = new HashSet<>();

        //Output array for storing the generating subsequences in each call
        char[] op = new char[m + 1]; //extra one for having \0 at the end

        //Function call
        subsequences(sn, str, op, 0, 0, m);

        //Output will be the number of elements in the set
        System.out.println(sn.size());
        sn.clear();
    }
}