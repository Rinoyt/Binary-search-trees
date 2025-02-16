package binaryTree.avlTree;

import binaryTree.AbstractBinaryTree;
import binaryTree.Node;

import java.util.Collection;

public class AvlTree extends AbstractBinaryTree {
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
        super(root);
    }

    @Override
    public void insert(int val) {
        root = insert(root, new AvlNode(val));
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

    private static Node leftRotate(Node left, Node right) {
        left.setRight(right.getLeft());
        right.setLeft(left);
        return right;
    }

    private static Node rightRotate(Node left, Node right) {
        right.setLeft(left.getRight());
        left.setRight(right);
        return left;
    }
}
