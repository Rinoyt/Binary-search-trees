package binaryTree.avlTree;

import binaryTree.BinaryTreeTest;

import org.junit.jupiter.api.Test;

class AvlTreeTest extends BinaryTreeTest {
    @Test
    void insertTest() {
        insertTest(new AvlTree());
    }

    @Test
    void insertThenDeleteTest() {
        insertThenDeleteTest(new AvlTree());
    }
}