package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/3/2017.
 */
public class ConstructTreeWithInorderNPreOrder extends TestCase {

    TreeNode root;
    static int preIndex=0;

    public TreeNode constructTree(int inorder[],int preorder[],int inorderStart,int inorderEnd)
    {
        if(inorderStart>inorderEnd)
            return null;
        TreeNode temp = new TreeNode(preorder[preIndex++]);
        if(inorderStart==inorderEnd)
            return temp;
        int inorderIndex= search(inorder,inorderStart,inorderEnd,temp.data);
        temp.lchild=  constructTree(inorder,preorder,inorderStart,inorderIndex-1);
        temp.rchild=  constructTree(inorder,preorder,inorderIndex+1,inorderEnd);
        return temp;
    }

    public int search(int inorder[],int start,int end,int value)
    {
        int i;
        for (i = start; i <= end; i++) {
            if(inorder[i]==value)
                return i;
        }
        return i;
    }

    @Test
    public void testConstructTree()
    {
        ConstructTreeWithInorderNPreOrder tree = new ConstructTreeWithInorderNPreOrder();
        int in[] = new int[]{4,2,5,1,6,3,7 };
        int pre[] = new int[]{1,2,4,5,3,6,7 };
        int len = in.length;
        TreeNode root = constructTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        TreeTraversal.inorderItr(root);
    }
}
