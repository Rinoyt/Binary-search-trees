package binaryTree;

public interface BinaryTree {
    Node getRoot();

    int height();

    int size();

    Node find(int value);

    void insert(Node node);

    void delete(Node node);
}
