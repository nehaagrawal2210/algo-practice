package leetcode;

import apple.laf.JRSUIUtils;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neagrawa on 5/7/17.
 */
public class Subtree extends TestCase {
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

         public TreeNode getLeft() {
             return left;
         }

         public void setLeft(TreeNode left) {
             this.left = left;
         }

         public TreeNode getRight() {
             return right;
         }

         public void setRight(TreeNode right) {
             this.right = right;
         }
     }

      //check if t is subtree of s
    public boolean isSubtree(TreeNode s, TreeNode t) {

         //base cases
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val == t.val && isSimilar(s,t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSimilar(TreeNode s, TreeNode t)
    {
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        return (s.val == t.val) && isSimilar(s.left,t.left) && isSimilar(s.right,t.right);

    }

    public boolean isSubtree1(TreeNode s, TreeNode t) {
        //base cases
        if(s==null && t==null) return true;
        if(s==null || t==null)return false;
        if(s.val == t.val && isSubtree1(s.left,t.left) && isSubtree1(s.right,t.right))
            return true;
        return isSubtree1(s.left,t) || isSubtree1(s.right,t);
    }

    public TreeNode getSkewedTree()
    {
//                    1
//               /       \
//              2         3
//             / \       / \
//            4   5     6   7
//           /     \
//          12      8
//         /         \
//       13           9
//       /             \
//      14              10
//     /                 \
//   15                   11
        TreeNode treeNode =new TreeNode(1);
        treeNode.setLeft(new TreeNode(2));
        treeNode.setRight(new TreeNode(3));
        treeNode.getLeft().setLeft(new TreeNode(4));
        treeNode.getLeft().setRight(new TreeNode(5));
        treeNode.getRight().setLeft(new TreeNode(6));
        treeNode.getRight().setRight(new TreeNode(7));
        treeNode.getLeft().getRight().setRight(new TreeNode(8));
        treeNode.getLeft().getRight().setRight(new TreeNode(8));
        treeNode.getLeft().getRight().getRight().setRight(new TreeNode(9));
        treeNode.getLeft().getRight().getRight().getRight().setRight(new TreeNode(10));
        treeNode.getLeft().getRight().getRight().getRight().getRight().setRight(new TreeNode(11));
        treeNode.getLeft().getLeft().setLeft(new TreeNode(12));
        treeNode.getLeft().getLeft().getLeft().setLeft(new TreeNode(13));
        treeNode.getLeft().getLeft().getLeft().getLeft().setLeft(new TreeNode(14));
        treeNode.getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(new TreeNode(15));
        return treeNode;
    }

    @Test
    public void testIsSubtree()
    {
//        TreeNode tree = getSkewedTree();tree
//        assertTrue(isSubtree(tree,tree.left));

//        s=                     t=
//          3                    3
//       /     \                / \
//      4       5              1   2
//     / \     / \
//    1   nul 2   null

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.right.left = new TreeNode(2);

        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        assertFalse(isSubtree(s,t));
    }
}
