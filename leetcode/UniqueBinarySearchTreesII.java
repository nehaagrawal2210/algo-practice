package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neagrawa on 5/5/17.
 */
public class UniqueBinarySearchTreesII extends TestCase{

    /**
     * Definition for a binary tree node.
     **/

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

          public void printPreOrder(TreeNode root)
          {
              if(root == null) return;
              printPreOrder(root.left);
              System.out.print(root.val+" ");
              printPreOrder(root.right);
          }
      }

    public List<TreeNode> generateTrees(int n) {
         return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start, int end)
    {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = generateTrees(start, i-1);
            right = generateTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }


    @Test
    public void testGenerateTrees()
    {
        List<TreeNode> trees = generateTrees(3);
        for (TreeNode tree: trees) {
            tree.printPreOrder(tree);
            System.out.println();
        }
    }
}
