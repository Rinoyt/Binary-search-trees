package binaryTree;

public abstract class AbstractNode implements Node {
    private final int value;
    private Node left = null;
    private Node right = null;
    private int height = 1;
    private int size = 1;

    protected AbstractNode(int value) {
        this.value = value;
    }

    protected AbstractNode(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
        setHeight();
        setSize();
    }

    protected AbstractNode(Node that) {
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
        setHeight();
        setSize();
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
        setHeight();
        setSize();
    }

    private void setHeight() {
        int l = 0;
        if (left != null) {
            l = left.getHeight();
        }

        int r = 0;
        if (right != null) {
            r = right.getHeight();
        }

        height = 1 + Math.max(l, r);
    }

    private void setSize() {
        int l = 0;
        if (left != null) {
            l = left.getSize();
        }

        int r = 0;
        if (right != null) {
            r = right.getSize();
        }

        size = 1 + l + r;
    }
}
