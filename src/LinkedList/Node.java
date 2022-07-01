package LinkedList;

class Node {
    int data;

    int key;
    Node next;

    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }

    Node(int k, int d) {
        key = k;
        data = d;
        next = null;
        prev = null;
    }

    Node () {

    }
}
