package DisjointSets;
import java.util.Arrays;
import java.util.Random;

/*Problem:
* The goal of this algorithm is to find if any two elements are connected. If not connected, then connect them. The
* problem is also called dynamic connectivity problem. This connection is an equivalence relationship. We assume that:
*
* Symmetric: If p is connected to q, then q is also connected to p.
* Transitive: If p is connected to q and q is connected to r, p is connected to r as well
* Reflexive: p is connected to p
*/

public class QuickFind {
    private int[] integerArray;

    public int[] getIntegerArray() {
        return integerArray;
    }

    public void setIntegerArray(int[] integerArray) {
        this.integerArray = integerArray;
    }

    public  QuickFind(int lengthOfArray) {
        this.integerArray = new int[lengthOfArray];
        for (int i = 0; i < integerArray.length; i++) {
            this.integerArray[i] = new Random().nextInt(20) + 1;
        }
    }

    public int find(int index) {
        return integerArray[index];
    }

    public boolean connected(int p, int q) {
        return integerArray[p] == integerArray[q];
    }

    public void union(int p, int q) {
        int valueOfP = integerArray[p];
        int valueOfQ = integerArray[q];

        if (valueOfP != valueOfQ) {
            for (int i = 0; i < integerArray.length; i++) {
                if (integerArray[i] == valueOfP) {
                    integerArray[i] = valueOfQ;
                }
            }
        }
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(20);

        System.out.println("Values of array: " + Arrays.toString(quickFind.getIntegerArray()));
        System.out.println("Value at 4th index is " + quickFind.find(4));
        System.out.println("Is index 1 and 4 are connected? " + quickFind.connected(1, 4));
        System.out.println("Processing union of indexes 5 and 6. Please wait...");
        quickFind.union(5, 6);
        System.out.println("Done");

        System.out.println("Array values after the union: " + Arrays.toString(quickFind.getIntegerArray()));
    }
}