package LinkedList;

import org.junit.Test;

import java.util.HashSet;

public class RemoveDuplicateElement {
    public LinkedList removeDuplicateElement(LinkedList linkedList){
        HashSet<Integer> hashSet = new HashSet<>();
        Node node = linkedList.head;
        Node pre = node;
        Node curr;
        while(node != null){
            curr = node;
            if(hashSet.contains(curr.data)){
                pre.next = curr.next;
            }
            else {
                hashSet.add(curr.data);
            }
            pre = curr;
            node = curr.next;
        }
        return linkedList;
    }

    @Test
    public void test(){
        LinkedList linkedList = new LinkedList();
        linkedList.push(20);
        linkedList.push(4);
        linkedList.push(15);
        linkedList.push(10);
        linkedList.push(4);
        linkedList.push(12);
        linkedList.printList();
        System.out.println("\nAfter remove duplicate:");
        removeDuplicateElement(linkedList).printList();
        System.out.println("\nAfter insert new node:");
        linkedList.insert(8);
        linkedList.printList();

    }

    @Test
    public void test2(){
        LinkedList linkedList = new LinkedList();
        linkedList.push(20);
        linkedList.push(4);
        linkedList.push(15);
        linkedList.push(10);
        linkedList.push(4);
        linkedList.push(12);
        linkedList.printList();
        System.out.println("\nAfter reverse:");
        linkedList.reverseLinkedList();
        linkedList.printList();
    }
}
