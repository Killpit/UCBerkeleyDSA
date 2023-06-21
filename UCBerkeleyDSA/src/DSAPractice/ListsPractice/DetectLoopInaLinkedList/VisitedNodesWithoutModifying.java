package DSAPractice.ListsPractice.DetectLoopInaLinkedList;

/*The idea is to point the current node of the linked list to a node which is created. Whenever a node's next is
* pointing to that node, it means the loop is there*/

/*
* Steps:
* A temporary node is created.
* The next pointer of each node that is traversed is made to point to this temporary node.
* This way, we are using the next pointer of a node as a flag to indicate whether the node has been traversed or not.
* Every node is checked to see if the next is pointing to a temporary node or not.
* In the case of the first node of the loop, the second time we traverse it, this condition will be true, hence we
* find that loop exists.
* If we come across a node that points to null, then the loop doesn't exist*/

/*
* Time Complexity: O(N). Only one traversal of the loop is needed.
* Auxiliary Space: O(1)*/

public class VisitedNodesWithoutModifying {

    static class Node {
        int key;
        Node next;
    }

    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        temp.next = null;
        return temp;
    }

    // A utility function to print a linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
        System.out.println();
    }

    //Function to detect first node of loop in a linked list that may contain loop
    static boolean detectLoop(Node head) {

        //Create a temporary node
        Node temp = new Node();
        while (head != null) {

            //This condition is for the case when there is no loop
            if (head.next == null) {
                return false;
            }

            //Check if next is already pointing to temp
            if (head.next == temp) {
                return true;
            }

            //Store the pointer to the next node in order to get to it in the next step
            Node next = head.next;

            //Make next point to temp
            head.next = temp;

            //Get to the next node in the list
            head = next;
        }

        return false;
    }

    //Driver code
    public static void main(String[] args ) {
        Node head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);

        //Create a loop for testing (5 is pointing to 3)
        head.next.next.next.next.next = head.next.next;

        boolean found = detectLoop(head);

        if (found)
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }
}