package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {

    public static void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.data);

            if (node.left != null) {
                preOrder(node.left);
            }
            if (node.right != null) {
                preOrder(node.right);
            }
        }
    }

    public static void inOrder(BinaryTreeNode node) {
        if (node != null) {
            if (node.left != null) {
                inOrder(node.left);
            }
            System.out.println(node.data);
            if (node.right != null) {
                inOrder(node.right);
            }
        }
    }

    public static void postOrder(BinaryTreeNode node) {
        if (node != null) {
            if (node.left != null) {
                postOrder(node.left);
            }
            if (node.right != null) {
                postOrder(node.right);
            }
            System.out.println(node.data);
        }
    }

    public static ArrayList<ArrayList<Object>> BFS(BinaryTreeNode node) {
        LinkedList queue = new LinkedList<>();
        LinkedList<BinaryTreeNode> waitqueue = new LinkedList<>();
        waitqueue.add(node);
        ArrayList<ArrayList<Object>> resultLevel = new ArrayList<>();
        while (!waitqueue.isEmpty()) {
            ArrayList<Object> level = new ArrayList<>();
            int len = waitqueue.size();
            for (int i = 0; i < len; i++) {
                BinaryTreeNode n = waitqueue.remove();
                queue.add(n.data);
                if (n.left != null) {
                    waitqueue.add(n.left);
                }
                if (n.right != null) {
                    waitqueue.add(n.right);
                }
                level.add(n.data);
            }
            resultLevel.add(level);
        }
        return resultLevel;
    }

}

class BinaryTreeNode<T> {
    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public T data;

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right) {
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T data) {
        this(null, null);
        this.data = data;
    }

    public BinaryTreeNode() {
    }

    public T getData(){
        return data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void insertLeft(String value) {
        if (this.left == null) {
            setLeft(new BinaryTreeNode(value));
        } else {
            BinaryTreeNode newNode = new BinaryTreeNode(value);
            newNode.left = this.left;
            this.left = newNode;
        }
    }

    public void insertRight(String value) {
        if (this.right == null) {
            setRight(new BinaryTreeNode(value));
        } else {
            BinaryTreeNode newNode = new BinaryTreeNode(value);
            newNode.right = this.right;
            this.right = newNode;
        }
    }
}
