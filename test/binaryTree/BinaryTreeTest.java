package binaryTree;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BinaryTreeTest {
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
