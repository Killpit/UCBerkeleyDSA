package Strings.BinaryString.MinFlipsofContinuousCharactersToMakeAllCharactersSameInAString;

//Time Complexity: O(N)
//Auxiliary Space: O(1)

public class MinFlipsofContinuousCharactersToMakeAllCharactersSameInAString {

    static int findFlips(String str, int n) {
        char last = ' '; int res = 0;

        for (int i = 0; i < n; i++) {

            //If last character is not equal to str[i] increase res
            if (last != str.charAt(i))
                res++;
            last = str.charAt(i);
        }

        //To return min flips
        return res / 2;
    }

    //Driver program to check findFlips()
    public static void main(String[] args) {
        String str = "00011110001110";
        int n = str.length();

        System.out.println(findFlips(str, n));
    }
}
