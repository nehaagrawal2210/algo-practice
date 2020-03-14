package practice1;

import java.util.Stack;

public class ExpressionTree {

    TreeNode root;

    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }


    private boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    public void construct(String postFixExpr) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode t;
        for (char c : postFixExpr.toCharArray()) {
            t = new TreeNode(c);
            if (isOperator(c)) {
                t.right = stack.pop();
                t.left = stack.pop();
            }
            stack.push(t);
        }
        root = stack.pop();
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        ExpressionTree tr = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        tr.construct(postfix);
        tr.inorder();
    }
}
