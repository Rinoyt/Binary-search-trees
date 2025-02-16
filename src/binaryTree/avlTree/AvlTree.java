package binaryTree.avlTree;

import binaryTree.AbstractBinaryTree;
import binaryTree.Node;
import binaryTree.RotateBinaryTree;

import java.util.Collection;

public class AvlTree extends RotateBinaryTree {
    public AvlTree() {
        super();
    }

    public AvlTree(Collection<Integer> values) {
        super(values);
    }

    public AvlTree(Integer[] values) {
        super(values);
    }

    public AvlTree(int[] values) {
        super(values);
    }

    public AvlTree(Node root) {
        super(new AvlNode(root));
    }

    @Override
    public void insert(int value) {
        root = insert(root, new AvlNode(value));
    }

    @Override
    protected Node balance(Node cur) {
        int balance = getBalance(cur);
        if (balance >= -1 && balance <= 1) {
            return cur;
        }

        if (balance > 1) {
            if (getBalance(cur.getLeft()) >= 0) {
                return rightRotate(cur.getLeft(), cur);
            } else {
                return rightRotate(
                        leftRotate(
                                cur.getLeft(),
                                cur.getLeft().getRight()),
                        cur);
            }
        } else {
            if (getBalance(cur.getRight()) >= 1) {
                return leftRotate(
                        cur,
                        rightRotate(
                                cur.getRight().getLeft(),
                                cur.getRight()));
            } else {
                return leftRotate(cur, cur.getRight());
            }
        }
    }

    private static int getBalance(Node cur) {
        int l = 0;
        if (cur.getLeft() != null) {
            l = cur.getLeft().getHeight();
        }

        int r = 0;
        if (cur.getRight() != null) {
            r = cur.getRight().getHeight();
        }

        return l - r;
    }
}
