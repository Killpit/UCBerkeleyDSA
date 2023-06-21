package DSAPractice.ListsPractice.DetectLoopInaLinkedList;

//The idea is to modify the value of the visited node and check if the current nodes value is equal to that value
//or not

/*Steps:
* Traverse the linked list and change the value of that node to -1
* Now, before modifying the value, check whether the value of the node is already -1
*   If it is -1, then return TRUE
*   Otherwise, change the value of the node
* Traverse the linked list till it reaches NULL.*/

/*Time Complexity: O(N)
* Auxiliary Space: O(1)*/

class ModifyingValue {

    //Head of list
    static Node head;

    //Linked list Node
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Inserts a new Node at front of the list
    static public void push(int new_data) {

        //1 & 2: Allocate the Node & Put in the data
        Node new_node = new Node(new_data);

        //3. Make next of new Node as head
        new_node.next = head;

        //4. Move the head to point to new Node
        head = new_node;
    }

    //Function to detect first node of the loop in a linked list that may contain loop
    static boolean detectLoop(Node h) {
        //If the head is null, we will return false
        if (head == null) {
            return false;
        }
        else {
            //Traversing the linked list for detecting loop
            while (head != null) {
                //If loop is found
                if (head.data == -1) {
                    return true;
                }

                /*Changing the data of the visited node to any value which is outside the given range.
                *Here, it is supposed the given range is (1 <= Data on Node <= 10^3) */
                else {
                    head.data = -1;
                    head = head.next;
                }
            }

            //If the loop is not found, return false
            return false;
        }
    }

    //Driver code
    public static void main(String[] args) {
        ModifyingValue llist = new ModifyingValue();

        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);

        //Create a loop for testing
        llist.head.next.next.next.next.next = llist.head.next.next;

        if (detectLoop(llist.head))
            System.out.println("Loop Found");
        else
            System.out.println("Not Found");
    }
}