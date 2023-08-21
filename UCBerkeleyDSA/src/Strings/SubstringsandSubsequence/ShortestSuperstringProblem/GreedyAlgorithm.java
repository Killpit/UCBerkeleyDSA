package Strings.SubstringsandSubsequence.ShortestSuperstringProblem;

/*
Approximate Greedy Algorithm

Let arr[] be given set of strings.

1) Create an auxiliary array of strings, temp[].  Copy contents
   of arr[] to temp[]

2) While temp[] contains more than one strings
     a) Find the most overlapping string pair in temp[]. Let this
        pair be 'a' and 'b'.
     b) Replace 'a' and 'b' with the string obtained after combining
        them.

3) The only string left in temp[] is the result, return it.
*/

/*

Algorithm

arr[] = {"catgc", "ctaagt", "gcta", "ttca", "atgcatc"}
Initialize:
temp[] = {"catgc", "ctaagt", "gcta", "ttca", "atgcatc"}

The most overlapping strings are "catgc" and "atgcatc"
(Suffix of length 4 of "catgc" is same as prefix of "atgcatc")
Replace two strings with "catgcatc", we get
temp[] = {"catgcatc", "ctaagt", "gcta", "ttca"}

The most overlapping strings are "ctaagt" and "gcta"
(Prefix of length 3 of "ctaagt" is same as suffix of "gcta")
Replace two strings with "gctaagt", we get
temp[] = {"catgcatc", "gctaagt", "ttca"}

The most overlapping strings are "catgcatc" and "ttca"
(Prefix of length 2 of "catgcatc" as suffix of "ttca")
Replace two strings with "ttcatgcatc", we get
temp[] = {"ttcatgcatc", "gctaagt"}

Now there are only two strings in temp[], after combing
the two in optimal way, we get tem[] = {"gctaagttcatgcatc"}

Since temp[] has only one string now, return it.

*/

/*The time complexity of this algorithm is O(n^3 * m), where n is the number of strings in the input array and m is the
* maximum length of any string in the array. This is because the main loop runs n - 1 times and the findOverlappingPair
* function takes O(m) time, and it is called n^2 times.*/

/*The space complexity is O(n*m), which is the space required to store the input array and the result string.*/

class GreedyAlgorithm {

    static String str;

    //Utility function to calculate minimum of two numbers
    static int min(int a, int b) {
        return Math.min(a, b);
    }

    //Function to calculate maximum overlap in two given strings
    static int findOverlappingPaid(String str1, String str2) {

        //Max will store maximum overlap i.e maximum length of the matching prefix and suffix
        int max = Integer.MIN_VALUE;
        int len1 = str1.length();
        int len2 = str2.length();

        //Check suffix of str1 matches with prefix of str2
        for (int i = 1; i <= min(len1, len2); i++) {

            //Compare last i characters in str1 with first i characters in str2
            if (str1.substring(len1 - i).compareTo(str2.substring(0, i)) == 0) {
                if (max < i) {

                    //Update max and str
                    max = i;
                    str = str1 + str2.substring(i);
                }
            }
        }

        //check prefix of str1 matches with suffix of str2
        for (int i = 1; i <= min(len1, len2); i++) {

            //compare first i characters in str1 with last i characters in str2
            if (str1.substring(0, i).compareTo(str2.substring(len2 - i)) == 0) {
                if (max < i) {

                    //update max and str
                    max = i;
                    str = str2 + str1.substring(i);
                }
            }
        }

        return max;
    }

    //Function to calculate smallest string that contains each string in the given set as substring
    static String findShortestSuperstring(String[] arr, int len) {

        //run len-1 times to consider every pair
        while (len != 1) {

            //To store maximum overlap
            int max = Integer.MIN_VALUE;

            //To store array index of strings involved in maximum overlap
            int r = 0;

            //to store resultant string after maximum overlap
            String resStr = "";

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {

                    //Res will store maximum length of the matching prefix and suffix str is passed by reference and will
                    //store the resultant string after maximum overlap of arr[i] arr[j], if any
                    int res = findOverlappingPaid(arr[i], arr[j]);

                    //Check for maximum overlap
                    if (max < res) {
                        max = res;
                        resStr = str;
                        r = j;
                    }
                }
            }

            //Ignore last element in next cycle
            len--;

            //If no overlap, append arr[len] to arr[0]
            if (max == Integer.MIN_VALUE)
                arr[0] += arr[len];
            else {

                //Copy resultant string to index 1
                arr[1] = resStr;

                //Copy starting at last index to index r
                arr[r] = arr[len];
            }
        }
        return arr[0];
    }

    //Driver code
    public static void main(String[] args) {
        String[] arr = { "catgc", "ctaagt",
                "gcta", "ttca", "atgcatc" };
        int len = arr.length;

        System.out.println("The Shortest Superstring is " + findShortestSuperstring(arr, len));
    }
}