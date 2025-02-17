package binaryTree.redBlackTree;

import binaryTree.AbstractBinaryTree;
import binaryTree.Node;

import static binaryTree.Rotations.leftRotate;
import static binaryTree.Rotations.rightRotate;

import java.util.Collection;

public class RedBlackTree extends AbstractBinaryTree {
    public RedBlackTree() {
        super();
    }

    public RedBlackTree(Collection<Integer> values) {
        super(values);
    }

    public RedBlackTree(Integer[] values) {
        super(values);
    }

    public RedBlackTree(int[] values) {
        super(values);
    }

    public RedBlackTree(Node root) {
        super(new RedBlackNode(root));
    }
    
    @Override
    public void insert(int value) {
        root = insert(root, new RedBlackNode(value));
    }

    @Override
    protected Node balance(Node cur) {
        if (!(cur instanceof RedBlackNode node)) {
            throw new IllegalStateException("A Node isn't a RedBlackNode in a Red Black Tree");
        }

        Rotation rotate = node.rotate;
        node.rotate = Rotation.NONE;
        switch (rotate) {
            case LeftLeft -> {
                node.getLeft().setBlack();
                node.setRed();
                return balance(rightRotate(node.getLeft(), node));
            }

            case LeftRight -> {
                node.getLeft().getRight().setBlack();
                node.setRed();
                return balance(
                        rightRotate(
                                leftRotate(
                                        cur.getLeft(),
                                        cur.getLeft().getRight()),
                                cur));
            }

            case RightRight -> {
                node.getRight().setBlack();
                node.setRed();
                return balance(leftRotate(cur, cur.getRight()));
            }

            case RightLeft -> {
                node.getRight().getLeft().setBlack();
                node.setRed();
                return balance(
                        leftRotate(
                                cur,
                                rightRotate(
                                        cur.getRight().getLeft(),
                                        cur.getRight())));
            }

            case NONE -> {
                // continue
            }
        }

        RedBlackNode parent = node.getParent();

        if (parent == node) {
            node.setBlack();
            return node;
        }

        if (node.isBlack() || parent.isBlack()) {
            return node;
        }

        RedBlackNode grandParent = parent.getParent();
        RedBlackNode uncle;
        if (grandParent.getLeft() != parent) {
            uncle = grandParent.getLeft();
        } else {
            uncle = grandParent.getRight();
        }

        if (uncle.isRed()) {
            parent.setBlack();
            uncle.setBlack();
            grandParent.setRed();
            return node;
        }

        // uncle is Black
        if (grandParent.getLeft() == parent && parent.getLeft() == node) {
            grandParent.rotate = Rotation.LeftLeft;
        } else if (grandParent.getLeft() == parent && parent.getRight() == node) {
            grandParent.rotate = Rotation.LeftRight;
        } else if (grandParent.getRight() == parent && parent.getRight() == node) {
            grandParent.rotate = Rotation.RightRight;
        } else {
            grandParent.rotate = Rotation.RightLeft;
        }

        return node;
    }

    @Override
    protected Node delete(Node cur, int val) {
        if (cur == null) {
            return null;
        }

        if (cur.getValue() == val) {
            if (cur.getLeft() == null && cur.getRight() == null) {
                RedBlackNode child = new RedBlackNode(-1);
                child.setBlack();
                balanceOnDelete(cur, child);
                return null;
            }

            if (cur.getLeft() == null) {
                return balanceOnDelete(cur, cur.getRight());
            }

            if (cur.getRight() == null) {
                return balanceOnDelete(cur, cur.getLeft());
            }

            Node nextHead = cur.getRight();
            while (nextHead.getLeft() != null) {
                nextHead = nextHead.getLeft();
            }
            nextHead.setRight(delete(cur.getRight(), nextHead.getValue()));
            nextHead.setLeft(cur.getLeft());
            return nextHead;
        }

        if (val < cur.getValue()) {
            cur.setLeft(delete(cur.getLeft(), val));
        } else {
            cur.setRight(delete(cur.getRight(), val));
        }

        return cur;
    }

    private Node balanceOnDelete(Node cur, Node next) {
        if (!(cur instanceof RedBlackNode deleted) || !(next instanceof RedBlackNode child)) {
            throw new IllegalStateException("A Node isn't a RedBlackNode in a Red Black Tree");
        }

        if (deleted.isRed() || child.isRed()) {
            child.setBlack();
            return child;
        }

        // double black
        // TODO: write deletion for Red-Black tree
        throw new UnsupportedOperationException("Deleting a RedBlackNode is unsupported");
    }
}
