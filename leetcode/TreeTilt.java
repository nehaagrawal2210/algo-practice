package leetcode;

/**
 * Created by neagrawa on 4/23/17.
 */

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Definition for a binary tree node.
 *
 */
/*public class Solution {
}*/
public class TreeTilt extends TestCase{

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public class TiltValue{
        int tilt;
  }

    public int findTilt(TreeNode root) {
        TiltValue val= new TiltValue();
        getTilt(root,root,val);
        return val.tilt;
    }

    public int getTilt(TreeNode root, TreeNode head, TiltValue tiltValue)
    {
        if(root == null) return 0;
        else{
            int lSum = getTilt(root.left,head,tiltValue);
            int rSum = getTilt(root.right,head,tiltValue);
            tiltValue.tilt = tiltValue.tilt + Math.abs(lSum - rSum);
            return lSum+rSum+root.val;
        }
    }

    @Test
    public void testGetTilt()
    {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        assertEquals(1,findTilt(treeNode));
    }
}
