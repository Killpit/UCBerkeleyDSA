package lists;

class Node {
    int data;
    Node prev;
    Node next;
}

class Main {
    static void reverse(Node[] head_ref)
    {
        Node current = head_ref[0];
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head_ref[0] = temp.prev;
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        Node head = null;
        Node second = null;
        Node third = null;

        // allocate nodes
        head = new Node();
        second = new Node();
        third = new Node();

        // link nodes
        head.data = 1;
        head.prev = null;
        head.next = second;

        second.data = 2;
        second.prev = head;
        second.next = third;

        third.data = 3;
        third.prev = second;
        third.next = null;

        System.out.print("Original List: ");
        printList(head);

        Node[] head_ref = new Node[1];
        head_ref[0] = head;
        reverse(head_ref);
        head = head_ref[0];

        System.out.print("\nReversed List: ");
        printList(head);
    }
}