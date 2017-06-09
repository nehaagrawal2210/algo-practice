package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/2/17.
 */
public class ConvertToTree extends TestCase {
    int preIndex = 0;
    int postIndex;
    public TreeNode convertTreeFromPre(int[] pre, int[] inorder, int inStart, int inEnd)
    {
        if(inStart>inEnd) return null;
        int val = pre[preIndex++];
        TreeNode node  = new TreeNode(val);
        if(inStart == inEnd) return node;
        int index = search(inorder,inStart,inEnd,node.val);
        node.left = convertTreeFromPre(pre,inorder,inStart,index-1);
        node.right = convertTreeFromPre(pre,inorder,index+1, inEnd);
        return node;
    }

    public int search(int[] inorder, int inStart, int inEnd, int key)
    {
        int i;
        for (i = inStart; i <= inEnd ; i++) {
            if(inorder[i] == key) return i;
        }
        return i;
    }

    public TreeNode convertTreeFromPost(int[] post, int[] inorder, int instart, int inend)
    {
        if(instart>inend) return null;
        TreeNode node = new TreeNode(post[postIndex--]);
        if(instart == inend) return node;
        int index = search(inorder,instart,inend,node.val);
        node.right = convertTreeFromPost(post,inorder,index+1,inend);
        node.left = convertTreeFromPost(post,inorder,instart,index-1);
        return node;
    }

    public void testConvertTree()
    {
        int[] in = {1,2,3,4,5,6};
        int[] pre= {4,2,1,3,6,5};
        int[] post = {1,3,2,5,6,4};

        postIndex = post.length-1;
        TreeNode node = convertTreeFromPre(pre,in,0,in.length-1);
        TreeNode node1 = convertTreeFromPost(post,in,0,in.length-1);
        node.inorder(node);
        System.out.println();
        node.preOrder(node);

        System.out.println("\nTraversals");
        node1.inorder(node1);
        System.out.println();
        node1.postOrder(node1);
    }
}
