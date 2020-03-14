package practice;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = new SortedArrayToBalancedBST().getTree(a, 0, a.length - 1);
        root.preOrder(root);
    }

    public TreeNode getTree(int[] a, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = getTree(a, low, mid - 1);
        root.right = getTree(a, mid + 1, high);
        return root;
    }
}
