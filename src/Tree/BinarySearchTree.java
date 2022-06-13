package Tree;

import java.util.LinkedList;

public class BinarySearchTree {
    public BinaryTreeNode<Integer> root;

    public BinarySearchTree(int value) {
        root = new BinaryTreeNode(value);
    }

    public void insert(int value) {
        BinaryTreeNode node = root;
        while (node != null) {
            if (value >= (int) node.data && node.right != null) {
                node = node.right;
            } else if (value < (int) node.data && node.left != null) {
                node = node.left;
            } else if (value >= (int) node.data) {
                BinaryTreeNode newNode = new BinaryTreeNode(value);
                node.right = newNode;
                break;
            } else {
                BinaryTreeNode newNode = new BinaryTreeNode(value);
                node.left = newNode;
                break;
            }
        }
    }

    public static boolean search(BinaryTreeNode node, int value) {
        if (node != null) {
            if (value > (int) node.data) {
                return search(node.right, value);
            } else if (value < (int) node.data) {
                return search(node.left, value);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean delete(BinaryTreeNode node, int value, BinaryTreeNode parent) {
        if (node != null) {
            if (value > (int) node.data) {
                return delete(node.right, value, node);
            } else if (value < (int) node.data) {
                return delete(node.left, value, node);
            } else if (value == (int) node.data) {
                if (node.left == null && node.right == null) {
                    if (node == parent.left) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (node.left != null || node.right != null) {
                    if (node == parent.left) {
                        parent.left = node.left != null ? node.left : node.right;
                    } else {
                        parent.right = node.left != null ? node.left : node.right;
                    }
                } else {
                    node.data = findMin(node.right);
                    delete(node.right, (int) node.data, node);
                }
                return true;
            }
        }
        return false;
    }

    public static Integer findMin(BinaryTreeNode node) {
        while (node != null) {
            if (node.left == null) {
                return (int) node.data;
            }
            node = node.left;
        }
        return null;
    }

    public static LinkedList findAncestor(BinaryTreeNode node, int value, LinkedList result) {
        if (node == null) {
            return result;
        }
        if (value > (int) node.data) {
            result = findAncestor(node.right, value, result);

        } else if (value < (int) node.data) {
            result = findAncestor(node.left, value, result);

        } else {
            return result;
        }
        result.add(node.data);
        return result;
    }
}

