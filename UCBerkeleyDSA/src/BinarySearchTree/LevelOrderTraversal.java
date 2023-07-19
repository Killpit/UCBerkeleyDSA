package BinarySearchTree;

/*Level order traversal of a BST is breadth first traversal for the tree. It visits all nodes at a particular level
* first before moving to the next level*/

//Time Complexity: O(N), where N is the number of nodes of the BST
//Auxiliary Space: O(1)

class LevelOrderTraversal {

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
    static node insert(node node, int key) {

        //If the tree is empty, return a new node
        if (node == null)
            return newNode(key);

        //Otherwise, recur down the tree
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        //Return the node
        return node;
    }

    //Returns height of the BST
    static int height(node node) {

        if (node == null)
            return 0;
        else {

            //Compute the depth of each subtree
            int lDepth = height(node.left);
            int rDepth = height(node.right);

            //Use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    //Print nodes at a given leve
    static void printGivenLevel(node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(" " + root.key);
        else if (level > 1) {

            //Recursive call
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    //Function to line by line print level order traversal a tree
    static void printLevelOrder(node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
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
        printLevelOrder(root);
    }
}
