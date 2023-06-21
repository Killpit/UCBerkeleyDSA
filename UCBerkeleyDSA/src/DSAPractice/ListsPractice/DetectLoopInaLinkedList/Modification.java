package DSAPractice.ListsPractice.DetectLoopInaLinkedList;

//The idea is to modify the node structure by adding flag in it and mark the flag whenever we visit the node

/*
* Follow the steps below to solve the problem:
* Have a visited flag with each node.
* Traverse the linked list and keep marking visited nodes.
* If you see a visited node again, then there is a loop.*/

//Time Complexity: O(N), Only one traversal of the loop is needed
//Auxiliary Space: O(1)

class Modification {

    //Link list node
    static class Node {
        int data;
        Node next;
        int flag;
    };

    static Node push(Node head_ref, int new_data) {

        //Allocate node
        Node new_node = new Node();

        //Put in the data
        new_node.data = new_data;

        new_node.flag = 0;

        //Link the old list of the new node
        new_node.next = head_ref;

        //Move the head to point to the new node
        head_ref = new_node;
        return head_ref;
    }

    //Returns true if there is a loop in linked list, else returns false
    static boolean detectLoop(Node h) {
        while (h != null) {

            //If this node is already traversed, it means that there is a cycle
            //(Because we encounter the node for the second time)
            if (h.flag == 1)
                return true;

            //If we are seeing the node for the first time, mark its flag as 1
            h.flag = 1;

            h = h.next;
        }
        return false;
    }

    //Start with the empty list
    Node head = null;

    //Driver code
    public static void main(String[] args) {

        //Start with the empty list
        Node head = null;

        head = push(head, 20);
        head = push(head, 4);
        head = push(head, 15);
        head = push(head, 10);

        //Create a loop for testing
        head.next.next.next.next = head;

        if (detectLoop(head))
            System.out.println("Loop Found");
        else
            System.out.println("No Loop");
    }
}