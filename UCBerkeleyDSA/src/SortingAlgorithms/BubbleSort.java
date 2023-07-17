package SortingAlgorithms;

/*Bubble sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are
* in the wrong order. This algorithm is not suitable for large data sets as its average and worst-case time complexity
* is quite high.
*/

/*In this algorithm,
*
* Traverse from left and compare adjacent elements and the higher one is placed at the right side
* In this way, the largest element is moved to the rightmost end at first
* This process is then continued to find the second largest and place it and so on until the data is sorted
*/

/*
*
* Time Complexity: O(N2)
* Auxiliary Space: O(1)

Advantages of Bubble Sort:
*
Bubble sort is easy to understand and implement.
*
It does not require any additional memory space.
*
It is a stable sorting algorithm, meaning that elements with the same key value maintain their relative order in the
* sorted output.
*
Disadvantages of Bubble Sort:
*
Bubble sort has a time complexity of O(N2) which makes it very slow for large data sets.
*
Bubble sort is a comparison-based sorting algorithm, which means that it requires a comparison operator to determine
* the relative order of elements in the input data set. It can limit the efficiency of the algorithm in certain
* cases.
*/

class BubbleSort {

    //An optimized version of Bubble Sort
    static void bubbleSort(int[] arr, int n) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    //Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            //If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    //Function to print an array
    static void printArray(int[] arr, int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //Driver program
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
