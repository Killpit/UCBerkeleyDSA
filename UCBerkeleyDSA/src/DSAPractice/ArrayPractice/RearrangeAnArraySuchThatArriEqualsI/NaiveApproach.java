package DSAPractice.ArrayPractice.RearrangeAnArraySuchThatArriEqualsI;

/*Given an array of elements of length N, ranging from 0 to N-1. All elements may not be present in the array. If the
* element is not present, then there will be -1 present in the array. Rearrange the array such that A[i] = i and if i
* is not present, display -1 at that place*/

/*
* Naive Approach
*
* Navigate the numbers from 0 to n-1
* Now navigate through array
* If (i==a[j]), then replace the element at i position with a[j] position
* If there is any element in which -1 is used instead of the number, then it will be replaced automatically
* Now, iterate through the array and check if (a[i] != i), if it's true, then replace a[i] with -1*/

//Time Complexity: O(n^2)
//Auxiliary Space: O(1), since no extra space has been taken

public class NaiveApproach {

    //Function to transform the array
    public static void fixArray(int arr[], int n) {

        int i, j, temp;

        //Iterate over the array
        for (i = 0; i < n; i++) {

            for (j = 0; j < n; j++) {

                //Check is any arr[j] exists such that arr[j] is equal to i
                if (arr[j] == i) {
                    temp = arr[j];
                    arr[i] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
        }

        //Iterate over array
        for (i = 0; i < n; i++) {

            //If not present
            if (arr[i] != i) {
                arr[i] = -1;
            }
        }

        //Print the output
        System.out.println("Array after Rearranging");
        for (i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n, arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        n = arr.length;

        //Function Call
        fixArray(arr, n);
    }
}