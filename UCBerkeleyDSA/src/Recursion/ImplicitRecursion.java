package Recursion;
import java.util.*;
import java.util.stream.Collectors;

/*Implicit Recursion
*
* A specific sort of recursion called implicit recursion occurs when a function calls itself without making an explicit
* recursive call. This call can occur when a function calls another function, which then calls the original code once
* again and starts a recursive execution of the original function. This can sometimes be difficult to spot and can lead
* to unintended behavior if not handled carefully.*/

//Infinite function call may occur

/*Steps to avoid infinite function call
*
* When utilizing implicit recursion, caution must be taken since if the recursive calls are not handled correctly,
* it is simple to produce an endless loop
*
* Additionally, it's typically recommended to avoid implicit recursion if feasible because it might make your code
* more challenging to read and maintain.
*
* Instead, explicit recursion, which is simpler to read and understand, is typically preferred.*/

//Time Complexity: O(N)
//Auxiliary Space: O(1)

class ImplicitRecursion {

    public static int findLargest(List<Integer> numbers) {
        int largest = numbers.get(0);
        for (int number: numbers) {
            if (number > largest) {
                largest = number;
            }
        }
        return largest;
    }

    public static int findSecondLargest(List<Integer> numbers) {
        final int largest = findLargest(numbers);
        //Remove the largest number from the list
        numbers = numbers.stream()
                .filter(n -> n != largest)
                .collect(Collectors.toList());

        //Return the largest remaining number
        return findLargest(numbers);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //Function call
        int secondLargest = findSecondLargest(numbers);
        System.out.println(secondLargest);
    }
}
