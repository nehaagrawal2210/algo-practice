package treePractice;

/**
 * Created by neha on 2/27/2017.
 */
public class TreeNode {
    int data;
    TreeNode lchild;
    TreeNode rchild;

    public TreeNode(int data) {
        this.data = data;
        this.lchild=null;
        this.rchild=null;
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
}
