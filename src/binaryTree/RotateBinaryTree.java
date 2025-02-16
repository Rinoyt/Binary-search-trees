package binaryTree;

import java.util.Collection;

public abstract class RotateBinaryTree extends AbstractBinaryTree {
    protected RotateBinaryTree() {
        super();
    }

    protected RotateBinaryTree(Collection<Integer> values) {
        super(values);
    }

    protected RotateBinaryTree(Integer[] values) {
        super(values);
    }

    protected RotateBinaryTree(int[] values) {
        super(values);
    }

    protected RotateBinaryTree(Node root) {
        super(root);
    }
    
    protected Node leftRotate(Node left, Node right) {
        left.setRight(right.getLeft());
        right.setLeft(left);
        return right;
    }

    protected Node rightRotate(Node left, Node right) {
        right.setLeft(left.getRight());
        left.setRight(right);
        return left;
    }
}
