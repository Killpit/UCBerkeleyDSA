package DSAPractice.ArrayPractice.FindSubarrayWithGivenSum;

/*The idea is to consider all subarrays one by one and check the sum of every subarray. Following program implements
* the given idea.
*
* Run two loops: the outer loop picks a starting point i and the inner loop tries all subarrays starting from i*/

/*Steps:
* Traverse the array from start to end
* From every index, start another loop from i to the end of the array to get all subarrays starting from i, and keep
* a variable currentSum to calculate the sum of every subarray
* For every index in inner loop update currentSum = currentSum + arr[j]
* If the currentSum is equal to the given sum, then print the subarray*/

//Time Complexity: O(n^2), trying all subarrays from every index, used nested loop for the same
//Auxiliary Space: O(1)

public class NestedLoop {
    /*Returns true if there is a subarray of arr[] with a sum equal to 'sum', otherwise it returns false. Also,
    * prints the result*/
    void subArraySum(int arr[], int n, int sum) {
        //Pick a starting point
        for (int i = 0; i < n; i++) {
            int currentSum = arr[i];

            if (currentSum == sum) {
                System.out.println("Sum found at indexes " + i);
                return;
            } else {
                //Try all subarrays starting with 'i'
                for (int j = i + 1; j < n; j++) {
                    currentSum += arr[j];

                    if (currentSum == sum) {
                        System.out.println("Sum found between indexes " + i + " and " + j);
                        return;
                    }
                }
            }
        }
        System.out.println("No subarray found");
        return;
    }
    public static <subArraySum> void main(String[] args) {
        NestedLoop arraysum = new NestedLoop();
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        arraysum.subArraySum(arr, n, sum);
    }
}