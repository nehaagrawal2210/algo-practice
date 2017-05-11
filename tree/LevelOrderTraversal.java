package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neha on 2/2/2017.
 */
public class LevelOrderTraversal extends TestCase{

    TreeNode root;

    public LevelOrderTraversal()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
        root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
    }

    public void printGivenLevel(TreeNode root,int dist)
    {
        if(root==null)
            return;
        else if(dist==1)
        {
            System.out.print(root.getData()+" ");
            return;
        }
        else {
            printGivenLevel(root.getLchild(), dist - 1);
            printGivenLevel(root.getRchild(), dist - 1);
        }
    }
    
    public void printLevelOrder(TreeNode root)
    {
        int height=getHeight(root);
        for (int i = 1; i < height+1; i++) {
            printGivenLevel(root,i);
        }
    }

    public int getHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        int lheight=getHeight(root.getLchild());
        int rheight=getHeight(root.getRchild());
        if(lheight>rheight)
            return lheight+1;
        return rheight+1;
    }

    public void printLevelOrderQueue(TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode temp;
        queue.add(root);
        while (!queue.isEmpty())
        {
            temp=queue.poll();
            System.out.print(temp.getData()+" ");
            if(temp.getLchild()!=null)queue.add(temp.getLchild());
            if(temp.getRchild()!=null)queue.add(temp.getRchild());
        }
    }
    public void printLevelOrderQueueByLine(TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode temp;
        queue.add(root);
        int count;

        while (true)
        {
            count=queue.size();
            if(count==0)
                break;
            while (count!=0)
            {
                temp=queue.poll();
                System.out.print(temp.getData()+" ");
                count--;
                if(temp.getLchild()!=null)queue.add(temp.getLchild());
                if(temp.getRchild()!=null)queue.add(temp.getRchild());
            }
            System.out.println();
        }
    }


    //    @Test
    public void testGetHeight()
    {
        LevelOrderTraversal kDistNodes=new LevelOrderTraversal();
        assertEquals(3,kDistNodes.getHeight(kDistNodes.root));
    }

//    @Test
    public void testPrintGivenLevel()
    {
        LevelOrderTraversal kDistNodes=new LevelOrderTraversal();
//        kDistNodes.printGivenLevel(kDistNodes.root,2);
    }

    @Test
    public void testPrintLevelOrder()
    {
        LevelOrderTraversal kDistNodes=new LevelOrderTraversal();
        kDistNodes.printLevelOrder(kDistNodes.root);
    }

    @Test
    public void testPrintLevelOrderQueue()
    {
        System.out.println("\n------------------Level Order Queue--------------------------------");
        LevelOrderTraversal kDistNodes=new LevelOrderTraversal();
        kDistNodes.printLevelOrderQueueByLine(kDistNodes.root);
    }

}
