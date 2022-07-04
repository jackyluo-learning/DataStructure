package LinkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        ListNode head3 = new ListNode(2);
        head3 = insert(head3, 4);
        head3 = insert(head3, 7);
        head3 = insert(head3, 14);
        head3 = insert(head3, 17);
        printList(head);
        System.out.println();
        printList(head2);
        System.out.println();
        printList(head3);
        System.out.println();
//        ListNode head4 = mergeTwoList1(head2, head2);
//        printList(head4);
        System.out.println();

        ListNode[] lists = new ListNode[3];
        lists[0] = head;
        lists[1] = head2;
        lists[2] = head3;
        ListNode head5 = mergeKListsWithDAC(lists);
        printList(head5);
    }

    /**
     * 迭代方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList1 (ListNode list1, ListNode list2) {
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tail.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                tail.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        return fakeHead.next;
    }


    /**
     * 递归方式
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 遍历法
     * @param listNodes
     * @return
     */
    public ListNode mergeKLists (ListNode[] listNodes) {
        ListNode ans = null;
        for (int i = 0; i < listNodes.length; i++) {
            ans = mergeTwoList1(ans, listNodes[i]);
            System.out.print(i + ": ");
            printList(ans);
            System.out.println();
        }
        System.out.println(ans);
        return ans;
    }

    /**
     * 分治法
     * @return
     */
    public ListNode mergeKListsWithDAC (ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge (ListNode[] list, int l, int r) {
        if (l == r) {
            return list[l];
        }
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        return mergeTwoList1(merge(list, l, mid), merge(list, mid + 1, r));
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
