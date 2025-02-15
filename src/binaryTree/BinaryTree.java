package binaryTree;

public interface BinaryTree {
    Node getRoot();

    int height();

    int size();

    Node find(int value);

    void insert(int value);

    void delete(int val);
}
