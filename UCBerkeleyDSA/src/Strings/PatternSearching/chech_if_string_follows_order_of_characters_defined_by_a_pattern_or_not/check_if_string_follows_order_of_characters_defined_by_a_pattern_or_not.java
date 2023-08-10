package Strings.PatternSearching.chech_if_string_follows_order_of_characters_defined_by_a_pattern_or_not;

//Time complexity of this program is O(N) with constant extra space (the array label is of constant size, 256)
//Auxiliary space: O(256)

import java.util.Arrays;

class check_if_string_follows_order_of_characters_defined_by_a_pattern_or_not {
    static int CHAR_SIZE = 256;

    //Returns true if character of str follow order defined by a given ptr
    static boolean checkPattern(String str, String pat) {
        int[] label = new int[CHAR_SIZE];

        //Initialize all orders as -1
        Arrays.fill(label, -1);

        //Assign an order to pattern characters according to their appearance in pattern
        int order = 1;
        for (int i = 0; i < pat.length(); i++) {

            //give the pattern characters order
            label[pat.charAt(i)] = order;

            //increment the order
            order++;
        }

        //Now one by one check if string characters follow above order
        int last_order = -1;
        for (int i = 0; i < str.length(); i++) {
            if (label[str.charAt(i)] != -1) {

                //If the order of this character is less than the order of previous character, return false
                if (label[str.charAt(i)] < last_order)
                    return false;

                //Update last_order for next iteration
                last_order = label[str.charAt(i)];
            }
        }

        //Return that str followed pat
        return true;
    }

    //Driver code
    public static void main(String[] args) {
        String str = "engineers rock";
        String pattern = "gsr";
        System.out.println(checkPattern(str, pattern));
    }
}