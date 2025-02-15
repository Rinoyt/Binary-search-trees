package binaryTree.avlTree;

import binaryTree.AbstractNode;
import binaryTree.Node;

public class AvlNode extends AbstractNode {
    public AvlNode(int value) {
        super(value);
    }

    public AvlNode(int value, AvlNode left, AvlNode right) {
        super(value, left, right);
    }

    public AvlNode(Node node) {
        super(node);
    }

    @Override
    public AvlNode getLeft() {
        return (AvlNode) super.getLeft();
    }

    @Override
    public AvlNode getRight() {
        return (AvlNode) super.getRight();
    }
}
