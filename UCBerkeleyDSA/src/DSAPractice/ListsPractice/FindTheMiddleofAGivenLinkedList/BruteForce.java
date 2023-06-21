package DSAPractice.ListsPractice.FindTheMiddleofAGivenLinkedList;
import java.util.ArrayList;

//Time Complexity: O(n), for traversing
//Auxiliary Space: O(n), for Vector

class Node {
    public int data;
    public Node next;
}

class NodeOperation {
    //Function to add a new node
    public void pushNode(Node[] headRef, int dataVal) {
        //Allocate node
        Node newNode = new Node();
        //Put in the data
        newNode.data = dataVal;
        //Link the old list of the new node
        newNode.next = headRef[0];
        //move the head to point to the new node
        headRef[0] = newNode;
    }
}

//Driver code
public class BruteForce {
    public static void main(String[] args) {
        Node[] head = new Node[1];
        NodeOperation temp = new NodeOperation();
        for (int i = 5; i > 0; i--) {
            temp.pushNode(head, i);
        }
        ArrayList<Integer> v = new ArrayList<>();
        Node curr = head[0];
        while (curr != null) {
            v.add(curr.data);
            curr = curr.next;
        }
        System.out.println("Middle Value of Linked List is : ");
        System.out.println(v.get(v.size() / 2));
    }
}