package DSAPractice.ArrayPractice.FindSubarrayWithGivenSum;
import java.util.*;

/*
* Steps:
*
* Initialize a variable 'sum' to 0, and create an empty unordered set 's'.
* Traverse through the array and add each element to 'sum'
* If the current element equals the given sum, then the subarray starts from the beginning of the array and ends at the
* current index.Return the subarray
* If 'sum' exceeds the given sum, check whether 'sum' minus the given sum is present in the set or not. If it is present
* , then the subarray starts after the index where the element that makes 'sum' minus the given sum was found in the set
* , and ends at the current index. Return the subarray.
* If 'sum' does not exceed the given sum, insert 'sum' into the set.
* If no subarray is found, return an empty array.*/

//Time Complexity, Auxiliary Space: O(N)

public class HashSet {

    //Find subarray with the given sum targetSum
    static List<Integer> subarrayWithGivenSum(List<Integer> arr, int targetSum) {
        int sum = 0;
        Set<Integer> s = new java.util.HashSet<>();
                for (int i = 0; i < arr.size(); i++) {

                    //Find the sum
                    sum += arr.get(i);
                    if (sum == targetSum) {
                        return arr.subList(0, i + 1);
                    }
                    if (s.contains(sum - targetSum)) {
                        int start = arr.indexOf(sum - targetSum) + 1;
                        return arr.subList(start, i + 1);
                    }
                    s.add(sum);
                }
                return new ArrayList<>();
    }

    //Driver code
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(15, 2, 4, 8, 9, 5, 10, 23);
        List<Integer> subarray = subarrayWithGivenSum(arr, 23);
        if (subarray.isEmpty()) {
            System.out.println("No subarray with given sum found");
        }
        else {
            System.out.println("Subarray: [ ");
            for (int i: subarray) {
                System.out.print( i + " ");
            }
            System.out.println("]");
        }
    }
}