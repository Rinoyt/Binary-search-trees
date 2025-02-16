package binaryTree.avlTree;

import binaryTree.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AvlTreeTest {
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

    private void insertAll(BinaryTree tree, int[] asc) {
        for (int elem : asc) {
            tree.insert(elem);
        }
    }

    private void memberAll(BinaryTree tree, int[] asc) {
        for (int elem : asc) {
            assertNotNull(tree.find(elem),
                    "Element " + elem + " not found in " + Arrays.toString(asc));
        }
    }

    private void deleteAll(BinaryTree tree, int[] asc) {
        for (int elem : asc) {
            tree.delete(elem);
        }
    }
}