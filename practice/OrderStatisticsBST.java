package practice;

import java.util.Stack;

public class OrderStatisticsBST {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(20);
        tn.left = new TreeNode(8);
        tn.left.left = new TreeNode(4);
        tn.left.right = new TreeNode(12);
        tn.left.right.left = new TreeNode(10);
        tn.left.right.right = new TreeNode(14);
        tn.right = new TreeNode(22);

        System.out.println("kS = " + kSmallestInorder(tn, 9));
        System.out.println();
        // augmented DS
        RankedTreeNode rtn = new RankedTreeNode(20, 0);
        rtn.add(rtn, 8);
        rtn.add(rtn, 4);
        rtn.add(rtn, 12);
        rtn.add(rtn, 10);
        rtn.add(rtn, 14);
        rtn.add(rtn, 22);
        rtn.add(rtn, 21);
        rtn.add(rtn, 24);
        System.out.println("rtn.kSmallest(rtn,3) = " + rtn.kSmallest(rtn, 10));
    }

    private static int kSmallestInorder(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            if (curr == null && !stack.isEmpty()) {
                curr = stack.pop();
                count++;
                if (count == k) {
                    return curr.val;
                }
                curr = curr.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}

class RankedTreeNode {
    int val;
    RankedTreeNode left;
    RankedTreeNode right;
    int nodesInLeft;

    public RankedTreeNode(int val, int nodesInLeft) {
        this.nodesInLeft = nodesInLeft;
        this.val = val;
    }

    public RankedTreeNode add(RankedTreeNode rtn, int val) {
        if (rtn == null) {
            return new RankedTreeNode(val, 0);
        }

        if (val < rtn.val) {
            rtn.nodesInLeft++;
            rtn.left = add(rtn.left, val);
        } else {
            rtn.right = add(rtn.right, val);
        }
        return rtn;
    }

    public int kSmallest(RankedTreeNode rtn, int k) {
        if (k <= 0 || rtn == null) {
            return Integer.MIN_VALUE;
        }

        if (rtn.nodesInLeft + 1 == k) {
            return rtn.val;
        }

        if (k <= rtn.nodesInLeft) {
            return kSmallest(rtn.left, k);
        }

        return kSmallest(rtn.right, k - rtn.nodesInLeft-1);
    }
}
