"""
Algorithm:

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

3) Print first, second and third.
"""

#Time Complexity: O(n)
#Auxiliary Space: O(1)

import sys

# Function to print three largest
# elements
def print3largest(arr, arr_size):
    # There should be atleast three
    # elements
    if (arr_size < 3):
        print(" Invalid Input ")
        return

    third = first = second = -sys.maxsize

    for i in range(0, arr_size):

        # If current element is greater
        # than first
        if (arr[i] > first):

            third = second
            second = first
            first = arr[i]


        # If arr[i] is in between first
        # and second then update second
        elif (arr[i] > second):

            third = second
            second = arr[i]

        elif (arr[i] > third):
            third = arr[i]

    print("Three largest elements are",
          first, second, third)


# Driver program to test above function
arr = [12, 13, 1, 10, 34, 1]
n = len(arr)
print3largest(arr, n)