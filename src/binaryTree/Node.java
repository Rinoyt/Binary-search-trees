package binaryTree;

public interface Node {
    int getValue();

    Node getLeft();

    Node getRight();

    int getHeight();

    int getSize();

    void setLeft(Node left);

    void setRight(Node left);
}
