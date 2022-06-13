package LinkedList;

public class LinkedList {
    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public void insert(int new_data){
        /*
        insert new Node at the end of the list
         */
        Node new_node = new Node(new_data);
        Node node = head;
        while(node.next!=null){
            node = node.next;
        }
        node.next = new_node;
    }

    public void printList()
    {
        Node node = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public Node reverseLinkedList(){
        Node prev = null;
        Node curr = head;
        while (curr!=null){
            Node next = curr.next;
            curr.next = prev;
            head = curr;
            prev = curr;
            curr = next;
        }
        return head;
    }
}