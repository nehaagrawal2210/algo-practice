package practice;

public class BSTToMinHeap {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.preOrder(root);

        new BSTToMinHeap().convert(root);
        System.out.println();
        root.inorder(root);
    }

    private void convert(TreeNode root) {
        int nodes = countNodes(root);
        int[] pre = new int[nodes];
        inorder(root, pre, new Index());
        convert(root, pre, new Index());
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    private void inorder(TreeNode root, int[] pre, Index index) {
        if (root == null) {
            return;
        }
        inorder(root.left, pre, index);
        pre[index.index++] = root.val;
        inorder(root.right, pre, index);
    }

    private void convert(TreeNode root, int[] pre, Index index) {
        if (root == null) {
            return;
        }

        root.val = pre[index.index++];
        convert(root.left, pre, index);
        convert(root.right, pre, index);
    }

    class Index {
        int index = 0;
    }
}
