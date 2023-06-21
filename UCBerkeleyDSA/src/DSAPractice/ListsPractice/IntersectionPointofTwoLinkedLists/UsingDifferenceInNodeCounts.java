package DSAPractice.ListsPractice.IntersectionPointofTwoLinkedLists;

/*
* Get the count of the nodes in the first list, let the count be c1.
* Get the count of the nodes in the second list, let the count be c2.
* Get the difference of counts d = abs(c1-c2)
* Now traverse the bigger list from the first node to d nodes so that from here onwards both the lists have an equal
* no of nodes
* Then we can traverse both lists in parallel till we come across a common node. (Note that getting a common node is
* done by comparing the address of the nodes)*/

/*
* Steps:
*
* 1-Traverse the bigger list from the first node to d nodes so that from here onwards, both the lists have an equal
* no of nodes
*
* 2-Traverse both lists in parallel till we come across a common node*/

//Time Complexity: O(m+n)
//Auxiliary Space: O(1)

class UsingDifferenceInNodeCounts {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //function to get the intersection point of two linked lists head1 and head2
    int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return _getIntersectionNode(d, head1, head2);
        }
        else {
            d = c2 - c1;
            return _getIntersectionNode(d, head2, head1);
        }
    }

    //Function to get the intersection point of two linked lists head1 and head2 where head1 has d more nodes than
    //head2
    int _getIntersectionNode(int d, Node node1, Node node2) {
        int i;
        Node current1 = node1;
        Node current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    //Takes head pointer of the linked list and returns the count of nodes in the list

    int getCount(Node node) {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    //Driver code - main method
    public static void main(String[] args) {
        UsingDifferenceInNodeCounts list = new UsingDifferenceInNodeCounts();

        //creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        //creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + list.getNode());
    }
}