package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/3/2017.
 */
public class TreeDiameter extends TestCase{

    class Height{
        int height;
    }

    public int getDiameter(TreeNode root)
    {
        if(root==null)
            return 0;
        int lheight=getHeight(root.lchild);
        int rheight=getHeight(root.rchild);

        int ldiameter=getDiameter(root.lchild);
        int rdiameter=getDiameter(root.rchild);

        return Math.max(Math.max(ldiameter,rdiameter),lheight+rheight+1);
    }

    public int getHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        return Math.max(getHeight(root.lchild),getHeight(root.rchild))+1;
    }

    public int getDiameter(TreeNode root, Height height)
    {
        Height lh= new Height(),rh= new Height();
        if(root==null)
        {
            height.height=0;
            return 0;
        }
        int ldiameter= getDiameter(root.lchild,lh);
        int rdiameter= getDiameter(root.rchild,rh);

        height.height= Math.max(lh.height,rh.height)+1;

        //now lh and rh have the heights
        return Math.max(Math.max(ldiameter,rdiameter),lh.height+rh.height+1);
    }

    @Test
    public void testGetDiameter()
    {
//                 1
//               /  \
//              2    3
//             / \
//            4  5
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        int dia=getDiameter(root);
        assertEquals(4,dia);
        assertEquals(4,getDiameter(root,new Height()));
    }
}
