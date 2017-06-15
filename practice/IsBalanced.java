package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/10/17.
 */
public class IsBalanced extends TestCase {
    class Height{
        int h;
    }
    public boolean isBalanced(TreeNode root,Height h){
        if(root == null){
            h.h = 0;
            return true;
        }
        Height lheight = new Height(), rheight = new Height();
        boolean lbal = isBalanced(root.left,lheight);
        boolean rbal = isBalanced(root.right, rheight);

        int lh = lheight.h,rh = rheight.h;
        h.h = Math.max(lh,rh)+1;

        if(Math.abs(lh-rh)>=2) return false;
        return lbal && rbal;
    }
}
