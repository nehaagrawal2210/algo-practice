package practice;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neagrawa on 6/2/17.
 */
public class ConnectSiblings extends TestCase{
    class NextNode{
        int val;
        NextNode left;
        NextNode right;
        NextNode next;

        public NextNode(int val) {
            this.val = val;
        }

        @Override public String toString() {
            String res="Val= ";
            res+=val;
            if(left!=null) res+=", Left= "+left.val;
            if(right!=null) res+=", Right= "+right.val;
            if(next!=null) res+=", Next= "+next.val;
            return res;
        }
        
        public void traverse(NextNode root)
        {
            if(root == null) return;
            System.out.println(root.toString());
            traverse(root.left);
            traverse(root.right);
        }
    }
    
    public void connectSiblings(NextNode root)
    {
        Queue<NextNode> queue = new LinkedList<>();
        queue.add(root);
        NextNode temp;
        int size;
        while (!queue.isEmpty())
        {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if(!queue.isEmpty()) temp.next = queue.peek();
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
        }
        root.traverse(root);
    }
    
    public void testConnectSiblings()
    {
        NextNode root = new NextNode(1);
        root.left = new NextNode(2);
        root.right = new NextNode(3);
        root.left.left = new NextNode(4);
        root.left.right = new NextNode(5);
        root.right.left = new NextNode(6);
        root.right.right = new NextNode(7);
        root.left.left.right = new NextNode(8);
        root.right.right.right = new NextNode(9);
        connectSiblings(root);
    }
}
