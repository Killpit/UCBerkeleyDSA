package Strings.Palindrome.minimum_number_of_deletions_to_make_a_string_palindrome;

/*A simple solution is to remove all subsequences one by one and check if the remaining string is palindrome or not.
* The time complexity of this solution is exponential.

-Take two indexes first as 'i' and last as a 'j'
-Compare the character at the index 'i' and 'j'
-If characters are equal, then
    -Recursively call the function by incrementing 'i' by '1' and decrementing 'j' by '1'
-else
    -Recursively call the two functions, the first increment 'i' by '1' keeping 'j' constant, second decrement 'j' by
    '1' keeping 'i' constant
    -Take a minimum of both and return by adding '1'*/

/*Time Complexity: O(2^N), the time complexity of this solution is exponential as it requires a recursive approach to
* solve the problem. There are two recursive calls in each step and hence the time complexity is O(2^N)

* Auxiliary Space: O(N), the space complexity of this solution is linear as the recursive calls are stored in the
* stack frames and the maximum depth of the recursion tree can be n*/

class SimpleSolution {

    //Function to return minimum element between two values
    public static int min(int x, int y) {
        return Math.min(x, y);
    }

    //Utility function for calculating minimum element to delete
    public static int utility_fun_for_del(String str, int i, int j) {
        if (i >= j)
            return 0;

        //Condition to compare characters
        if (str.charAt(i) == str.charAt(j)) {

            //Recursive function call
            return utility_fun_for_del(str, i + 1, j - 1);
        }

        //Return value, incrementing by 1
        return 1 + Math.min(utility_fun_for_del(str, i + 1, j),
                utility_fun_for_del(str, i, j - 1));
    }

    //Function to calculate the minimum element required to delete for making string palindrome
    public static int min_ele_del(String str) {

        //Utility function call
        return utility_fun_for_del(str, 0, str.length() - 1);
    }

    //Driver code
    public static void main(String[] args) {
        String str = "abefbac";

        System.out.println("Minimum element of deletions = " + min_ele_del(str));
    }
}