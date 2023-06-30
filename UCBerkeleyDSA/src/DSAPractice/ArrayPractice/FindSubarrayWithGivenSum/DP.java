package DSAPractice.ArrayPractice.FindSubarrayWithGivenSum;
import java.util.*;

/*
We can use dynamic programming to find the subarray with the given sum. The basic idea is to iterate through the
* array, keeping track of the current sum and storing the difference between the current sum and the given sum in a
* hash table. If difference is seen again later in the array, then we know that the subarray with the given sum
* exists and we can return it. This approach is efficient in terms of time and space, but it may not be suitable if
* the array is very large and the hash table becomes too large to fit in memory.
*/

/*
* Algorithm:
* Initialize an empty hash table and a variable curr_sum to 0.
* Iterate through the array, keeping track of the current element in a variable i.
* Add i to curr_sum and check if curr_sum - sum is in the hash table. If it is, then return the subarray from the
* index stored in the hash table to i.
* If curr_sum - sum is not in the hash table, add an entry to the hash table with the key curr_sum and the value i.
* If you reach the end of the array and no subarray with the given sum is found, return an empty array.
*/

//Time Complexity, Auxiliary Space: O(N)

public class DP {
    public static List<Integer> findSubarrayWithGivenSum(List<Integer> arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> subarray = new ArrayList<>();
        int currSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            currSum += arr.get(i);
            if (map.containsKey(currSum - sum)) {
                subarray = arr.subList(
                        map.get(currSum - sum) + 1, i + 1);
                break;
            }
            map.put(currSum, i);
        }
        return subarray;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(15, 2, 4, 8, 9, 5, 10, 23);
        List<Integer> subarray = findSubarrayWithGivenSum(arr, 23);
        if (subarray.isEmpty()) {
            System.out.println("No subarray with given sum found");
        }
        else {
            System.out.println("Subarray: [ ");
            for (int i : subarray) {
                System.out.println(i + " ");
            }
            System.out.println(" ] ");
        }
    }
}