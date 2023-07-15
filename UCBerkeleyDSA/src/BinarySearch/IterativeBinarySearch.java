package BinarySearch;

/*Binary Search is defined as a searching algorithm used in a sorted array by repeatedly dividing the search interval in
* half. The idea of binary search is to use the information that the array is sorted and reduce the time complexity to
* O(logN)*/

/*Conditions for when to apply Binary Search in a Data Structure:
*
* To apply Binary Search algorithm:
*
* The data structure must be sorted.
* Access to any element of the data structure takes constant time.
*
* Binary Search Algorithm:
*
* Divide the search space into two halves by finding the middle index "mid".
* Compare the middle element of the search space with the key.
* If the key is found at middle element, the process is terminated
* If the key is not found at middle element, choose which half will be used as the next search space.
*   If the key is smaller than the middle element, then the left side is used for next search.
*   If the key is larger than the middle element, then the right side is used for next search.
* This process is continued until the key is found or the total search space is exhausted.
*/

/*How does Binary Search work?
*
* First step: Calculate the mid and compare the mid element with the key. If the key is less than mid element, move to
* left and it it is greater than the mid, then move search space to the right.
*
* Second step: If the key matches the value of the mid element, the element is found and stop search.
*/

//Time Complexity: O(logN)
//Auxiliary Space: O(1)

class IterativeBinarySearch {

    //Returns index of x if it is present in arr[]
    int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (1 <= r) {
            int m = 1 + (r - 1) / 2;

            //Check if x is present at mid
            if (arr[m] == x)
                return m;

            //If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

            //If x is smaller, ignore right half
            else
                r = m - 1;
        }

        //If we reach here, then element was not present
        return -1;
    }

    //Driver code
    public static void main(String[] args) {
        IterativeBinarySearch ob = new IterativeBinarySearch();
        int[] arr = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at " + "index " + result);
    }
}
