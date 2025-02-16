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

        switch (node.rotate) {
            case LeftLeft -> {
                node.getLeft().setBlack();
                node.setRed();
                return rightRotate(node.getLeft(), node);
            }

            case LeftRight -> {
                node.getLeft().getRight().setBlack();
                node.setRed();
                return rightRotate(
                        leftRotate(
                                cur.getLeft(),
                                cur.getLeft().getRight()),
                        cur);
            }

            case RightRight -> {
                node.getRight().setBlack();
                node.setRed();
                return leftRotate(cur, cur.getRight());
            }

            case RightLeft -> {
                node.getRight().getLeft().setBlack();
                node.setRed();
                return leftRotate(
                        cur,
                        rightRotate(
                                cur.getRight().getLeft(),
                                cur.getRight()));
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
}
