package tree;

/**
 * Created by neha on 1/3/2017.
 */
public class TreeNode {

    int data;
    TreeNode lchild;
    TreeNode rchild;

    public  TreeNode(int data)
    {
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLchild() {
        return lchild;
    }

    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;

        TreeNode treeNode = (TreeNode) o;

        return getData() == treeNode.getData();

    }

    @Override
    public int hashCode() {
        return getData();
    }
}
