package BinarySearchTree;

import junit.framework.TestCase;
import tree.TreeNode;

/**
 * Created by neagrawa on 6/10/17.
 */
public class SwapMisplacedNodes extends TestCase{

    public void correctTree(TreeNode root, TreeNode first, TreeNode middle, TreeNode last, TreeNode prev){
        if(root == null) return;
        correctTree(root.getLchild(),first,middle,last,prev);
        if(prev!=null && prev.getData()>root.getData()){
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        correctTree(root.getRchild(),first,middle,last,prev);
    }

    public void correctTree(TreeNode root){
        TreeNode first, middle, last, prev;
        first = middle = last = prev = null;
        correctTree(root,first,middle,last,prev);
        if(first!=null && last!=null){
            //swap data first and last
        }
    }
}
