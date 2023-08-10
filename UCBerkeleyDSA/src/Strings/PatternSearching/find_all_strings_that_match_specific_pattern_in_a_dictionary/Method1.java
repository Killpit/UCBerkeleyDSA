package Strings.PatternSearching.find_all_strings_that_match_specific_pattern_in_a_dictionary;
import java.util.*;

/*Algorithm

-Encode the pattern according to the above approach and store the corresponding hash of the pattern in a string variable hash

Algorithm to encode -:

    -Initialize a counter i=0, which will map distinct character with distinct integers
    -Read the string and if the current character is not mapped to an integer, map it to the counter value and increment
    it
    -Concatenate the integer mapped to the current character to the hash string

-Now read each word and make a hash of it using the same algorithm
-If the hash of the current word is equal to the hash of the pattern, then that word is included in the final answer*/

/*Pseudo Code

int i=0
Declare map
for character in pattern:
   if(map[character]==map.end())
      map[character]=i++;

   hash_pattern+=to_string(mp[character])

for words in dictionary:
   i=0;
   Declare map
   if(words.length==pattern.length)
     for character in words:
         if(map[character]==map.end())
            map[character]=i++

          hash_word+=to_string(map[character)

      if(hash_word==hash_pattern)
      print words
*/

//Time Complexity: O(N*K), here, 'N' is the number of words and 'K' is its length. As we have to traverse each word
//separately to create its hash
//Auxiliary Space: O(N), The use of hash_map data structure for mapping characters takes this amount of space


class Method1 {

    //Function to encode given string
    static String encodeString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        int i = 0;

        //for each character in given string
        char ch;
        for (int j = 0; j < str.length(); j++) {
            ch = str.charAt(j);

            //If the character is occurring for the first time, assign next unique number to that char
            if (!map.containsKey(ch))
                map.put(ch, i++);

            //append the number associated with current character into the output string
            res.append(map.get(ch));
        }

        return res.toString();
    }

    //Function to print all the strings that match the given pattern where every character in the pattern is uniquely
    //mapped to a character in the dictionary
    static void findMatchedWords(String[] dict, String pattern) {
        //len is length of the pattern
        int len = pattern.length();

        //encode the string
        String hash = encodeString(pattern);

        //for each word in the dictionary array
        for (String word : dict) {
            //If the size of the pattern is the same as the size of current dictionary word and both pattern and the word
            //has the same hash, print the word
            if (word.length() == len && encodeString(word).equals(hash))
                System.out.print(word + " ");
        }
    }

    //Driver code
    public static void main(String[] args) {
        String[] dict = { "abb", "abc",
                "xyz", "xyy" };
        String pattern = "foo";

        findMatchedWords(dict, pattern);
    }
}