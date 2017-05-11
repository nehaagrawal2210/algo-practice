package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class ConvertToChildSumProperty extends TestCase {

    public void updateToChildSumProperty(TreeNode root)
    {
        int leftData=0,rightData=0,diff;
        if(root==null || (root.lchild==null && root.rchild==null))
            return;
        else {
            updateToChildSumProperty(root.lchild);
            updateToChildSumProperty(root.rchild);

            if(root.getLchild()!=null)
                leftData=root.getLchild().getData();
            if(root.getRchild()!=null)
                rightData=root.getRchild().getData();

            diff=(leftData+rightData)-root.data;
            if(diff>0)
                root.data+=diff;
            else if(diff<0)
                increment(root,-diff);
        }
    }

    public void increment(TreeNode root,int diff)
    {
        if(root.lchild!=null)
        {
            root.lchild.data+=diff;
            increment(root.lchild,diff);
        }
        else if(root.rchild!=null)
        {
            root.rchild.data+=diff;
            increment(root.rchild,diff);
        }
    }

    @Test
    public void testUpdateToChildSumProperty()
    {
//                50
//               /  \
//              7    2
//             / \  / \
//            3  5 1   30
        TreeNode root1=new TreeNode(50);
        root1.setLchild(new TreeNode(7));
        root1.setRchild(new TreeNode(2));
        root1.getLchild().setLchild(new TreeNode(3));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(1));
        root1.getRchild().setRchild(new TreeNode(30));

        updateToChildSumProperty(root1);
        TreeTraversal.inorderItr(root1);
    }
}
