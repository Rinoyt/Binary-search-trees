package binaryTree;

import binaryTree.avlTree.AvlNode;

import java.util.Arrays;
import java.util.Collection;

public abstract class AbstractBinaryTree implements BinaryTree {
    protected Node root = null;

    protected AbstractBinaryTree() {
    }

    protected AbstractBinaryTree(Collection<Integer> values) {
        for (Integer val : values) {
            this.insert(val);
        }
    }

    protected AbstractBinaryTree(Integer[] values) {
        this(Arrays.asList(values));
    }

    protected AbstractBinaryTree(int[] values) {
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
        if (root == null) return 0;
        return root.getHeight();
    }

    @Override
    public int size() {
        if (root == null) return 0;
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
