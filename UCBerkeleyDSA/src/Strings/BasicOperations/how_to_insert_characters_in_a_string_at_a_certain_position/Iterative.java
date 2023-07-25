package Strings.BasicOperations.how_to_insert_characters_in_a_string_at_a_certain_position;

/*Steps

* Create a string ans for storing your resultant string
* Take one pointer j initially as 0
* Iterate over the string and whenever your index that represents the count of characters becomes equal to the
element in stars[j], append the star in your ans string and move the j pointer ahead.
* Also, at each move, append the current character in your string ans
*/

//Time Complexity: O(N)
//Auxiliary Space: O(N)

class Iterative {

    //Function to add stars
    public static String addStars(String s, int[] stars) {

        //Create a string ans for storing resultant string
        String ans = "";

        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            //If the count of characters become equal to the stars[j], append star
            if (j < stars.length && i == stars[j]) {
                ans += '*';
                j++;
            }
            ans += s.charAt(i);
        }
        return ans;
    }

    //Driver Code
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int[] chars = {1, 5, 7, 9};
        String ans = addStars(str, chars);

        //Printing the resultant string
        System.out.println(ans);
    }
}