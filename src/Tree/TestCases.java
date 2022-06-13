package Tree;

import org.junit.Test;

import java.util.LinkedList;

public class TestCases {
    @Test
    public void testBinaryTree() {
        BinaryTreeNode<String> nodea = new BinaryTreeNode("a");
        nodea.insertLeft("b");
        nodea.insertRight("c");

        BinaryTreeNode<String> nodeb = nodea.left;
        nodeb.insertRight("d");

        BinaryTreeNode<String> nodec = nodea.right;
        nodec.insertLeft("e");
        nodec.insertRight("f");

        System.out.println("Pre-Order:");
        BinaryTree.preOrder(nodea);

        System.out.println("In-Order:");
        BinaryTree.inOrder(nodea);

        System.out.println("Post-Order:");
        BinaryTree.postOrder(nodea);

        System.out.println("BFS-Order:");
        System.out.println(BinaryTree.BFS(nodea));
    }

    @Test
    public void testBinarySearchTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(50);
        binarySearchTree.insert(76);
        binarySearchTree.insert(21);
        binarySearchTree.insert(4);
        binarySearchTree.insert(32);
        binarySearchTree.insert(100);
        binarySearchTree.insert(64);
        binarySearchTree.insert(52);
        BinaryTree.preOrder(binarySearchTree.root);
        System.out.println("The tree exist 21: " + BinarySearchTree.search(binarySearchTree.root, 21));
        System.out.println("The tree exist 20: " + BinarySearchTree.search(binarySearchTree.root, 20));
        System.out.println("Delete 21 in tree:" + binarySearchTree.delete(binarySearchTree.root, 21, binarySearchTree.root));
        System.out.println("The tree exist 21: " + BinarySearchTree.search(binarySearchTree.root, 21));
        LinkedList result = new LinkedList();
        System.out.println("Ancestors of 52:" + BinarySearchTree.findAncestor(binarySearchTree.root, 52, result));
    }

    @Test
    public void testAVLTree() {
        AVLTreeNode root = new AVLTreeNode(15);
        root = root.insert(root, 6);
        root = root.insert(root, 4);
        root = root.insert(root, 7);
        root = root.insert(root, 5);
        root = root.insert(root, 50);
        root = root.insert(root, 23);
        root = root.insert(root, 71);
        AVLTreeNode.preOrder(root);
        root.remove(root, 71);
        System.out.println("After delete 71: ");
        AVLTreeNode.preOrder(root);
        root.remove(root, 50);
        System.out.println("After delete 50: ");
        AVLTreeNode.preOrder(root);

    }
}
