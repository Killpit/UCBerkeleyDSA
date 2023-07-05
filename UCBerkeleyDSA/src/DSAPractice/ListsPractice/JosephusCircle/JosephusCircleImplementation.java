package DSAPractice.ListsPractice.JosephusCircle;

/*There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle
* and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the
* next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the
* executed people are removed), until the only last person remains, who is given freedom. Given the total number of
* person n and a number k, which indicates that k-1 persons are skipped and the kth person is killed in the circle.
* The task is to choose the place in the initial circle so that you are the last one remaining and survive.*/

public class JosephusCircleImplementation {

    //Node class to store data
    static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    //Function to find the only person left after one in every m-th node is killed in a circle of n nodes
    static void getJosephusPosition(int m, int n) {

        //Create a circulat linked list of size N
        Node head = new Node(0);
        Node prev = head;
        for(int i = 1; i < n; i++) {
            prev.next = new Node(i);
            prev = prev.next;
        }

        //Connect last node to first
        prev.next = head;

        //while only one node is left in the linked list
        Node ptr1 = head, ptr2 = head;

        while (ptr1.next != ptr1) {

            //Find m-th node
            int count = 1;
            while (count != m) {
                ptr2 = ptr1;
                ptr1 = ptr1.next;
                count++;
            }

            //Remove the m-th node
            ptr2.next = ptr1.next;
            ptr1 = ptr2.next;
        }

        System.out.println("Last person left standing " + "(Josephus Position) is " + ptr1.data);
    }

    //Driver program to test above functions
    public static void main(String[] args) {
        int n = 14, m = 2;
        getJosephusPosition(m, n);
    }
}