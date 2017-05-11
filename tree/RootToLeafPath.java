package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class RootToLeafPath extends TestCase {

    public void printPath(TreeNode root,int path[],int pathLen)
    {
        if(root==null)
            return;
        path[pathLen++]=root.getData();
        if(root.getLchild()==null && root.getRchild()==null)
        {
            //calc sum here
            for (int i = 0; i < pathLen; i++) {
                System.out.print(path[i]+" ");
            }
            System.out.println();
        }
        printPath(root.getLchild(),path,pathLen);
        printPath(root.getRchild(),path,pathLen);
    }

    @Test
    public void testPrintPath()
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
        int[] path=new int[1000];
        printPath(root,path,0);
    }
}
