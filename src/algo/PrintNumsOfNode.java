package algo;

import Tree.BinaryTreeNode;
import org.junit.Test;

public class PrintNumsOfNode {
    /**
     * 打印左右子树的数目
     * @param root
     * @return
     */
    public int solution(BinaryTreeNode<String> root) {
        if (root == null) return 0;
        int leftCount = solution(root.left);
        int rightCount = solution(root.right);
        System.out.println("节点 " + root.data + " 的左子树有 " + leftCount + " 个节点，右子树有 " + rightCount + " 个节点");
        return leftCount + rightCount + 1;
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

        solution(nodeA);
    }
}
