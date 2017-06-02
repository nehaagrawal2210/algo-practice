package tree;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/2/17.
 */
public class MaxSumPathBwTwoLeaves extends TestCase {

    class Res{
        int val;

        public Res(int val) {
            this.val = val;
        }
    }

    public int getMaxSumPathBwLeaves(TreeNode root,Res res)
    {
        if(root ==null) return 0;
        if(root.getLchild()==null && root.getRchild()==null) //leaf encountered
        {
            return root.data;
        }

        int ls = getMaxSumPathBwLeaves(root.getLchild(),res);
        int rs = getMaxSumPathBwLeaves(root.getRchild(),res);

        res.val = Math.max(res.val, ls + rs + root.data);
        return Math.max(ls,rs)+root.data;
    }

    public void testGetMaxSumPath()
    {
        TreeNode root;
        root = new TreeNode(-15);
        root.lchild = new TreeNode(5);
        root.rchild = new TreeNode(6);
        root.lchild.lchild = new TreeNode(-8);
        root.lchild.rchild = new TreeNode(1);
        root.lchild.lchild.lchild = new TreeNode(2);
        root.lchild.lchild.rchild = new TreeNode(6);
        root.rchild.lchild = new TreeNode(3);
        root.rchild.rchild = new TreeNode(9);
        root.rchild.rchild.rchild = new TreeNode(0);
        root.rchild.rchild.rchild.lchild = new TreeNode(4);
        root.rchild.rchild.rchild.rchild = new TreeNode(-1);
        root.rchild.rchild.rchild.rchild.lchild = new TreeNode(10);
        Res res = new Res(Integer.MIN_VALUE);
        getMaxSumPathBwLeaves(root,res);
        System.out.println("Max pathSum of the given binary tree is "
                + res.val);
    }
}
