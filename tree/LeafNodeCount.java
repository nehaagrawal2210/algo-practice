package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class LeafNodeCount extends TestCase {

    public int getLeafCount(TreeNode root)
    {
        if(root==null)
            return 0;
        if(root.getRchild()==null && root.getLchild()==null)
            return 1;
        return getLeafCount(root.getLchild())+getLeafCount(root.getRchild());
    }

    @Test
    public void testLeafCount()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//                    / \
//                   8   9
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
        root.getRchild().getRchild().setLchild(new TreeNode(8));
        root.getRchild().getRchild().setRchild(new TreeNode(9));
        assertEquals(5,getLeafCount(root));
    }
}
