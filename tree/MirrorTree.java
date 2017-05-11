package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class MirrorTree extends TestCase {

    public static void makeMirrorTree(TreeNode root)
    {
        if(root==null)
            return;
        makeMirrorTree(root.getLchild());
        makeMirrorTree(root.getRchild());
        //swap left & right sub
        TreeNode treeNode=root.getLchild();
        root.setLchild(root.getRchild());
        root.setRchild(treeNode);
    }

    public static TreeNode makeMirrorTreeOrg(TreeNode root)
    {
        if(root==null)
            return root;
        TreeNode rootCopy= new TreeNode(root.getData());
        rootCopy.rchild=makeMirrorTreeOrg(root.lchild);
        rootCopy.lchild=makeMirrorTreeOrg(root.rchild);
        return rootCopy;
    }

    @Test
    public void testMirrorTree()
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
        TreeTraversal.inorderItr(root);
        TreeNode mirrorRoot= makeMirrorTreeOrg(root);
        System.out.println("\n------------------------------------------");
        makeMirrorTree(root);
        TreeTraversal.inorderItr(root);
        System.out.println("\n------------------------------------------");
        TreeTraversal.inorderItr(mirrorRoot);
    }
}
