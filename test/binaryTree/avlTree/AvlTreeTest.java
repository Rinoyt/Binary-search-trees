package binaryTree.avlTree;

import binaryTree.BinaryTreeTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvlTreeTest extends BinaryTreeTest {
    @Test
    void insertTest() {
        int[] asc  = {1,2,3,4,5,6,7,8,9};
        int[] desc = {1,2,3,4,5,6,7,8,9};
        int[] rand = {4,8,5,2,3,1,9,7,6};
        int[][] variants = {asc, desc, rand};

        AvlTree tree = new AvlTree();
        for (int[] var : variants) {
            insertAll(tree, var);
            memberAll(tree, var);
            deleteAll(tree, var);
            assertEquals(0, tree.size());
        }
    }
}