package BinarySearchTree;

import tree.TreeNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 3/9/2017.
 */
public class BstTester extends TestCase {

    public Bst getTree()
    {
//             10
//           /   \
//          8    12
//         / \  /  \
//        6  9 11   20
        Bst tree = new Bst();
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);
        tree.insert(6);
        tree.insert(9);
        tree.insert(11);
        tree.insert(20);
        return tree;
    }

    @Test
    public void testInsert()
    {
//             10
//           /   \
//          8    12
//         / \  /  \
//        6  9 11   20
        Bst tree = getTree();
        tree.inorderTraverse();
    }

    @Test
    public void testSearch()
    {
//             10
//           /   \
//          8    12
//         / \  /  \
//        6  9 11   20
        Bst tree = getTree();
        assertTrue(tree.search(20));
        assertTrue(tree.search(9));
        assertTrue(tree.search(8));
        assertFalse(tree.search(30));
    }

    @Test
    public void testDelete()
    {
        Bst tree = getTree();
        tree.inorderTraverse();
        tree.delete(11);
        tree.inorderTraverse();
        tree.delete(8);
        tree.inorderTraverse();
        tree.delete(10);
        tree.inorderTraverse();
    }
}
