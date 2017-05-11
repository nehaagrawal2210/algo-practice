package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class PrintAncestors extends TestCase {

    public static boolean printAncestors(TreeNode root,TreeNode target)
    {
        if(root==null)
            return false;
        if(root.getData()==target.getData())
            return true;
        if(printAncestors(root.getLchild(),target) || printAncestors(root.getRchild(),target))
        {
            System.out.print(root.getData()+" ");
            return true;
        }
        return false;
    }

    @Test
    public static void testPrintAncestors()
    {
        //create root
//                 1
//               /  \
//              2    3
//             / \
//            4  5
//           /
//          7

        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getLchild().getLchild().setLchild(new TreeNode(7));
        TreeNode target=new TreeNode(7);
        assertEquals(true,printAncestors(root,target));
    }

}
