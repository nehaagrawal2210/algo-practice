package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by neha on 2/2/2017.
 */
public class LevelOrderSpiral extends TestCase {
    public void getSpiralLevelOrder(TreeNode root)
    {
        if(root==null)
            return;
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();

        TreeNode temp=root;
        stack1.add(temp);
        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                temp=stack1.pop();
                System.out.print(temp.getData()+" ");
                if(temp.getRchild()!=null)
                    stack2.push(temp.getRchild());
                if(temp.getLchild()!=null)
                    stack2.push(temp.getLchild());
            }
            System.out.println();
           while (!stack2.isEmpty())
           {
               temp=stack2.pop();
               System.out.print(temp.getData()+" ");
               if(temp.getLchild()!=null)
                   stack1.push(temp.getLchild());
               if(temp.getRchild()!=null)
                   stack1.push(temp.getRchild());
           }
            System.out.println();
        }
    }

    @Test
    public void testGetSpiralLevelOrder()
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
        getSpiralLevelOrder(root);
    }
}
