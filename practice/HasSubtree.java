package practice;

/**
 * Created by neagrawa on 6/2/17.
 */
public class HasSubtree {
    public boolean isSubtree(TreeNode T, TreeNode S)
    {
        if(S == null) return true;
        if(T == null) return false;
        return areIdentical(T,S) || areIdentical(T.left,S) || areIdentical(T.right,S);
    }

    public boolean areIdentical(TreeNode T, TreeNode S)
    {
        if(T == null && S ==null) return true;
        if(T== null || S==null) return false;
        return (T.val == S.val) && areIdentical(T.left,S.left) && areIdentical(T.right,S.right);
    }
}
