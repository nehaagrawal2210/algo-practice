package BinarySearchTree;

import tree.TreeNode;

/**
 * Created by neha on 3/9/2017.
 */
public class Bst {
    TreeNode root;

    public Bst() {
        root = null;
    }

    public TreeNode insert(TreeNode treeNode, int key)
    {
        if(treeNode == null) {
            treeNode = new TreeNode(key);
            return treeNode;
        }
        if(key<= treeNode.getData())
            treeNode.setLchild(insert(treeNode.getLchild(),key));
        else treeNode.setRchild(insert(treeNode.getRchild(),key));
        return treeNode;
    }

    public void insert(int key)
    {
       root = insert(this.root,key);
    }

    public boolean search(TreeNode root, int key)
    {
        if(root==null)
            return false;
        if(root.getData()==key)
            return true;
        if(key<root.getData())
            return search(root.getLchild(),key);
        else return search(root.getRchild(),key);
    }

    public boolean search(int key)
    {
        return search(this.root,key);
    }

    public void inorderTraverse(TreeNode root)
    {
        if(root == null) return;
        inorderTraverse(root.getLchild());
        System.out.print(root.getData()+" ");
        inorderTraverse(root.getRchild());
    }

    public void inorderTraverse()
    {
        inorderTraverse(this.root);
        System.out.println();
    }

    public TreeNode delete(TreeNode root, int key)
    {
        if(root == null) return root;
        if(key<root.getData())
            root.setLchild(delete(root.getLchild(),key));
        else if(key>root.getData())
            root.setRchild(delete(root.getRchild(),key));
        else{
            //delete this node
            if(root.getLchild()==null)
                return root.getRchild();
            if(root.getRchild() == null)
                return root.getLchild();

            //node with 2 children
            root.setData(getMinValue(root.getRchild()));
            root.setRchild(delete(root.getRchild(),root.getData()));
        }
        return root;
    }

    public void delete(int key)
    {
        delete(this.root,key);
    }

    public int getMinValue(TreeNode root)
    {
        TreeNode temp = root;
        while (temp.getLchild()!=null)
        {
            temp = temp.getLchild();
        }
        return temp.getData();
    }
}
