package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/3/2017.
 */
public class RootToLeafPathSum extends TestCase{

    public boolean getRootToLeafPathSum(TreeNode root,int pathSum,int targetSum)
    {
        if(root==null)
            return false;
        pathSum+=root.getData();
        if((root.lchild==null && root.rchild==null && pathSum==targetSum)
            || getRootToLeafPathSum(root.lchild,pathSum,targetSum) || getRootToLeafPathSum(root.rchild,pathSum,targetSum))
            return true;
         return false;
    }

    @Test
    public void testGetRootToLeafPathSum()
    {
//                10
//               /  \
//              8    2
//             / \  /
//            3  5 2

        TreeNode root=new TreeNode(10);
        root.setLchild(new TreeNode(8));
        root.setRchild(new TreeNode(2));
        root.getLchild().setLchild(new TreeNode(3));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(2));

        assertEquals(true,getRootToLeafPathSum(root,0,21));
        assertEquals(true,getRootToLeafPathSum(root,0,23));
        assertEquals(true,getRootToLeafPathSum(root,0,14));
        assertEquals(false,getRootToLeafPathSum(root,0,20));
    }
}
