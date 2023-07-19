package BinarySearchTree;

/*Algorithm
*
* We compare the value to be searched with the value of the root
*
*   If it's equal, we are done with the search if it's smaller, we know that we need to go to the left subtree because
*   in a binary search tree, all the elements in the left subtree are smaller and all the elements in the right subtree
*   are larger
*
* Repeat the above step till no more traversal is possible
* If at any iteration, key is found, return True. Else False
* */

//Time Complexity: O(h), where h is the height of the BST.
//Auxiliary Space: O(h), where h is the height of the BST. This is because the maximum amount of space needed to store
//the recursion stack would be h.

class SearchingBST {
    int key;
    SearchingBST left, right;

    public SearchingBST(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    SearchingBST root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // A utility function to insert
    // a new node with given key in BST
    SearchingBST insert(SearchingBST node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            node = new SearchingBST(key);
            return node;
        }

        // Otherwise, recur down the tree
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        // Return the (unchanged) node pointer
        return node;
    }

    // Utility function to search a key in a BST
    SearchingBST search(SearchingBST root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    // Driver Code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting nodes
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        // Key to be found
        int key = 6;

        // Searching in a BST
        if (tree.search(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");

        key = 60;

        // Searching in a BST
        if (tree.search(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
    }
}