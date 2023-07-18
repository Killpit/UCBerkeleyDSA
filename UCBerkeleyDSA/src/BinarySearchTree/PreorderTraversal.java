package BinarySearchTree;

/*Preorder traversal first visits the root node and then traverses the left and the right subtree. It is used to create
* a copy of the tree. Preorder traversal is also used to get prefix expression on of an expression tree.*/

//Time Complexity: O(N), where N is the number of nodes of the BST
//Auxiliary Space: O(1)

class PreorderTraversal {

    //Given Node node
    static class node {
        int key;
        node left, right;
    }

    //Function to create a new BST node
    static node newNode(int item) {
        node temp = new node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    //Function to insert a new node with given key in BST
    static node insert (node node, int key) {

        //If the tree is empty, return a new node
        if (node == null)
            return newNode(key);

        //Otherwise, recur down the tree
        if (key < node.key) {
            node.left = insert(node.left, key);
        }
        else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        //Return the node
        return node;
    }

    //Function to do preorder traversal of BST
    static void preOrder(node root) {

        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //Driver code
    public static void main(String[] args) {


        node root = null;

        //inserting values
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        preOrder(root);
    }
}