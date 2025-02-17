package binaryTree.redBlackTree;

import binaryTree.BinaryTreeTest;

import binaryTree.avlTree.AvlTree;
import org.junit.jupiter.api.Test;

class RedBlackTreeTest extends BinaryTreeTest {
    @Test
    void insertTest() {
        insertTest(new AvlTree());
    }

    @Test
    void insertThenDeleteTest() {
        insertThenDeleteTest(new RedBlackTree());
    }
}