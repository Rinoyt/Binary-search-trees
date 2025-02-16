package binaryTree;

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

    @Override
    public void delete(int val) {
        root = delete(root, val);
    }

    protected Node insert(Node cur, Node newNode) {
        if (cur == null) {
            return balance(newNode);
        }

        if (cur.getValue() == newNode.getValue()) {
            return cur;
        }

        if (newNode.getValue() < cur.getValue()) {
            cur.setLeft(insert(cur.getLeft(), newNode));
        } else {
            cur.setRight(insert(cur.getRight(), newNode));
        }

        return balance(cur);
    }

    protected Node delete(Node cur, int val) {
        if (cur == null) {
            return null;
        }

        if (cur.getValue() == val) {
            if (cur.getLeft() == null && cur.getRight() == null) {
                return null;
            }

            if (cur.getLeft() == null) {
                return cur.getRight();
            }

            if (cur.getRight() == null) {
                return cur.getLeft();
            }

            Node nextHead = cur.getRight();
            while (nextHead.getLeft() != null) {
                nextHead = nextHead.getLeft();
            }
            nextHead.setRight(delete(cur.getRight(), nextHead.getValue()));
            nextHead.setLeft(cur.getLeft());
            return balance(nextHead);
        }

        if (val < cur.getValue()) {
            cur.setLeft(delete(cur.getLeft(), val));
        } else {
            cur.setRight(delete(cur.getRight(), val));
        }

        return balance(cur);
    }

    protected Node balance(Node cur) {
        return cur;
    }
}
