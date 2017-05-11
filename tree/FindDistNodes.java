package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/9/2017.
 */
public class FindDistNodes extends TestCase{

    public static int findLevel(TreeNode root,int value,int level)
    {
        if(root==null)
            return -1;
        if(root.getData()==value)
            return level;
        int l= findLevel(root.getLchild(),value,level+1);
        return (l!=-1)?l:findLevel(root.getRchild(),value,level+1);
    }

    public static TreeNode getLCA(TreeNode root,int a1,int a2)
    {
        if(root==null)
            return null;
        if(root.getData()==a1 || root.getData()==a2)
            return root;
        TreeNode leftLCA=getLCA(root.getLchild(),a1,a2);
        TreeNode rightLCA=getLCA(root.getRchild(),a1,a2);

        if(leftLCA!=null && rightLCA!=null)
            return root;
        return (leftLCA!=null)?leftLCA:rightLCA;
    }

    public static int getDistance(TreeNode root,int a1,int a2)
    {
        int a1Dist=findLevel(root,a1,0); //O(n)
        int a2Dist=findLevel(root,a2,0); //O(n)

        if(a1Dist!=-1 && a2Dist!=-1)
        {
            TreeNode lca= getLCA(root,a1,a2); //O(n)
            int lcaDist=findLevel(root,lca.getData(),0); // O(n)

            return a1Dist+a2Dist-(2*lcaDist);
        }
        return -1;
    }

    @Test
    public void testGetLevel()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /          \
//          9            8
        TreeNode root1=new TreeNode(1);
        root1.setLchild(new TreeNode(2));
        root1.setRchild(new TreeNode(3));
        root1.getLchild().setLchild(new TreeNode(4));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(6));
        root1.getRchild().setRchild(new TreeNode(7));
        root1.getLchild().getLchild().setLchild(new TreeNode(9));
        root1.getRchild().getRchild().setRchild(new TreeNode(8));

        assertEquals(3,findLevel(root1,8,0));
        assertEquals(0,findLevel(root1,1,0));
        assertEquals(2,findLevel(root1,4,0));
    }

    @Test
    public void testGetLCA()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /          \
//          9            8
        TreeNode root1=new TreeNode(1);
        root1.setLchild(new TreeNode(2));
        root1.setRchild(new TreeNode(3));
        root1.getLchild().setLchild(new TreeNode(4));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(6));
        root1.getRchild().setRchild(new TreeNode(7));
        root1.getLchild().getLchild().setLchild(new TreeNode(9));
        root1.getRchild().getRchild().setRchild(new TreeNode(8));

        assertEquals(2,getLCA(root1,9,5).getData());
        assertEquals(7,getLCA(root1,7,8).getData());
        assertEquals(1,getLCA(root1,2,3).getData());
    }

    @Test
    public void testGetDistance()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /        / \
//          9        6   8
        TreeNode root1=new TreeNode(1);
        root1.setLchild(new TreeNode(2));
        root1.setRchild(new TreeNode(3));
        root1.getLchild().setLchild(new TreeNode(4));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(6));
        root1.getRchild().setRchild(new TreeNode(7));
        root1.getLchild().getLchild().setLchild(new TreeNode(9));
        root1.getRchild().getRchild().setRchild(new TreeNode(8));
        root1.getRchild().getRchild().setLchild(new TreeNode(10));

        assertEquals(2,getDistance(root1,4,5));
        assertEquals(4,getDistance(root1,9,3));
        assertEquals(5,getDistance(root1,5,10));
    }
}
