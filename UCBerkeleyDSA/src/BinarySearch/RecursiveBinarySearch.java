package BinarySearch;

/*Complexity Analysis
*
* Time Complexity:
* Best Case: O(1)
* Average/Worst Case: O(logN)
* Auxiliary Space: O(1), if the recursive call stack is considered, then the auxiliary space will be O(logN)*/

/*Advantages
*
* Binary search is faster than linear search, especially for large arrays.
* More efficient than other searching algorithms with a similar time complexity, such as interpolation search or
* exponential search
* Binary search is well-suited for searching large datasets that are stored in external memory, such as on a hard drive
* or in the cloud*/

/*Drawbacks
*
* The array should be sorted
* Binary search requires that the data structure being searched be stored in contiguous memory locations
* Binary search requires that the elements of the array be comparable, meaning that they must be able to be ordered*/

/*Applications
*
* Binary search can be used as a building block for more complex algorithms used in machine learning, such as
* algorithms for training neural networks or finding optimal hyperparameters for a model.
* It can be used for searching in computer graphicss such as algorithms for ray tracing or texture mapping.
* It can be used for searching a database*/

class RecursiveBinarySearch {
    //Returns index of x if it is present in arr[l..r], else return -1
    int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= 1) {
            int mid = l + (r - 1) / 2;

            //If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            //If the element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            //Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        //We reach here when element is not present in array
        return -1;
    }

    //Driver code
    public static void main(String[] args) {
        RecursiveBinarySearch ob = new RecursiveBinarySearch();
        int[] arr = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}