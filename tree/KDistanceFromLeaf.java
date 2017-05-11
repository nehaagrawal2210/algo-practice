package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/9/2017.
 */
public class KDistanceFromLeaf extends TestCase{

    public void printKDistFromLeaf(TreeNode root,int[] path,boolean[] visited,int pathLen,int targetDist)
    {
        if(root==null)
            return;
        path[pathLen]=root.getData();
        visited[pathLen++]=false;

        //if a leaf is encountered print the ancestors
        if(root.getLchild()==null
                && root.getRchild()==null
                && pathLen-targetDist-1>=0
                && !visited[pathLen-targetDist-1])
        {
            System.out.print(path[pathLen-targetDist-1]+" ");
            visited[pathLen-targetDist-1]=true;
            return;
        }

        printKDistFromLeaf(root.getLchild(),path,visited,pathLen,targetDist);
        printKDistFromLeaf(root.getRchild(),path,visited,pathLen,targetDist);
    }

    @Test
    public void testPrintKDistFromLeaf()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /        / \
//          9       10   8
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
        root.getLchild().getLchild().setLchild(new TreeNode(9));
        root.getRchild().getRchild().setRchild(new TreeNode(8));
        root.getRchild().getRchild().setLchild(new TreeNode(10));

        int[] path=new int[100];
        boolean[] visited=new boolean[100];
        printKDistFromLeaf(root,path,visited,0,5);
        System.out.println();
        printKDistFromLeaf(root,path,visited,0,2);
        System.out.println();
        printKDistFromLeaf(root,path,visited,0,3);
    }

}
