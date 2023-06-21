package DSAPractice.ListsPractice.IntersectionPointofTwoLinkedLists;
import java.io.*;

/*This solution requires modifications to the basic linked list data structure. Have a visited flag with each node.
* Traverse the first linked list and keep marking visited nodes. Now traverse the second linked list, if you see a
* visited node again, then there is an intersection point, return the intersecting node. This solution works in O(m+n)
* but requires additional information with each node. A variation of this solution that doesn't require modification
* of the basic data structure can be implemented using a hash. Traverse the first linked list and store the addresses
* of visited nodes in a hash. Now traverse the second linked list and if you see an address that already exists in the
* hash, then return the intersecting node.*/

/*Time Complexity:
* The time complexity of the getIntersectNode function is O(m+n) where m and n are the lengths of the input linked
* lists. This is because in the worst case scenario, we need to traverse both lists once to mark visited nodes, and
* then traverse the second list to find the first node that has already been visited.*/

/*Auxiliary space:
* The auxiliary space required by the program is O(max(m, n)), which is the maximum length of the input linked
* lists. This is because we are making visited nodes in the linked lists using a boolean flag, and we need to do
* this for the entire length of the longer list*/

public class MarkVisitedNodes {

    static class Node {
        int data;
        Node next;
        boolean visited;
        Node(int d) {
            data = d;
            next = null;
            visited = false;
        }
    }

    static int getIntersectNode(Node head1, Node head2) {
        Node temp1 = head1;
        while(temp1 != null) {
            temp1.visited = true;
            temp1 = temp1.next;
        }

        temp1 = head2;
        while (temp1 != null) {
            if(temp1.visited) {
                return temp1.data;
            }
            else {
                temp1.visited = true;
            }
            temp1 = temp1.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        //list 2
        Node head2 = new Node(10);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next;

        System.out.print("The node of intersection is : " + getIntersectNode(head1, head2));
    }
}