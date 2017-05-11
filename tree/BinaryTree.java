package tree;

import java.util.LinkedList;

/**
 * Created by neha on 1/3/2017.
 */
public class BinaryTree {

    TreeNode root;

    public BinaryTree(int data)
    {
        root = new TreeNode(data);
    }

    public BinaryTree()
    {
        root = null;
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.lchild = new TreeNode(2);
        tree.root.rchild = new TreeNode(3);
        tree.root.lchild.lchild = new TreeNode(4);
        tree.root.lchild.rchild = new TreeNode(5);
        tree.root.rchild.lchild = new TreeNode(6);
        tree.root.rchild.rchild = new TreeNode(7);

        System.out.println("Inorder tree traversal recursive-------");
        tree.inorderTraverseRec(tree.root);
        System.out.println("\nPreorder tree traversal recursive-------");
        tree.preorderTraverseRec(tree.root);
        System.out.println("\nPostorder tree traversal-------");
        tree.postorderTraverseRec(tree.root);
        System.out.println("\nInorder tree traversal-------");
        tree.inorderTraverse(tree.root);
        System.out.println("\nPreorder tree traversal-------");
        tree.preorderTraverse(tree.root);
        System.out.println("\nPostorder tree traversal-------");
        tree.postorderTraverse(tree.root);

        System.out.println("\n--------- Printing Level Order-----------");
        tree.printLevelOrder(tree.root);

        System.out.println("\n--------- Printing Level Order less Complexity-----------");
        tree.printBFS(tree.root);

    }

    public void inorderTraverseRec(TreeNode treeNode)
    {
        if(treeNode == null)
            return;
        inorderTraverseRec(treeNode.lchild);
        System.out.print(treeNode.data+" ");
        inorderTraverseRec(treeNode.rchild);
    }

    public void preorderTraverseRec(TreeNode treeNode)
    {
        if(treeNode == null)
            return;
        System.out.print(treeNode.data+" ");
        preorderTraverseRec(treeNode.lchild);
        preorderTraverseRec(treeNode.rchild);
    }

    public void postorderTraverseRec(TreeNode treeNode)
    {
        if(treeNode == null)
            return;
        postorderTraverseRec(treeNode.lchild);
        postorderTraverseRec(treeNode.rchild);
        System.out.print(treeNode.data+" ");
    }

    public void inorderTraverse(TreeNode treeNode)
    {
        java.util.Stack<TreeNode> s = new java.util.Stack<TreeNode>();
        TreeNode temp = treeNode;
        while (temp!= null)
        {
            s.push(temp);
            temp = temp.lchild;
        }
        while (!s.isEmpty())
        {
            temp = s.pop();
            System.out.print(temp.data+" ");
            if(temp.rchild!=null)
            {
                temp = temp.rchild;
                while (temp!=null)
                {
                    s.push(temp);
                    temp = temp.lchild;
                }
            }
        }
    }

    public void preorderTraverse(TreeNode treeNode)
    {
        java.util.Stack<TreeNode> s = new java.util.Stack<TreeNode>();
        TreeNode temp;
        s.push(treeNode);
        while (!s.isEmpty())
        {
            temp = s.pop();
            System.out.print(temp.data+" ");
            if(temp.rchild!=null)
            s.push(temp.rchild);
            if(temp.lchild!=null )
            s.push(temp.lchild);
        }
    }

    public void postorderTraverse(TreeNode treeNode)
    {
        java.util.Stack<TreeNode> s = new java.util.Stack<TreeNode>();
        TreeNode temp;
        s.push(treeNode);
        while (!s.isEmpty())
        {
            temp = s.pop();
            System.out.print(temp.data+" ");
            if(temp.rchild!=null)
                s.push(temp.rchild);
            if(temp.lchild!=null )
                s.push(temp.lchild);
        }
    }

    public int computeHeight(TreeNode treeNode)
    {
        if(treeNode==null)
            return 0;
        else {
            int lheight = computeHeight(treeNode.lchild);
            int rheight = computeHeight(treeNode.rchild);

            if(lheight < rheight)
                return rheight+1;
            else
                return lheight+1;
        }
    }

    public void printGivenLevel(TreeNode treeNode,int level)
    {
        if(treeNode==null)
            return;
        if(level==1)
            System.out.print(treeNode.data+" ");
        else if(level > 1)
        {
            printGivenLevel(treeNode.lchild,level-1);
            printGivenLevel(treeNode.rchild,level-1);
        }
    }

    public void printLevelOrder(TreeNode treeNode)
    {
        int height = computeHeight(treeNode);
        for (int i=0;i<height;i++)
        {
            printGivenLevel(treeNode,i+1);
            System.out.println();
        }
    }

    public void printBFS(TreeNode treeNode)
    {
        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode temp = treeNode;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            queue.add(temp.lchild);
            queue.add(temp.rchild);
            temp = queue.poll();
        }
    }
}
