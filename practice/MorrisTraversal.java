package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorrisTraversal {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(20);
        tn.left = new TreeNode(8);
        tn.left.left = new TreeNode(4);
        tn.left.right = new TreeNode(12);
        tn.left.right.left = new TreeNode(10);
        tn.left.right.right = new TreeNode(14);
        tn.right = new TreeNode(22);

        List<Integer> out = morris(tn);
        System.out.println(Arrays.toString(out.toArray()));
    }

    public static List<Integer> morris(TreeNode root) {
        TreeNode curr = root, pre;
        List<Integer> out = new ArrayList<>();
        while (curr != null) {
            if (curr.left == null) {
                out.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // revert back the tree to original
                    pre.right = null;
                    out.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return out;
    }
}
