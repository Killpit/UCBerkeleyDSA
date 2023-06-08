package lists;
import org.w3c.dom.Node;

class SinglyLinkedListInsertion {
    Node head; //head of list

    // Node class
    class Node {
        int data;
        Node next;

        //Constructor to create a new node
        Node(int d) {data = d; next = null;}
    }
}