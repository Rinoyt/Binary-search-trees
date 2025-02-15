package binaryTree;

public interface BinaryTree {
    Node getRoot();

    Node find(int value);

    void insert(Node node);

    void delete(Node node);
}
