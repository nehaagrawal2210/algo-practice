package practice;

/**
 * Created by neagrawa on 5/29/17.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        String res = val + "";
        if (left != null) res += ", " + left.val;
        if (right != null) res += ", " + right.val;
        return res;
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + ", ");
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + ", ");
        inorder(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

}
