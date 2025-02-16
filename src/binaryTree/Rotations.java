package binaryTree;

public final class Rotations {
    public static Node leftRotate(Node left, Node right) {
        left.setRight(right.getLeft());
        right.setLeft(left);
        return right;
    }

    public static Node rightRotate(Node left, Node right) {
        right.setLeft(left.getRight());
        left.setRight(right);
        return left;
    }
}
