package binaryTree;

public abstract class AbstractNode implements Node {
    private final int value;
    protected Node left = null;
    protected Node right = null;
    protected int height = 1;
    protected int size = 1;

    public AbstractNode(int value) {
        this.value = value;
    }

    public AbstractNode(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
        height += Math.max(left.getHeight(), right.getHeight());
        size += left.getSize() + right.getSize();
    }

    public AbstractNode(Node that) {
        this.value = that.getValue();
        this.left = that.getLeft();
        this.right = that.getRight();
        this.height = that.getHeight();
        this.size = that.getSize();
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
    }
}
