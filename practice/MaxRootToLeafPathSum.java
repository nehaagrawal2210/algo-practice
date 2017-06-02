package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/1/17.
 */
public class MaxRootToLeafPathSum extends TestCase{
    class Max{
        int max;
    }
    public void getMaxSum(TreeNode root, int pathSum, Max sum)
    {
        if(root==null) return;
        pathSum+=root.val;
        if(root.left == null && root.right==null)
        {
            if(pathSum>sum.max) sum.max=pathSum;
            return;
        }
        getMaxSum(root.left,pathSum,sum);
        getMaxSum(root.right,pathSum,sum);
    }

    public int getMaxSum(TreeNode root)
    {
        Max maxSum = new Max();
        maxSum.max=Integer.MIN_VALUE;
        getMaxSum(root,0,maxSum);
        return maxSum.max;
    }


    public void testGetMaxSum()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        System.out.println(getMaxSum(root));
    }
}
