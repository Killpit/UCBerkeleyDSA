package SortingAlgorithms;

/*Quicksort is a sorting algorithm based on the Divide and Conquer algorith that picks up an element as a pivot and
* partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array*/

/*How does Quicksort work
*
* The key process in quickSort is a partition(). The target of partitions is to place the pivot at its correct position
* in the sorted array and put all smaller elements to the left of the pivot, and all greater elements to the right of
* the pivot.
*
* Partition is done recursively on each side of the pivot after the pivot is placed in its correct position and this
* finally sorts the array*/

/*Partition Algorithm
*
* The logic is simple, we start from the leftmost element and keep track of the index of smaller elements as i. While
* traversing, if we find a smaller element, we swap the current element with arr[i]. Otherwise, we ignore the current
* element*/

/*Illustration
*
* As the partition process is done recursively, it keeps on putting the pivot in its actual position in the sorted
* array. Repeatedly putting pivots in their actual position makes the array sorted.
*/

/*Advantages of Quick Sort:

It is a divide-and-conquer algorithm that makes it easier to solve problems.
It is efficient on large data sets.
It has a low overhead, as it only requires a small amount of memory to function.

Disadvantages of Quick Sort:

It has a worst-case time complexity of O(N2), which occurs when the pivot is chosen poorly.
It is not a good choice for small data sets.
It is not a stable sort, meaning that if two elements have the same key, their relative order will not be preserved
in the sorted output in case of quick sort, because here we are swapping elements according to the pivot’s
position (without considering their original positions).*/

class QuickSort {

    //A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //This function takes last element as pivot, places the pivot element at its correct position in sorted array,
    //and places all smaller to left of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high) {

        //Choosing the pivot
        int pivot = arr[high];

        //Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            //If current element is smaller than the pivot
            if (arr[j] < pivot) {

                //Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*The main function that implements Quicksort
    * arr[] --> Array to be sorted,
    * low --> Starting index,
    * high --> Ending index */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            //pi is partitioning index, arr[p] is now at the right place
            int pi = partition(arr, low, high);

            //Separately sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    //To print sorted array
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //Driver code
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int N = arr.length;

        //Function call
        quickSort(arr, 0, N - 1);
        System.out.println("Sorted array:");
        printArr(arr);
    }
}
