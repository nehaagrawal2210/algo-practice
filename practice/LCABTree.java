package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/2/17.
 */
public class LCABTree extends TestCase{
    public TreeNode getLCA(TreeNode root, int n1, int n2)
    {
        if(root == null) return null;
        if(root.val == n1 || root.val == n2) return root;
        TreeNode leftLCA = getLCA(root.left, n1, n2);
        TreeNode rightLCA = getLCA(root.right, n1, n2);

        if(leftLCA!=null && rightLCA!=null) {
            return root;
        }
        return leftLCA!=null ? leftLCA : rightLCA;
    }

    public void testGetLCA()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(getLCA(root, 4, 5).toString());
        System.out.println(getLCA(root,4,6).toString());
        System.out.println(getLCA(root,3,4).toString());
        System.out.println(getLCA(root,2,4).toString());
    }
}
