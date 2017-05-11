package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class ChildSumProperty extends TestCase{

    public boolean getChildSumProperty(TreeNode root)
    {
        int leftData=0,rightData=0;
        if(root==null || (root.getLchild()==null && root.getRchild()==null))
            return true;
        else
        {
            if (root.getLchild() != null)
                leftData = root.getLchild().getData();
            if (root.getRchild() != null)
                rightData = root.getRchild().getData();
            if (root.getData() == (leftData + rightData) &&
                    getChildSumProperty(root.getLchild()) && getChildSumProperty(root.getRchild()))
                return true;
        }
        return false;
    }

    @Test
    public void testGetChildSumProperty()
    {
//                10
//               /  \
//              2    8
//             /    / \
//            2    3   5
        TreeNode root=new TreeNode(10);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(8));
        root.getLchild().setLchild(new TreeNode(2));
        root.getRchild().setLchild(new TreeNode(3));
        root.getRchild().setRchild(new TreeNode(5));


//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
        TreeNode root1=new TreeNode(1);
        root1.setLchild(new TreeNode(2));
        root1.setRchild(new TreeNode(3));
        root1.getLchild().setLchild(new TreeNode(4));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(6));
        root1.getRchild().setRchild(new TreeNode(7));


        assertEquals(true,getChildSumProperty(root));
        assertEquals(false,getChildSumProperty(root1));
    }
}
