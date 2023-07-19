package BinarySearchTree;
import java.util.*;

/*Case 1 (Delete a Leaf Node in BST)
*
* Deleting a leaf node is simple in BST. Simply remove it from the tree, as there is no node smaller than it.
*
* Case 2 (Delete a Node with Single Child in BST)
*
* Deleting a single child node is also simple in BST. Copy the child to the node and delete the node
*
* Case 3 (Delete a Node with Both Children in BST)
*
* Deleting a node with both children is not so simple. Here, we have to delete the node in such a way that the
* resulting tree follows the properties of a BST.
* The trick is to find the inorder successor of the node. Copy contents of the inorder successor to the node, and
* delete the inorder successor*/

/*Note: Inorder successor is needed only when the right child is not empty. In this particular case, the inorder
* successor can be obtained by finding the minimum value in the right child of the node*/

class Node {
    int key;
    Node left, right;

    // A utility function to create a new BST node
    Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    // A utility function to do inorder traversal of BST
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    /* A utility function to insert a new node with given key in
     * BST */
    Node insert(Node node, int key) {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        /* return the (unchanged) node pointer */
        return node;
    }

    /* Given a binary search tree and a key, this function
       deletes the key and returns the new root */
    Node deleteNode(Node root, int key) {
        // Base case
        if (root == null)
            return root;

        // Recursive calls for ancestors of
        // node to be deleted
        if (root.key > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // We reach here when root is the node
        // to be deleted.

        // If one of the children is empty
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }

        // If both children exist
        else {

            Node succParent = root;

            // Find successor
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            // Copy Successor Data to root
            root.key = succ.key;

            // Delete Successor and return root
            return root;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        BST tree = new BST();

        /* Let us create following BST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);

        System.out.print("Original BST: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete a Leaf Node: 20");
        tree.root = tree.deleteNode(tree.root, 20);
        System.out.print("Modified BST tree after deleting Leaf Node:\n");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete Node with single child: 70");
        tree.root = tree.deleteNode(tree.root, 70);
        System.out.print("Modified BST tree after deleting single child Node:\n");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete Node with both child: 50");
        tree.root = tree.deleteNode(tree.root, 50);
        System.out.print("Modified BST tree after deleting both child Node:\n");
        tree.inorder(tree.root);
    }
}