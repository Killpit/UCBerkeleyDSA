package DSAPractice.ArrayPractice.FindSubarrayWithGivenSum;

/*The idea is simple as we know that all the elements in subarray are positive, so, if a subarray has sum
* greater than the given sum, then there is no possibility that adding elements to the current subarray will be
* equal to the given sum. So the idea is to use a similar approach to a sliding window.
*
* Steps:
* Start with an empty subarray
* add elements to the subarray until the sum is less than x (given sum)
* If the sum is greater than x, remove elements from the start of the current subarray*/

/*Steps:
* Create two variables, start=0, currentSum = arr[0]
* Traverse the array from index 1 to end
* Update the variable currentSum by adding current element, currentSum = currentSum + arr[i]
* If the currentSum is greater than the given sum, update the variable currentSum as
* currentSum = currentSum * arr[start] and update start as, start++
* If the currentSum is equal to given sum, print the subarray and break the loop*/

//Time Complexity: O(N)
//Auxiliary Space: O(1). Since no extra space has been taken

public class SlidingWindow {
    /* Returns true if the there is
a subarray of arr[] with sum equal to
       'sum' otherwise returns false.
Also, prints the result */
    int subArraySum(int arr[], int n, int sum)
    {
        int currentSum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum,
            // then remove the starting elements
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " + start
                                + " and " + p);
                return 1;
            }

            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }

    public static void main(String[] args)
    {
        SlidingWindow arraysum = new SlidingWindow();
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 23;
        arraysum.subArraySum(arr, n, sum);
    }
}