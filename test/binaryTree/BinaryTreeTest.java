package binaryTree;

import binaryTree.avlTree.AvlTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BinaryTreeTest {
    protected void insertTest(BinaryTree tree) {
        int[] rand = {4,8,5,2,3,1,9,7,6};
        insertAll(tree, rand);
        memberAll(tree, rand);
    }

    protected void insertThenDeleteTest(BinaryTree tree) {
        int[] asc  = {1,2,3,4,5,6,7,8,9};
        int[] desc = {9,8,7,6,5,4,3,2,1};
        int[] rand = {4,8,5,2,3,1,9,7,6};
        int[][] variants = {asc, desc, rand};

        for (int[] var : variants) {
            insertAll(tree, var);
            memberAll(tree, var);
            deleteAll(tree, var);
            assertEquals(0, tree.size(), "Failed on " + Arrays.toString(var));
        }
    }

    protected void insertAll(BinaryTree tree, int[] asc) {
        for (int elem : asc) {
            tree.insert(elem);
        }
    }

    protected void memberAll(BinaryTree tree, int[] asc) {
        for (int elem : asc) {
            assertNotNull(tree.find(elem),
                    "Element " + elem + " not found in " + Arrays.toString(asc));
        }
    }

    protected void deleteAll(BinaryTree tree, int[] asc) {
        for (int elem : asc) {
            tree.delete(elem);
        }
    }
}
