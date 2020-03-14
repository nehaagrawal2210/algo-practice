package practice1;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class DuplicateSubtree {

    private char val;
    private DuplicateSubtree left;
    private DuplicateSubtree right;

    public DuplicateSubtree(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DuplicateSubtree.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .toString();
    }

    public static String hasDuplicateSubtree(DuplicateSubtree node, Set<String> trees, boolean[] hasDuplicate) {
        if (node == null) {
            return "#";
        }

        String lStr = hasDuplicateSubtree(node.left, trees, hasDuplicate);
        String rStr = hasDuplicateSubtree(node.right, trees, hasDuplicate);

        String res = node.val + lStr + rStr;

        if (res.length() > 3 && trees.contains(res)) {
            hasDuplicate[0] = true;
        }

        trees.add(res);
        return res;
    }

    public static void main(String[] args) {
        DuplicateSubtree duplicateSubtree = new DuplicateSubtree('A');
        duplicateSubtree.left = new DuplicateSubtree('B');
        duplicateSubtree.left.left = new DuplicateSubtree('D');
        duplicateSubtree.left.right = new DuplicateSubtree('E');
        duplicateSubtree.right = new DuplicateSubtree('C');
        duplicateSubtree.right.right = new DuplicateSubtree('B');
        duplicateSubtree.right.right.left = new DuplicateSubtree('D');
        duplicateSubtree.right.right.right = new DuplicateSubtree('E');

        boolean[] hasDup = {false};
        String res = hasDuplicateSubtree(duplicateSubtree, new HashSet<>(), hasDup);
        System.out.println("res = " + res);
        System.out.println("hasDup = " + hasDup[0]);
    }

}
