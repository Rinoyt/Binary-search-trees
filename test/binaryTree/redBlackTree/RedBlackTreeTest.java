package binaryTree.redBlackTree;

import binaryTree.BinaryTreeTest;

import org.junit.jupiter.api.Test;

class RedBlackTreeTest extends BinaryTreeTest  {
    @Test
    void insertThenDeleteTest() {
        insertThenDeleteTest(new RedBlackTree());
    }
}