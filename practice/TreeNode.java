package practice;

/**
 * Created by neagrawa on 5/29/17.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }

    @Override public String toString() {
        String res =  val+"";
        if(left!=null) res+=", "+left.val;
        if(right!=null) res+=", "+right.val;
        return res;
    }
}
