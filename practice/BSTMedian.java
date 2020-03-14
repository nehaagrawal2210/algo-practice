package practice;

public class BSTMedian {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(20);
        tn.left = new TreeNode(8);
        tn.left.left = new TreeNode(4);
        tn.left.right = new TreeNode(12);
        tn.left.right.left = new TreeNode(10);
        tn.left.right.right = new TreeNode(14);
        tn.right = new TreeNode(22);
        tn.right.right = new TreeNode(24);

        System.out.println("findMedian(tn) = " + findMedian(tn));
    }

    private static double findMedian(TreeNode tn) {
        int nodes = countNodes(tn);
        int elementCount = -1;
        TreeNode pre = null, curr = null, left = null;
        while (tn != null) {
            if (tn.left == null) {
                pre = curr;
                curr = tn;
                elementCount++;
                tn = tn.right;
            }

            else {
                left = tn.left;
                while (left.right != null && left.right != tn) {
                    left = left.right;
                }

                if (left.right == null) {
                    left.right = tn;
                    tn = tn.left;
                } else {
                    // restore the tree
                    left.right = null;
                    pre = curr;
                    curr = tn;
                    elementCount++;
                    tn = tn.right;
                }
            }

            if (elementCount == nodes / 2) {
                break;
            }
        }

        if (nodes % 2 == 0) {
            return (pre.val + curr.val) / 2.0;
        }
        return pre.val;
    }

    private static int countNodes(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        return countNodes(tn.left) + countNodes(tn.right) + 1;
    }
}
