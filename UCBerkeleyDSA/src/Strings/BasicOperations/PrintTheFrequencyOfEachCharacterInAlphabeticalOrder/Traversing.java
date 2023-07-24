package Strings.BasicOperations.PrintTheFrequencyOfEachCharacterInAlphabeticalOrder;
import java.util.Map;
import java.util.TreeMap;

//Time Complexity: O(N), for traversing string
//Auxiliary Space: O(N), for map

public class Traversing {

    public static void main(String[] args) {
        //given string
        String s = "geeksforgeeks";
        //map char-int pair
        Map<Character, Integer> mp = new TreeMap<>();
        //map over string
        for (char c: s.toCharArray()) {
            if (mp.containsKey(c)) {
                mp.put(c, mp.get(c) + 1);
            } else {
                mp.put(c, 1);
            }
        }
        //printing the char with their frequency
        System.out.println("All character in string with their frequency :");
        for (Map.Entry<Character, Integer> entry: mp.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue());
        }
    }
}