package binaryTree.avlTree;

import binaryTree.AbstractBinaryTree;
import binaryTree.Node;

import java.util.Collection;

public class AvlTree extends AbstractBinaryTree {
    public AvlTree(Collection<Integer> values) {
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
    public void delete(int val) {
        root = delete(root, val);
    }

    private static Node insert(Node cur, Node newNode) {
        if (cur == null) {
            return newNode;
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

    private static Node delete(Node cur, int val) {
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
            nextHead.setLeft(cur.getLeft());
            nextHead.setRight(delete(cur.getRight(), nextHead.getValue()));
            return balance(nextHead);
        }

        if (val < cur.getValue()) {
            cur.setLeft(delete(cur.getLeft(), val));
        } else {
            cur.setRight(delete(cur.getRight(), val));
        }

        return balance(cur);
    }

    private static Node balance(Node cur) {
        int balance = getBalance(cur);
        if (balance >= -1 && balance <= 1) {
            return cur;
        }

        if (balance > 1) {
            if (getBalance(cur.getLeft()) > 1) {
                return rightRotate(cur, cur.getLeft());
            } else {
                return rightRotate(
                        leftRotate(
                                cur.getLeft(),
                                cur.getLeft().getRight()),
                        cur);
            }
        } else {
            if (getBalance(cur.getRight()) > 1) {
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
