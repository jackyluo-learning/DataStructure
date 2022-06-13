package Tree;

public class AVLTreeNode extends BinaryTreeNode{
    private Integer height;

    public AVLTreeNode(int value){
        super(value);
        this.height = 1;
    }

    public Integer getHeight(AVLTreeNode node) {
        return node == null?0:node.getHeight();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    private int maxHeight(AVLTreeNode left, AVLTreeNode right){
        return getHeight(left) > getHeight(right) ? getHeight(left) : getHeight(right);
    }

    private AVLTreeNode LLRotate(AVLTreeNode node){
        AVLTreeNode newRoot = (AVLTreeNode) node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);

        node.setHeight(maxHeight((AVLTreeNode)node.getLeft(), (AVLTreeNode) node.getRight())+1);
        newRoot.setHeight(maxHeight((AVLTreeNode) newRoot.left, (AVLTreeNode) newRoot.right)+1);
        return newRoot;
    }

    private AVLTreeNode RRRotate(AVLTreeNode node){
        AVLTreeNode newRoot = (AVLTreeNode) node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);

        node.setHeight(maxHeight((AVLTreeNode) node.left, (AVLTreeNode) node.right)+1);
        newRoot.setHeight(maxHeight((AVLTreeNode) newRoot.left, (AVLTreeNode) newRoot.right)+1);
        return newRoot;
    }

    private AVLTreeNode LRRotate(AVLTreeNode node){
        RRRotate((AVLTreeNode) node.getLeft());
        return LLRotate(node);
    }

    private AVLTreeNode RLRotate(AVLTreeNode node){
        LLRotate((AVLTreeNode) node.getRight());
        return RRRotate(node);
    }

    public AVLTreeNode insert(AVLTreeNode root, Integer value){
        if(root == null){
            root = new AVLTreeNode(value);
            return root;
        }
        return insertNode(root, value);
    }

    private AVLTreeNode insertNode(AVLTreeNode parent, Integer value){
        if(parent == null){
            return new AVLTreeNode(value);
        }

        if(value < (int)parent.getData()) {
            parent.setLeft(insertNode((AVLTreeNode) parent.getLeft(), value));
            if (getHeight((AVLTreeNode) parent.getLeft()) - getHeight((AVLTreeNode) parent.getRight()) >= 2) {
                Integer compareVa1 = (Integer) parent.getLeft().getData();
                if (value < compareVa1) {
                    parent = LLRotate(parent);
                } else {
                    parent = LRRotate(parent);
                }
            }
        }
        if(value > (int)parent.getData()){
            parent.setRight(insertNode((AVLTreeNode) parent.getRight(), value));
            if(getHeight((AVLTreeNode) parent.getRight())-getHeight((AVLTreeNode) parent.getLeft()) >= 2){
                Integer compareVal2 = (Integer) parent.getRight().getData();
                if(value > compareVal2){
                    parent = RRRotate(parent);
                }else{
                    parent = RLRotate(parent);
                }
            }
        }
        parent.setHeight(maxHeight((AVLTreeNode) parent.getLeft(), (AVLTreeNode) parent.getRight())+1);
        return parent;
    }

    public AVLTreeNode remove(AVLTreeNode root, Integer value){
        if(root == null){
            return null;
        }
        if(!BinarySearchTree.search(root, value)) return null;
        return removeNode(root, value);
    }

    private AVLTreeNode removeNode(AVLTreeNode parent, Integer value){
        if(value < (int)parent.getData()){
            AVLTreeNode newLeft = removeNode((AVLTreeNode) parent.getLeft(),value);
            parent.setLeft(newLeft);
            // 删除了左边，就用右边减左边
            if(getHeight((AVLTreeNode) parent.getRight())- getHeight((AVLTreeNode) parent.getLeft()) >= 2){
                AVLTreeNode tmpNode = (AVLTreeNode) parent.getLeft();
                if(getHeight((AVLTreeNode) tmpNode.getLeft())>getHeight((AVLTreeNode) tmpNode.getRight())){
                    RRRotate(parent);
                }else{
                    RLRotate(parent);
                }
            }
        }else if(value > (int)parent.getData()) {
            AVLTreeNode newRight = removeNode((AVLTreeNode) parent.getRight(), value);
            parent.setRight(newRight);
            // 删除了右边，就用左边减右边
            if (getHeight((AVLTreeNode) parent.getLeft()) - getHeight((AVLTreeNode) parent.getRight()) >= 2) {
                AVLTreeNode tmpNode = (AVLTreeNode) parent.getLeft();
                if (getHeight((AVLTreeNode) tmpNode.getLeft()) > getHeight((AVLTreeNode) tmpNode.getRight())) {
                    LLRotate(parent);
                } else {
                    LRRotate(parent);
                }
            }
        }else{
            if(parent.getLeft() != null && parent.getRight() != null){
                if(getHeight((AVLTreeNode) parent.getLeft())>getHeight((AVLTreeNode) parent.getRight())){
                    AVLTreeNode leftMax = getMax((AVLTreeNode) parent.getLeft());
                    parent.setLeft(removeNode((AVLTreeNode) parent.getLeft(), (int)parent.getLeft().getData()));
                    leftMax.setLeft(parent.getLeft());
                    leftMax.setRight(parent.getRight());
                    leftMax.setHeight(maxHeight((AVLTreeNode) leftMax.getLeft(), (AVLTreeNode) leftMax.getRight())+1);
                    parent = leftMax;
                }else{
                    AVLTreeNode rightMin = getMin((AVLTreeNode) parent.getRight());
                    parent.setRight(removeNode((AVLTreeNode) parent.getRight(), (int)parent.getRight().getData()));
                    rightMin.setLeft(parent.getLeft());
                    rightMin.setRight(parent.getRight());
                    rightMin.setHeight(maxHeight((AVLTreeNode) rightMin.getLeft(), (AVLTreeNode) rightMin.getRight())+1);
                    parent = rightMin;
                }
            }else{
                parent = (AVLTreeNode) (parent.getLeft() != null? parent.getLeft():parent.getRight());
            }
        }
        return parent;
    }

    private AVLTreeNode getMax(AVLTreeNode node){
        if(node.getRight() != null){
            return getMax((AVLTreeNode) node.getRight());
        }
        return node;
    }

    private AVLTreeNode getMin(AVLTreeNode node){
        if(node.getLeft() != null){
            return getMin((AVLTreeNode) node.getLeft());
        }
        return node;
    }

    public static void preOrder(AVLTreeNode node) {
        if (node != null) {
            System.out.println(node.data+", "+node.getHeight());
            if (node.left != null) {
                preOrder((AVLTreeNode) node.left);
            }
            if (node.right != null) {
                preOrder((AVLTreeNode) node.right);
            }
        }
    }
}
