package algo;

import Tree.BinaryTreeNode;
import org.junit.Test;

public class PrintLevelOfEachNode {
    /**
     * 打印出每个节点所在的层数
     */
    public void solution (BinaryTreeNode<String> root, int level) {
        if (root == null) {
            return;
        }
        System.out.println("Current node: " + root.data + " current level: " + level);
        solution(root.left, level + 1);
        solution(root.right, level + 1);
    }

    @Test
    public void test () {
        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("a");
        nodeA.insertLeft("b");
        nodeA.insertRight("c");

        BinaryTreeNode<String> nodeB = nodeA.left;
        nodeB.insertRight("d");

        BinaryTreeNode<String> nodeC = nodeA.right;
        nodeB.insertLeft("e");
        nodeB.insertRight("f");

        solution(nodeA, 1);
    }
}
