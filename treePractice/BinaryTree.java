package treePractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by neha on 2/27/2017.
 */
public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root=null;
    }

    public void inorderTraversal(TreeNode root)
    {
        if(root==null)
            return;
        inorderTraversal(root.lchild);
        System.out.print(root.getData()+" ");
        inorderTraversal(root.rchild);
    }

    public void postorderTraversal(TreeNode root)
    {
        if(root==null)
            return;
        postorderTraversal(root.lchild);
        postorderTraversal(root.rchild);
        System.out.print(root.getData()+" ");
    }

    public void preorderTraversal(TreeNode root)
    {
        if(root==null)
            return;
        System.out.print(root.getData()+" ");
        preorderTraversal(root.lchild);
        preorderTraversal(root.rchild);
    }

    public int getHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        else {
            int lHeight= getHeight(root.lchild);
            int rHeight= getHeight(root.rchild);
            return Math.max(lHeight,rHeight)+1;
        }
    }

    public void printGivenLevel(TreeNode root,int level)
    {
        if(root==null) return;
        if(level==1)
        {
            System.out.print(root.getData()+" ");
            return;
        }
        else {
            printGivenLevel(root.lchild,level-1);
            printGivenLevel(root.rchild,level-1);
        }
    }

    public void levelOrderTraversal(TreeNode root)
    {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        TreeNode currentNode;
        while (!queue.isEmpty())
        {
            currentNode=queue.poll();
            System.out.print(currentNode.getData()+" ");
            if(currentNode.lchild!=null) queue.add(currentNode.lchild);
            if(currentNode.rchild!=null) queue.add(currentNode.rchild);
        }
    }

    public void levelOrderTraversalSeparatedByLevel(TreeNode root)
    {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        TreeNode currentNode;
        int currentSize;
        while (!queue.isEmpty())
        {
            currentSize=queue.size();
            while (currentSize>0)
            {
                currentNode=queue.poll();
                System.out.print(currentNode.getData()+" ");
                if(currentNode.lchild!=null) queue.add(currentNode.lchild);
                if(currentNode.rchild!=null) queue.add(currentNode.rchild);
                currentSize--;
            }
            System.out.print(" |***| ");
        }
    }

    class Height{
        int height;
        public Height()
        {
            this.height=0;
        }
    }

    public int getDiameter(TreeNode root)
    {
        Height height=new Height();
        return _getDiameter(root,height);
    }

    public int _getDiameter(TreeNode root,Height height)
    {
        Height lh=new Height(), rh=new Height();

        if(root==null) {
            height.height=0;
            return 0;
        }

        int ldiameter=_getDiameter(root.lchild,lh);
        int rdiameter=_getDiameter(root.rchild,rh);

        height.height=Math.max(lh.height,rh.height)+1;
        return Math.max(lh.height+rh.height+1,Math.max(ldiameter,rdiameter));
    }

    public void inorderTreeTraversalNonRecursive(TreeNode root)
    {
        if(root==null) return;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while (current!=null)
        {
            stack.push(current);
            current=current.getLchild();
        }
        while (!stack.isEmpty())
        {
            current= stack.pop();
            System.out.print(current.getData()+" ");
            if(current.rchild!=null)
            {
                current=current.getRchild();
                while (current!=null){
                    stack.push(current);
                    current=current.getLchild();
                }
            }
        }
    }

    //inorder traversal without stack using threaded binary tree
    public void morrisTraversal(TreeNode root)
    {
        TreeNode curr=root,pre;
        while (curr!=null)
        {
            if(curr.lchild==null)
            {
                System.out.print(curr.getData()+" ");
                curr=curr.rchild;
            }
            else {
                pre=curr.lchild;
                while (pre.rchild!=null && pre.rchild!=curr)
                pre=pre.rchild;

                if(pre.rchild==null)
                {
                    pre.rchild=curr;
                    curr=curr.lchild;
                }
                else {
                    pre.rchild=null;
                    System.out.print(curr.getData()+" ");
                    curr=curr.rchild;
                }
            }
        }
    }

    public boolean printAncestors(TreeNode root,int target)
    {
        if(root==null)
            return false;
        if(root.getData()==target) return true;
        else if(printAncestors(root.lchild,target) || printAncestors(root.rchild,target))
        {
            System.out.print(root.getData()+" ");
            return true;
        }
        return false;
    }

    public boolean isSubTree(TreeNode T,TreeNode S)
    {
        if(S==null) return true;
        if(T==null) return false;

        if(areIdentical(T,S)) return true;
        return isSubTree(T.lchild,S) || isSubTree(T.rchild,S);
    }

    public boolean areIdentical(TreeNode T, TreeNode S)
    {
        if((T==null) && (S==null)) return true;
        if((T==null) || (S==null)) return false;
        return (T.data==S.data && areIdentical(T.lchild,S.lchild) && areIdentical(T.rchild,S.rchild));
    }

    //works for complete tree
    public void connectNodesAtSameLevel(ConnectedNode root)
    {
        Queue<ConnectedNode> queue = new LinkedList<>();
        queue.add(root);
        ConnectedNode curr;
        int c;
        while (!queue.isEmpty())
        {
            c=queue.size();
            for (int i = 1; i <= c; i++) {
                curr=queue.poll();
                if(curr.lchild!=null) queue.add(curr.lchild);
                if(curr.rchild!=null) queue.add(curr.rchild);
                if(i==c) curr.nextRight=null;
                else {
                    curr.nextRight= queue.peek();
                }
            }
        }
    }

    public void printNextRight(ConnectedNode root)
    {
        Queue<ConnectedNode> queue = new LinkedList<>();
        queue.add(root);
        ConnectedNode curr;
        int c;
        while (!queue.isEmpty())
        {
            c=queue.size();
            while (c>0)
            {
                curr=queue.poll();
                System.out.print(" Data: "+curr.getData());
                if(curr.nextRight!=null) System.out.print(" Right: "+curr.nextRight.getData());
                else System.out.print(" Right: NULL");
                if(curr.lchild!=null) queue.add(curr.lchild);
                if(curr.rchild!=null) queue.add(curr.rchild);
                c--;
            }
            System.out.print(" |***| ");
        }
    }

    public int convertToSumTree(TreeNode root)
    {
        if(root==null) return 0;
        if(root.lchild==null && root.rchild==null) return root.getData();
        root.data= convertToSumTree(root.lchild)+convertToSumTree(root.rchild);
        return root.data;
    }
}
