package DSAPractice.ArrayPractice.FindTheLargestThreeDistinctElementsInAnArray;

/*
* Algorithm:

1) Initialize the largest three elements as minus infinite.
    first = second = third = -∞

2) Iterate through all elements of array.
   a) Let current array element be x.
   b) If (x > first)
      {
          // This order of assignment is important
          third = second
          second = first
          first = x
       }
   c)  Else if (x > second and x != first)
      {
          third = second
          second = x
      }
   d)  Else if (x > third and x != second)
      {
          third = x
      }

3) Print first, second and third.*/

using system

class MethodOne {

    //Function to print three largest elements
    static void print3largest(int[] arr, int arr_size) {
        int i, first, second, third;

        //There should be at least three elements
        
    }
}