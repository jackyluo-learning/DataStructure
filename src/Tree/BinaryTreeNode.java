package Tree;

public class BinaryTreeNode<T> {
    public BinaryTreeNode<T> left;

    public BinaryTreeNode<T> right;

    public T data;

    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T data) {
        this(null, null);
        this.data = data;
    }

    public BinaryTreeNode() {
    }

    public T getData() {
        return data;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void insertLeft(T value) {
        if (this.left == null) {
            setLeft(new BinaryTreeNode<T>(value));
        } else {
            BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value);
            newNode.left = this.left;
            this.left = newNode;
        }
    }

    public void insertRight(T value) {
        if (this.right == null) {
            setRight(new BinaryTreeNode<T>(value));
        } else {
            BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value);
            newNode.right = this.right;
            this.right = newNode;
        }
    }
}
