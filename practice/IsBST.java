package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/9/17.
 */
public class IsBST extends TestCase {
    public boolean isBST(TreeNode root, int min, int max)
    {
        if(root == null) return true;
        if(root.val>max || root.val < min)  return false;
        return isBST(root.left,min,root.val-1)
                && isBST(root.right, root.val+1,max);
    }

    public void testIsBST()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        assertFalse(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(6);
        root1.right.left = new TreeNode(8);
        root1.right.right = new TreeNode(11);
        root1.left.left.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(12);
        assertTrue(isBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
