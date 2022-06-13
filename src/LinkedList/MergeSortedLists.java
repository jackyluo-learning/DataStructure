package LinkedList;

import org.junit.Test;

public class MergeSortedLists {
    /*
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insert(ListNode head, int new_data) {
        /*
        insert new Node at the end of the list
         */
        ListNode new_node = new ListNode(new_data);
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new_node;
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(2);
        head = insert(head, 5);
        head = insert(head, 8);
        head = insert(head, 9);
        ListNode head2 = new ListNode(1);
        head2 = insert(head2, 6);
        head2 = insert(head2, 10);
        head2 = insert(head2, 11);
        head2 = insert(head2, 15);
        printList(head);
        System.out.println();
        printList(head2);
        System.out.println();
        printFromLast(head2);
        System.out.println();
        ListNode head3 = mergeList3(head, head2);
        printList(head3);
    }


    public ListNode mergeSortedList1(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode lastNode = null;
        ListNode firstNode = null;
        while (current1 != null || current2 != null) {
            ListNode newNode = null;
            if (current1 == null) {
                newNode = new ListNode(current2.val);
                current2 = current2.next;
            } else if (current2 == null) {
                newNode = new ListNode(current1.val);
                current1 = current1.next;
            } else if (current1.val >= current2.val) {
                newNode = new ListNode(current2.val);
                current2 = current2.next;
            } else {
                newNode = new ListNode(current1.val);
                current1 = current1.next;
            }
            if (firstNode == null) {
                firstNode = newNode;
            }
            if (lastNode == null) {
                lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode = newNode;
            }
        }
        return firstNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        if (current1 == null) {
            return current2;
        } else if (current2 == null) {
            return current1;
        } else if (current1.val >= current2.val) {
            current2.next = mergeTwoLists2(current1, current2.next);
            return current2;
        } else {
            current1.next = mergeTwoLists2(current2, current1.next);
            return current1;
        }
    }

    public ListNode mergeList3(ListNode l1, ListNode l2) {
        ListNode head;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        ListNode prev = head;
        while (l1 != null || l2 != null) {
            if (l2 == null) {
                prev.next = l1;
                l1 = l1.next;
            } else if (l1 == null) {
                prev.next = l2;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public void printFromLast(ListNode node){
        if(node == null) return;
        printFromLast(node.next);
        System.out.print(node.val + " ");
    }
}
