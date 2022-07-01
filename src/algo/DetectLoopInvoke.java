package algo;

import java.util.ArrayList;
import java.util.List;

public class DetectLoopInvoke {
    public static void main(String[] args) {
        //构建结构关系
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        B.setParent(A);
        C.setParent(B);
        D.setParent(A);
        E.setParent(C);
        A.setParent(C);
        F.setParent(D);
    }
}

class Node {
    String nodeName;
    Node parent;

    public Node (String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        if (hasLoopInvoke(parent)) {
            List<Node> invokeChain = new ArrayList<>();
            invokeChain.add(this);
            Node curr = parent;
            while (curr != null) {
                invokeChain.add(curr);
                curr = curr.parent;
            }
            for (int i = invokeChain.size() - 1; i >= 0; i--) {
                Node each = invokeChain.get(i);
                if (i != 0) {
                    System.out.print(each.getNodeName() + "->");
                } else {
                    System.out.print(each.getNodeName());
                }
            }
        } else {
            this.parent = parent;
        }
        System.out.println();
    }

    private Boolean hasLoopInvoke (Node parent) {
        Node curr = parent;
        while (curr != null) {
            if (this.getNodeName().equals(curr.getNodeName())) {
                return true;
            }
            curr = curr.parent;
        }
        return false;
    }
}
