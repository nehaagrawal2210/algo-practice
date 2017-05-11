package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/5/2017.
 */
public class LCABST extends TestCase{

    public static TreeNode getLCA(TreeNode root,TreeNode node1,TreeNode node2)
    {
        //find first node with data between node1 & node2
        if(root==null)
            return null;
        if(root.getData()>node2.getData() && root.getData()>node1.getData())
            return getLCA(root.getLchild(),node1,node2);
        if(root.getData()<node2.getData() && root.getData()<node1.getData())
            return getLCA(root.getRchild(),node1,node2);
        return root;
    }

    @Test
    public void testGetLCA()
    {
//                20
//               /  \
//              8    22
//             / \
//            4  12
//              /  \
//             10  14
        TreeNode root=new TreeNode(20);
        root.setLchild(new TreeNode(8));
        root.setRchild(new TreeNode(22));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(12));
        root.getLchild().getRchild().setLchild(new TreeNode(10));
        root.getLchild().getRchild().setRchild(new TreeNode(14));
        TreeNode r= getLCA(root,new TreeNode(10),new TreeNode(14));
        TreeNode r1= getLCA(root,new TreeNode(10),new TreeNode(22));
        TreeNode r2= getLCA(root,new TreeNode(14),new TreeNode(8));
        TreeNode r3= getLCA(root,new TreeNode(14),new TreeNode(8));
        System.out.println(r.getData());
        System.out.println(r1.getData());
        System.out.println(r2.getData());
//        assertEquals(12,(getLCA(root,new TreeNode(10),new TreeNode(14))).getData());
//        assertEquals(20,(getLCA(root,new TreeNode(10),new TreeNode(22))).getData());
//        assertEquals(8,(getLCA(root,new TreeNode(14),new TreeNode(8))).getData());
    }

    public static void main(String[] args)     {
//                20
//               /  \
//              8    22
//             / \
//            4  12
//              /  \
//             10  14
        TreeNode root=new TreeNode(20);
        root.setLchild(new TreeNode(8));
        root.setRchild(new TreeNode(22));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(12));
        root.getLchild().getRchild().setLchild(new TreeNode(10));
        root.getLchild().getRchild().setRchild(new TreeNode(14));
        TreeNode r= getLCA(root,new TreeNode(10),new TreeNode(14));
        TreeNode r1= getLCA(root,new TreeNode(10),new TreeNode(22));
        TreeNode r2= getLCA(root,new TreeNode(14),new TreeNode(8));
        TreeNode r3= getLCA(root,new TreeNode(17),new TreeNode(8));
        System.out.println(r.getData());
        System.out.println(r1.getData());
        System.out.println(r2.getData());
        System.out.println(r3);
    }
}
