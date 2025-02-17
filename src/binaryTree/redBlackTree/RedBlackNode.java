package binaryTree.redBlackTree;

import binaryTree.AbstractNode;
import binaryTree.Node;

public class RedBlackNode extends AbstractNode {
    public Rotation rotate = Rotation.NONE;

    private RedBlackNode parent = this;
    private NodeColor color = NodeColor.RED;

    protected RedBlackNode(int value) {
        super(value);
    }

    protected RedBlackNode(int value, RedBlackNode left, RedBlackNode right) {
        super(value, left, right);
    }

    protected RedBlackNode(Node that) {
        super(that);
    }

    @Override
    public RedBlackNode getLeft() {
        return (RedBlackNode) super.getLeft();
    }

    @Override
    public RedBlackNode getRight() {
        return (RedBlackNode) super.getRight();
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public boolean isRed() {
        return color == NodeColor.RED;
    }

    public void setRed() {
        this.color = NodeColor.RED;
    }

    public boolean isBlack() {
        return color == NodeColor.BLACK;
    }

    public void setBlack() {
        this.color = NodeColor.BLACK;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    @Override
    public void setLeft(Node left) {
        if (left == null) {
            super.setRight(null);
            return;
        }

        if (left instanceof RedBlackNode child) {
            child.setParent(this);
            super.setLeft(child);
        } else {
            throw new IllegalStateException("Child of a RedBlackNode must be a RedBlackNode");
        }
    }

    @Override
    public void setRight(Node right) {
        if (right == null) {
            super.setRight(null);
            return;
        }

        if (right instanceof RedBlackNode child) {
            child.setParent(this);
            super.setRight(child);
        } else {
            throw new IllegalStateException("Child of a RedBlackNode must be a RedBlackNode");
        }
    }
}
