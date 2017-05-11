package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by neha on 2/2/2017.
 */
public class TreeTraversal extends TestCase{

    public static void inorderRec(TreeNode root){
        if(root==null)
            return;
        inorderRec(root.getLchild());
        System.out.print(root.getData()+" ");
        inorderRec(root.getRchild());
    }

    public static void inorderItr(TreeNode root)
    {
        if(root==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while (current!=null)
        {
            stack.add(current);
            current=current.getLchild();
        }

        while (!stack.isEmpty())
        {
            current=stack.pop();
            System.out.print(current.getData()+" ");
            if(current.getRchild()!=null)
            {
                current=current.getRchild();
                while (current!=null)
                {
                    stack.add(current);
                    current=current.getLchild();
                }
            }

        }
    }
    public static void inorderMorris(TreeNode root)
    {
        TreeNode current=root,pre;
        while (current!=null)
        {
            if(current.getLchild()==null)
            {
                System.out.print(current.getData()+" ");
                current=current.getRchild();
            }
            else
            {
                pre=current.getLchild();
                while (pre.getRchild()!=null && pre.getRchild()!=current)
                    pre=pre.getRchild();
                if(pre.getRchild()==null)
                {
                    pre.setRchild(current);
                    current=current.getLchild();
                }
                else
                {
                    pre.setRchild(null);
                    System.out.print(current.getData()+" ");
                    current=current.getRchild();
                }
            }
        }
    }

    public static void postorderRec(TreeNode root)
    {
        if (root==null)
            return;
        postorderRec(root.getLchild());
        postorderRec(root.getRchild());
        System.out.print(root.getData()+" ");
    }

    public static void preorderRec(TreeNode root)
    {
        if(root==null)
            return;
        System.out.print(root.getData()+" ");
        preorderRec(root.getLchild());
        preorderRec(root.getRchild());
    }

    @Test
    public static void testTraversals()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
        inorderRec(root);
        System.out.println();
        inorderItr(root);
        System.out.println();
        inorderMorris(root);
        System.out.println();
        postorderRec(root);
        System.out.println();
        preorderRec(root);
    }
}
