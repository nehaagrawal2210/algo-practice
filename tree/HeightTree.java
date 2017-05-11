package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class HeightTree extends TestCase{

    public int getHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        int lheight=getHeight(root.getLchild());
        int rheight=getHeight(root.getRchild());
        return Math.max(lheight,rheight)+1;
    }

    @Test
    public void testGetHeight()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//                    /
//                   8
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
        root.getRchild().getRchild().setLchild(new TreeNode(8));
        assertEquals(4,getHeight(root));
    }
}
