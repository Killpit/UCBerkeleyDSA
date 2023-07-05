package DSAPractice.ArrayPractice.RearrangeAnArraySuchThatArriEqualsI;
import java.util.*;
import java.lang.*;

/*Alternative Approach
*
* Navigate through the array
* Check if a[i] = -1, if yes, then ignore it
* If a[i] != -1, Check if element a[i] is at its correct position (i=A[i]). If yes, then ignore it
* If a[i] != -1 and element a[i] is not at its correct position (i != A[i]), then place it to its correct position,
* but there are two conditions:
*
* Either A[i] is vacate, means A[i] = -1, then just put A[i] = i
* OR A[i] is not vacate, means A[i] = x, then int y = x put A[i] = i. Now, we need to place y to its correct place,
* so, repeat frpm step 3*/

public class AlternativeApproach {

    //Function to rearrange an array such that arr[i] = i
    public static int[] fix(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != -1 && A[i] != i) {
                int x = A[i];

                //check if desired place is not vacant
                while (A[x] != -1 && A[x] != x) {

                    //store the value from desired place
                    int y = A[x];

                    //place the x to its correct position
                    A[x] = x;

                    //now y will become x, now search the place for x
                    x = y;
                }

                //place the x to its correct position
                A[x] = x;

                //check if while loop hasn't set the correct value at A[i]
                if (A[i] != i) {

                    //if not then put -1 at the vacated place
                    A[i] = -1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {

        int A[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        System.out.println(Arrays.toString(fix(A)));
    }
}