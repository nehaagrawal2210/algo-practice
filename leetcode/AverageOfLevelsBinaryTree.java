import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-40/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsBinaryTree extends TestCase {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> average = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            average.add(sum / size);
        }
        return average;
    }

    public void testAverageOfLevels() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<Double> expected = new ArrayList<>();
        expected.add(3d);
        expected.add(14.5);
        expected.add(11d);
        List<Double> actual = averageOfLevels(treeNode);
        Assert.assertEquals(expected, actual);
    }
}
