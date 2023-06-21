package DSAPractice.ListsPractice.DetectLoopInaLinkedList;
import java.util.*;

/*The idea is to store the length of the list from first node and last node, increment last node till reaches NULL
* or number of nodes in last is greater than the current between first and last nodes*/

/*
* Steps:
* In this method, two pointers are created, first and last
* Each time the last pointer moves, calculate no of nodes between the first and last
* Check whether the current no of nodes > previous no of nodes
*   If yes, we proceed by moving the last pointer
*   Else, it means we reached the end of the loop, so return output accordingly*/

//Time Complexity: O(n^2), for every node, we calculate the length of that node from the head by traversing
//Auxiliary Space: O(1)

class LengthStoring {

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

    //A utility function to print a linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
        System.out.println();
    }

    //returns distance between first and last node every time, last node moves forward
    static int distance(Node first, Node last) {
        //counts number of nodes between first and last
        int counter = 0;
        Node curr;
        curr = first;
        while (curr != last) {
            counter += 1;
            curr = curr.next;
        }
        return counter + 1;
    }

    //Function to detect first node of the loop in a linked list that may contain loop
    static boolean detectLoop(Node head) {
        //Create a temporary node
        Node temp = new Node();
        Node first, last;

        //first always points to head
        first = head;

        //last pointer initially points to head
        last = head;

        //current_length stores no of nodes between current position of first and last
        int current_length = 0;

        //current_length stores no of nodes between previous position of first and last
        int prev_length = -1;
        while (current_length > prev_length && last != null) {
            //set prev_length to current length, then update the current length
            prev_length = current_length;

            //Distance is calculated
            current_length = distance(first, last);

            //last node points the next node
            last = last.next;
        }

        if (last == null) {
            return false;
        }
        else {
            return true;
        }
    }

    //Driver program to test above function
    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);

        //Create a loop for testing (5 is pointing to 3)
        head.next.next.next.next.next = head.next.next;
        boolean found = detectLoop(head);
        if (found) {
            System.out.println("Loop Found");
        }
        else {
            System.out.println("No Loop Found");
        }
    }
}