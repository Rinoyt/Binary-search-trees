package binaryTree;

import binaryTree.avlTree.AvlNode;

import java.util.Collection;

public abstract class AbstractBinaryTree implements BinaryTree {
    protected Node root = null;

    protected AbstractBinaryTree(Collection<Integer> values) {
        for (Integer val : values) {
            this.insert(val);
        }
    }

    protected AbstractBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public int height() {
        return root.getHeight();
    }

    @Override
    public int size() {
        return root.getSize();
    }

    @Override
    public Node find(int val) {
        Node cur = root;
        while (cur != null && cur.getValue() != val) {
            if (val < cur.getValue()) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }

        return cur;
    }
}
