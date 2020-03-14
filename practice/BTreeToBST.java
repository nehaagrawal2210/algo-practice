package practice;

import java.util.Arrays;

class Index {
    int index = 0;
}

public class BTreeToBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.inorder(root);
        new BTreeToBST().getInorder(root);
        System.out.println();
        root.inorder(root);
    }

    private void getInorder(TreeNode bTree) {
        int count = countNodes(bTree);
        int[] pre = new int[count];
        inorder(bTree, pre, new Index());
        Arrays.sort(pre);
        arrayToBST(bTree, pre, new Index());
    }

    private void arrayToBST(TreeNode root, int[] pre, Index index) {
        if(root == null) {
            return;
        }

        arrayToBST(root.left, pre, index);
        root.val = pre[index.index++];
        arrayToBST(root.right, pre, index);
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int countLeft = countNodes(root.left);
        int countRight = countNodes(root.right);
        return countLeft + countRight + 1;
    }

    private void inorder(TreeNode bTree, int[] pre, Index index) {
        if (bTree == null) {
            return;
        }

        inorder(bTree.left, pre, index);
        pre[index.index++] = bTree.val;
        inorder(bTree.right, pre, index);
    }
}
