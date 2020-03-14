package practice;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderToBST {

    public static void main(String[] args) {
        int[] a = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
        TreeNode bst = new LevelOrderToBST().convert(a);
        bst.preOrder(bst);
    }

    private TreeNode convert(int[] a) {
        Deque<TreeNodeDetails> dq = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(a[index++]);
        dq.add(new TreeNodeDetails(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (index < a.length) {

            TreeNodeDetails top = dq.poll();

            if (index < a.length && a[index] < top.node.val && a[index] > top.min) {
                TreeNode element = new TreeNode(a[index++]);
                TreeNodeDetails tnd = new TreeNodeDetails(element, top.min, top.node.val);
                top.node.left = element;
                dq.add(tnd);
            }

            if (index < a.length && a[index] > top.node.val && a[index] < top.max) {
                TreeNode element = new TreeNode(a[index++]);
                TreeNodeDetails tnd = new TreeNodeDetails(element, top.node.val, top.max);
                top.node.right = element;
                dq.add(tnd);
            }
        }
        return root;
    }

    class TreeNodeDetails {
        TreeNode node;
        int min;
        int max;

        public TreeNodeDetails(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

}
