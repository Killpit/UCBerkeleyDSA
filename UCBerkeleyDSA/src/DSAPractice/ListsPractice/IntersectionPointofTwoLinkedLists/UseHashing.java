package DSAPractice.ListsPractice.IntersectionPointofTwoLinkedLists;
import java.util.*;

/*
* 1-Create an empty hash set
* 2-Traverse the first linked list and insert all nodes' addresses in the hash set
* 3-Traverse the second list. For every node, check if it's present in the hash set. If we find a node in the hash set
* , return the node*/

//Time Complexity: O(n) where n is the length of the longer list. This is because we need to traverse both of the
//linked lists in order to find the intersection point.
//Space complexity: O(n) because we are using unordered set

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class UseHashing {
    public static void main(String[] args) {
        //list1
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);

        //list2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;
        Print(n1);
        Print(n2);
        System.out.print(MegaNode(n1, n2).data);
    }

    //function to print the list
    public static void Print(Node n) {
        Node cur = n;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //function to find the intersection of two nodes
    public static Node MegaNode(Node n1, Node n2) {

        //define hashset
        HashSet<Node> hs = new HashSet<Node>();
        while (n1 != null) {
            hs.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (hs.contains(n2)) {
                return n2;
            }
            n2 = n2.next;
        }
        return null;
    }
}