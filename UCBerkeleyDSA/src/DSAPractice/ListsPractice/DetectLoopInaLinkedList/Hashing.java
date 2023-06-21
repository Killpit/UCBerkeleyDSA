package DSAPractice.ListsPractice.DetectLoopInaLinkedList;
import java.util.HashSet;

/*The idea is to insert the nodes in the hashmap and whenever a node is encountered, that is already present in the
* hashmap then return true.
*
* Traverse the list individually and keep putting the node addresses in a Hash Table.
* At any point, if NULL is reached then return false.
* If the next of the current nodes points to any of the previously stored nodes in Hash, then return true*/

// Java program to detect loop in a linked list
// Program to detect a loop in a linked list

// Node class
// Program to detect a loop in a linked list

//Time complexity: O(N), only one traversal of the loop is needed
//Auxiliary Space: O(N), N is the space required to store the value in the hashmap

// Node class
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

// Main class
public class Hashing {
    public static void main(String args[]) {
        Node head = new Node(10);
        Node n1 = new Node(20);
        head.next = n1;
        Node n2 = new Node(30);
        n1.next = n2;
        Node n3 = new Node(40);
        n2.next = n3;
        Node n4 = new Node(50);
        n3.next = n4;

        // Creating loop
        n2.next = head;

        // Object creation and function calling
        Hashing o = new Hashing();
        o.findcycle(head);
    }

    // Function to detect a cycle
    public void findcycle(Node head) {
        Node p = head;
        HashSet h = new HashSet < > ();

        // Traverse the Linked List.
        while (p != null) {
            System.out.println("Inserting node " + p.data);
            // Checking if current node is already present
            if (h.contains(p)) {
                System.out.println("Cycle found");
                return;
            }
            // Adding the current node as it was not previously added
            h.add(p);
            p = p.next;
        }
        System.out.println("Cycle not found");
    }
}