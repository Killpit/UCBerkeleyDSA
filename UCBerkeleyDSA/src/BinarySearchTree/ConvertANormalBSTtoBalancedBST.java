package BinarySearchTree;
import java.util.*;

/*A simple solution is to traverse nodes in inorder and one by one insert into a self-balancing BST like AVL tree. Time
* complexity of this solution is O(NLogN) and this solution doesn't guarantee the minimum possible height as in the
* worst case the height of the AVL tree can be 1.44*log2N
*
* An efficient solution can be to construct a balanced BST in O(N) time with minimum possible height.
*
* Steps:
*
* Traverse given BST in inorder and store result in an array. This step takes O(N) time. Note that this array would be
* sorted as inorder traversal of BST always produces sorted sequence.
*
* Build a balanced BST from the above created sorted array using the recursive approach. This step also takes O(N) time
* as we traverse every element exactly once and processing an element takes O(1) time.*/

class ConvertANormalBSTtoBalancedBST {
    int data;
    ConvertANormalBSTtoBalancedBST left, right;

    public ConvertANormalBSTtoBalancedBST(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    ConvertANormalBSTtoBalancedBST root;

    //This function traverse the skewed binary tree and stores its nodes pointers in vector nodes[]
    void storeBSTNodes(ConvertANormalBSTtoBalancedBST root, Vector<ConvertANormalBSTtoBalancedBST> nodes) {

        //Base case
        if (root == null)
            return;

        //Store nodes in Inorder (which is sorted order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    //Recursive function to construct binary tree
    ConvertANormalBSTtoBalancedBST buildTreeUtil(Vector<ConvertANormalBSTtoBalancedBST> nodes, int start, int end) {
        //base case
        if (start > end)
            return null;

        //Get the middle element and make it root
        int mid = (start + end) / 2;
        ConvertANormalBSTtoBalancedBST node = nodes.get(mid);

        /*Using index in inorder traversal, construct left and right subtrees*/
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    //This functions converts an unbalanced BST to a balanced BST
    ConvertANormalBSTtoBalancedBST buildTree(ConvertANormalBSTtoBalancedBST root) {
        Vector<ConvertANormalBSTtoBalancedBST> nodes = new Vector<ConvertANormalBSTtoBalancedBST>();
        storeBSTNodes(root, nodes);

        //Constructs BST from nodes[]
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    //Function to do preorder traversal of tree
    void preOrder(ConvertANormalBSTtoBalancedBST node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //Driver program to test the above functions
    public static void main(String[] args) {
        //Constructing skewed binary tree
        BinaryTree tree = new BinaryTree();
        tree.root = new ConvertANormalBSTtoBalancedBST(10);
        tree.root.left = new ConvertANormalBSTtoBalancedBST(8);
        tree.root.left.left = new ConvertANormalBSTtoBalancedBST(7);
        tree.root.left.left.left = new ConvertANormalBSTtoBalancedBST(6);
        tree.root.left.left.left.left = new ConvertANormalBSTtoBalancedBST(5);

        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }
}