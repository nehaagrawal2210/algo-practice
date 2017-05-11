package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/9/2017.
 */
public class KDistanceFromNode extends TestCase{

    public void printChildNodesAtDist(TreeNode root,int dist)
    {
        if(dist==0)
            System.out.print(root.getData()+" ");
        //recur for left & right
        if(root.getLchild()!=null)printChildNodesAtDist(root.getLchild(),dist-1);
        if(root.getRchild()!=null)printChildNodesAtDist(root.getRchild(),dist-1);
    }

    public int printNodesKDist(TreeNode root,TreeNode targetNode,int targetDist)
    {
        if(root==null)
            return -1;
        if(targetDist<0)
            return -1;
        //print all the subtree nodes
        if(root.equals(targetNode))
        {
            printChildNodesAtDist(root,targetDist);
            return 0;
        }
        int dl=printNodesKDist(root.getLchild(),targetNode,targetDist);
        if(dl!=-1) //target in left subtree of root
        {
            if(dl+1==targetDist)
            System.out.print(root.getData()+" ");
            else
                printChildNodesAtDist(root.getRchild(),targetDist-dl-2);
            return dl+1;
        }
        int dr=printNodesKDist(root.getLchild(),targetNode,targetDist);
        if(dr!=-1) //target in right subtree
        {
            if(dr+1==targetDist)
                System.out.print(root.getData()+" ");
            else
                printChildNodesAtDist(root.getLchild(),targetDist-dr-2);
            return dr+1;
        }
        return -1; //target not present
    }

    @Test
    public void testPrintChildNodesAtDist()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /          \
//          9            8
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
        root.getLchild().getLchild().setLchild(new TreeNode(9));
        root.getRchild().getRchild().setRchild(new TreeNode(8));

        printChildNodesAtDist(root,3);
    }

    @Test
    public void testPrintNodesKDist()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /          \
//          9            8
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
        root.getLchild().getLchild().setLchild(new TreeNode(9));
        root.getRchild().getRchild().setRchild(new TreeNode(8));

        printNodesKDist(root,new TreeNode(4),2);
        System.out.println();
        printNodesKDist(root,new TreeNode(4),4);
        assertEquals(2,printNodesKDist(root,new TreeNode(4),7));
        assertEquals(-1,printNodesKDist(root,new TreeNode(10),7));
    }
}
