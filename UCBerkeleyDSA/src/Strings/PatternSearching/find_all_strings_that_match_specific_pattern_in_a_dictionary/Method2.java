package Strings.PatternSearching.find_all_strings_that_match_specific_pattern_in_a_dictionary;
import java.util.*;

/*Algorithm

1-Create a character array in which we can map the characters of patterns with a corresponding character of a word
2-Firstly, check whether the length of word and pattern is equal or not, if no, then check the next word
3-If the length is equal, traverse the pattern and if the current character of the pattern has not been mapped yet, map it
to the corresponding character of the word
4-If the current character is mapped, then check whether the character with which it has been mapped is equal to the
current character of the word
5-If no, then the word does not follow the given path
6-If the word follows the pattern until the last character, then print the void.
*/

/*Pseudo Code

for words in dictionary:
   char arr_map[128]=0
   char map_word[128]=0
   if(words.length==pattern.length)
     for 0 to length of pattern:
         if(arr_map[character in pattern]==0 && map_word[character in word]==0)
            arr_map[character in pattern]=word[character in word]
            map_word[character in word]=pattern[character in pattern]

          else if(arr_map[character]!=word[character] ||map_word[character]!=pattern[character] )
          break the loop

If above loop runs successfully
Print(words)
*/

//Time Complexity: O(N*K), where 'N' is the number of words and 'K' is its length. To traverse each word, this will be the
//time requirement
//Auxiliary Space: O(N), the use of hash_map data structure for mapping characters consumes N space

class Method2 {
    static boolean check(String pattern, String word) {

        if (pattern.length() != word.length())
            return false;

        int[] ch = new int[128];
        int Len = word.length();

        for (int i = 0; i < Len; i++) {
            if (ch[pattern.charAt(i)] == 0) {
                ch[pattern.charAt(i)] = word.charAt(i);
            } else if (ch[pattern.charAt(i)] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /*Function to print all the strings that match the given pattern where every character in the pattern is uniquely
    * mapped to a character in the dictionary*/
    static void findMatchedWords(HashSet<String> dict, String pattern) {

        //For each word in the dictionary
        StringBuilder result = new StringBuilder(" ");
        for (String word : dict) {
            if (check(pattern, word)) {
                result.insert(0, word + " ");
            }
        }
        System.out.print(result);
    }

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("abb");
        dict.add("abc");
        dict.add("xyz");
        dict.add("xyy");

        String pattern = "foo";

        findMatchedWords(dict, pattern);
    }
}