package Strings.SubstringsandSubsequence.CountDistinctSubsequences;
import java.util.*;

//Time Complexity: O(n)
//Space Complexity: O(1)

class WithoutExtraSpace {

    //Returns count of distinct subsequences of str
    public static int countSub(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        //Iterate from 0 to s.length()
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), -1);
        }

        int allCount = 0;
        int levelCount;

        //Iterate from 0 to s.length()
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //Check if i equal to 0
            if (i == 0) {
                allCount = 1;
                map.put(c, 1);
                continue;
            }

            //Replace levelCount with allCount + 1
            levelCount = allCount + 1;

            //If map is less than 0
            if (map.get(c) < 0) {
                allCount = allCount + levelCount;
            }
            else {
                allCount = allCount + levelCount - map.get(c);
            }
            map.put(c, levelCount);
        }

        //Return answer
        return allCount;
    }

    //Driver code
    public static void main(String[] args) {
        List<String > list = Arrays.asList("abab", "gfg");

        for (String s : list) {
            int cnt = countSub(s);
            int withEmptyString = cnt + 1;
            System.out.println("With empty string count for " + s + " is " + withEmptyString);
            System.out.println("Without empty string count for " + s + " is " + cnt);
        }
    }
}