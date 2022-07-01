package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    /*
      请你设计并实现一个满足LRU (最近最少使用) 缓存 约束的数据结构。
      实现 LRUCache 类：
      LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
      int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
      void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该逐出最久未使用的关键字。
      函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     */

    /**
     * 总容量
     */
    private int capacity;

    /**
     * 当前容量
     */
    private int size;

    /**
     * dummy head
     */
    private Node fakeHead;

    /**
     * dummy tail
     */
    private Node fakeTail;

    /**
     * 用于存放key value
     */
    private Map<Integer, Node> map;

    public LRU (int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        fakeHead = new Node();
        fakeTail = new Node();
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }

    /**
     * 放节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node currentNode = this.map.get(key);
            currentNode.data = value;
            this.map.put(key, currentNode);
            moveToHead(currentNode);
        } else {
            Node currentNode = new Node(key, value);
            this.map.put(key, currentNode);
            addToHead(currentNode);
            size++;
            if (this.size > this.capacity) {
                Node currentTail = this.fakeTail.prev;
                int currentKey = currentTail.key;
                this.map.remove(currentKey);
                removeTail();
                size--;
            }
        }
    }

    public int get (int key) {
        int result = -1;
        if (this.map.containsKey(key)) {
            Node resultNode = this.map.get(key);
            result = resultNode.data;
            moveToHead(resultNode);
        }
        return result;
    }

    /**
     * 移出指定节点
     * @param target
     */
    private void removeNode (Node target) {
        Node targetPrev = target.prev;
        Node targetNext = target.next;
        targetPrev.next = targetNext;
        targetNext.prev = targetPrev;
    }

    /**
     * 移出链表尾
     */
    private void removeTail () {
        removeNode(this.fakeTail.prev);
    }

    /**
     * 将指定节点加入到头部
     * @param target
     */
    private void addToHead (Node target) {
        Node targetNext = this.fakeHead.next;
        this.fakeHead.next = target;
        target.next = targetNext;
        target.prev = this.fakeHead;
        targetNext.prev = target;
    }

    /**
     * 将指定节点移动到头部
     * @param target
     */
    private void moveToHead (Node target) {
        removeNode(target);
        addToHead(target);
    }

    public void printLinkedList () {
        Node current = this.fakeHead.next;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
    }
}