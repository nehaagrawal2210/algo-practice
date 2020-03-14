package practice;

public class LargestBST {

    static class Value {
        int maxSize = 0;
        boolean isBST = false;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(10);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(55);
        root.right.left.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        Value value = new Value();
        getLargest(root, value);
        System.out.println("Size = " + value.maxSize);
    }

    private static int getLargest(TreeNode root, Value value) {
        if (root == null) {
            value.isBST = true;
            value.maxSize = 0;
            return 0;
        }

        value.maxVal = Integer.MIN_VALUE;
        int lSize = getLargest(root.left, value);
        boolean left = false, right = false;
        if (value.isBST && root.val > value.maxVal) {
            left = true;
        }

        int min = value.minVal;
        value.minVal = Integer.MAX_VALUE;
        int rSize = getLargest(root.right, value);
        if (value.isBST && root.val < value.minVal) {
            right = true;
        }

        if (min < value.minVal) {
            value.minVal = min;
        }

        if (root.val > value.maxVal) {
            value.maxVal = root.val;
        }

        if (root.val < value.minVal) {
            value.minVal = root.val;
        }

        if (left && right) {
            if (lSize + rSize + 1 > value.maxSize) {
                value.maxSize = lSize + rSize + 1;
            }
            return lSize + rSize + 1;
        } else {
            value.isBST = false;
            return 0;
        }
    }
}
