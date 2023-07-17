package SortingAlgorithms;

/*Merge sort is defined as a sorting algorithm that works by dividing an array into smaller subarrays, sorting each
* subarray, and then merging the sorted subarrays back together to form the final sorted array*/

/*How does Merge Sort work?
*
* Merge sort is a recursive algorithm that continuously splits the array in half until it cannot be further divided,
* the array has only one element left (an array with one element is always sorted). Then the sorted subarrays are
* merged into one sorted array.*/

//Time Complexity: O(NlogN)
//Auxiliary Space: O(N)

class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] arr, int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}

/*Applications
*
* Sorting large datasets
* External sorting
* Custom sorting
* Inversion Count problem*/

/*Advantages
*
* Stability
* Guaranteed worst-case performance
* Parallelizable*/

/*Disadvantages
*
* Space complexity
* Not in-place
* Not always optimal with small datasets*/