package DisjointSets;

/*Quick-union is also called lazy approach to algorithm design where we try to avoid doing work until we have to do. It
* uses the same data structure of array ID with size N but not it has a different interpretation. We are going to think
* of that array as representing a set of trees that's called a forest as depicted in Figure 2. So, each entry in the
* array is going to contain a reference to its parent in the tree.*/

/*Weighted Quick Union
*

Modify quick-union to avoid tall trees
Keep track of size of each tree (number of objects)
Balance by linking root of smaller tree to root of larger tree
*/

public class QuickUnion {
    private int[] id;

    public void QuickUnion(int N) {
        id = new int [N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
