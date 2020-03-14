package practice;

import java.util.Stack;

//https://www.geeksforgeeks.org/count-pairs-from-two-bsts-whose-sum-is-equal-to-a-given-value-x/
public class BSTSumToX {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(5);
        tn.left = new TreeNode(3);
        tn.left.left = new TreeNode(2);
        tn.left.right = new TreeNode(4);
        tn.right = new TreeNode(7);
        tn.right.left = new TreeNode(6);
        tn.right.right = new TreeNode(8);

        TreeNode tn1 = new TreeNode(10);
        tn1.left = new TreeNode(6);
        tn1.left.left = new TreeNode(3);
        tn1.left.right = new TreeNode(8);
        tn1.right = new TreeNode(15);
        tn1.right.left = new TreeNode(11);
        tn1.right.right = new TreeNode(18);

        System.out.println("countPairsSumToX(tn,tn1,16) = " + countPairsSumToX(tn, tn1, 16));
    }

    private static int countPairsSumToX(TreeNode t1, TreeNode t2, int x) {
        if (t1 == null || t2 == null) {
            return 0;
        }
        Stack<TreeNode> inc = new Stack<>();
        Stack<TreeNode> dec = new Stack<>();
        TreeNode curr1 = t1, curr2 = t2;
        TreeNode top1, top2;
        int count = 0;
        while (true) {
            while (curr1 != null) {
                inc.push(curr1);
                curr1 = curr1.left;
            }

            while (curr2 != null) {
                dec.push(curr2);
                curr2 = curr2.right;
            }

            if (inc.isEmpty() || dec.isEmpty()) {
                break;
            }

            top1 = inc.peek();
            top2 = dec.peek();
            if (top1.val + top2.val == x) {
                count++;
                inc.pop();
                dec.pop();
                curr1 = top1.right;
                curr2 = top2.left;
            } else if (top1.val + top2.val < x) {
                inc.pop();
                curr1 = top1.right;
            } else {
                dec.pop();
                curr2 = top2.left;
            }

        }

        return count;
    }
}
