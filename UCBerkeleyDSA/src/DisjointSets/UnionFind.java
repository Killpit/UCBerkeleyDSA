package DisjointSets;

/*
Union Find (Disjoint Sets)
*
Two sets are named disjoint sets if they have no elements in common. A Disjoint Set (Union Find) data structure keeps
track of a fixed number of elements partitioned into a number of disjoint sets. The data structure has two operations:

connect(x, y): connect x and y. Also known as union
isConnected(x, y): returns true if x and y are connected (i.e. part of the same set)

Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the
same subset.
Union: Join two subsets into a single subset. Here first we have to check if the two subsets belong to same set.
If no, then we cannot perform union.
*/

/*
* Implementation:
*
* Initially create a parent[] array to keep track of the subsets.
* Traverse through all the edges:
* Check to which subset each of the nodes belong to by finding the parent[] array till the node and the parent are the
* same.
* If the two nodes belong to the same subset, then they belong to a cycle
* Otherwise, perform union operation on those two subsets.
* If no cycle is found, return false.*/

/*
*Time Complexity:
*
* Creating the graph takes O(V+E) time, where V is the number of vertices and E is the number of edges.
* Finding the subset of an element takes O(logV) time in the worst case, where V is the number of vertices. The
* worst case occurs when the tree is skewed, and the depth of the tree is V.
* Union of two subsets takes O(1) time.
* The loop iterating through all edges takes O(E) time.
* Therefore, the overall time complexity of the algorithms is O(E logV). However, in practice, it can be much
* faster than O(E logV) because the worst-case scenario of finding the subset of an element does not happen often.
*/

/*
* Space Complexity:
*
* The space complexity of creating the graph is O(E).
* The space complexity of creating the parent array is O(V).
* The space complexity of the algorithms is O(max(V,E)), because at any point in time, there can be at most
* max(V,E) subsets.
* Therefore, the overall space complexity of the algorithm is O(max(V,E))
*/

public class UnionFind {
    int V, E; // V -> no of vertices & E -> no of edges
    Edge[] edge; //collection of all edges

    static class Edge {
        int src, dest;
    }

    //Create a graph with V vertices and E edges
    UnionFind(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    //A utility function to find the subset of an element i
    int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    //A utility function to do union of two subsets
    void Union(int[] parent, int x, int y) {
        parent[x] = y;
    }

    //The main function to check whether a given graph contains cycle or not
    int isCycle(UnionFind unionFind) {
        //Allocate memory for creating V subsets
        int[] parent = new int[unionFind.V];

        //Initialize all subsets as single element sets
        for (int i = 0; i < unionFind.V; ++i)
            parent[i] = i;

        //Iterate through all edges of graph, find subset of both vertices of every edge, if both subsets are same,
        //then there is cycle in graph
        for (int i = 0; i < unionFind.E; ++i) {
            int x = unionFind.find(parent, unionFind.edge[i].src);
            int y = unionFind.find(parent, unionFind.edge[i].dest);

            if (x == y)
                return 1;

            unionFind.Union(parent, x, y);
        }
        return 0;
    }

    //Driver Method
    public static void main(String[] args) {
        //Following graph
        int V = 3, E = 3;
        UnionFind unionFind = new UnionFind(V, E);

        //add edge 0-1
        unionFind.edge[0].src = 0;
        unionFind.edge[0].dest = 1;

        //add edge 1-2
        unionFind.edge[1].src = 1;
        unionFind.edge[1].dest = 2;

        //add edge 0-2
        unionFind.edge[2].src = 0;
        unionFind.edge[2].dest = 2;

        if (unionFind.isCycle(unionFind) == 1)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}