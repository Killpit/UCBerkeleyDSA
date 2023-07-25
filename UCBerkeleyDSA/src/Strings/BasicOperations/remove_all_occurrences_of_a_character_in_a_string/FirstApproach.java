package Strings.BasicOperations.remove_all_occurrences_of_a_character_in_a_string;

//Time Complexity: O(N), where N is length of input storing
//Auxiliary Space: O(1)

class FirstApproach {
    static void removeChar(String s, char c) {
        int j, count = 0, n = s.length();
        char[] t = s.toCharArray();
        for (int i = j = 0; i < n; i++) {
            if (t[i] != c)
                t[j++] = t[i];
            else
                count++;
        }

        while (count > 0) {
            t[j++] = '\0';
            count--;
        }

        System.out.println(t);
    }

    //Driver Code
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        removeChar(s, 'g');
    }
}