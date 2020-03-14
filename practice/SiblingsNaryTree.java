package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import junit.framework.TestCase;

public class SiblingsNaryTree extends TestCase {

    public static void main(String[] args) {
        NaryTreeNode node = new NaryTreeNode(50);
        List<NaryTreeNode> children = new ArrayList<>();

        NaryTreeNode temp1 = new NaryTreeNode(2);
        NaryTreeNode temp2 = new NaryTreeNode(30);
        NaryTreeNode temp3 = new NaryTreeNode(14);
        NaryTreeNode temp4 = new NaryTreeNode(60);

        children.add(temp1);
        children.add(temp2);
        children.add(temp3);
        children.add(temp4);

        List<NaryTreeNode> children1 = new ArrayList<>();
        children1.add(new NaryTreeNode(15));
        NaryTreeNode temp5 = new NaryTreeNode(25);
        children1.add(temp5);
        temp1.children = children1;

        List<NaryTreeNode> children2 = new ArrayList<>();
        children2.add(new NaryTreeNode(70));
        children2.add(new NaryTreeNode(100));
        temp5.children = children2;

        List<NaryTreeNode> children3 = new ArrayList<>();
        children3.add(new NaryTreeNode(6));
        children3.add(new NaryTreeNode(1));
        temp2.children = children3;

        List<NaryTreeNode> children4 = new ArrayList<>();
        children4.add(new NaryTreeNode(16));
        temp4.children = children4;

        List<NaryTreeNode> children5 = new ArrayList<>();
        NaryTreeNode temp6 = new NaryTreeNode(7);
        children5.add(temp6);
        temp3.children = children5;

        List<NaryTreeNode> children6 = new ArrayList<>();
        children6.add(new NaryTreeNode(17));
        children6.add(new NaryTreeNode(99));
        children6.add(new NaryTreeNode(27));
        temp6.children = children6;

        node.children = children;

        System.out.println("siblingCount(node, 25) = " + siblingCount(node, 25));
    }

    private static int siblingCount(NaryTreeNode root, int val) {
        Queue<NaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                NaryTreeNode node = q.poll();
                if (node.val == val) {
                    return levelSize - 1;
                }
                if (node.children != null && !node.children.isEmpty()) {
                    q.addAll(node.children);
                }
            }
        }
        return -1;
    }

    @Test
    public void testCheckMirror() {
        NaryTreeNode node1 = new NaryTreeNode(1);
        node1.children = Arrays.asList(new NaryTreeNode(2), new NaryTreeNode(3));

        NaryTreeNode node2 = new NaryTreeNode(1);
        node2.children = Arrays.asList(new NaryTreeNode(3), new NaryTreeNode(2));

        assertTrue(checkMirror(node1, node2));
    }

    @Test
    public void testCheckMirrorMultipleChild() {
        NaryTreeNode node1 = new NaryTreeNode(1);
        node1.children = Arrays.asList(new NaryTreeNode(2), new NaryTreeNode(3));
        node1.children.get(0).children = Arrays.asList(new NaryTreeNode(4), new NaryTreeNode(5), new NaryTreeNode(6));

        NaryTreeNode node2 = new NaryTreeNode(1);
        node2.children = Arrays.asList(new NaryTreeNode(3), new NaryTreeNode(2));
        node2.children.get(1).children = Arrays.asList(new NaryTreeNode(6), new NaryTreeNode(5), new NaryTreeNode(4));

        assertTrue(checkMirror(node1, node2));
    }

    @Test
    public void testCheckMirrorUnequalChildren() {
        NaryTreeNode node1 = new NaryTreeNode(1);
        node1.children = Arrays.asList(new NaryTreeNode(2), new NaryTreeNode(3));
        node1.children.get(0).children = Arrays.asList(new NaryTreeNode(4), new NaryTreeNode(5), new NaryTreeNode(6));

        NaryTreeNode node2 = new NaryTreeNode(1);
        node2.children = Arrays.asList(new NaryTreeNode(3), new NaryTreeNode(2));
        node2.children.get(1).children = Arrays.asList(new NaryTreeNode(6), new NaryTreeNode(5));

        assertFalse(checkMirror(node1, node2));
    }

    @Test
    public void testCheckMirrorFalse() {
        NaryTreeNode node1 = new NaryTreeNode(1);
        node1.children = Arrays.asList(new NaryTreeNode(2), new NaryTreeNode(3));

        NaryTreeNode node2 = new NaryTreeNode(1);
        node2.children = Arrays.asList(new NaryTreeNode(2), new NaryTreeNode(3));

        assertFalse(checkMirror(node1, node2));
    }

    private boolean checkMirror(NaryTreeNode t1, NaryTreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            if (t1.children != null && t2.children != null && t1.children.size() == t2.children.size()) {
                boolean isMirror = true;
                for (int i = 0, j = t1.children.size() - 1; i < t1.children.size(); i++, j--) {
                    isMirror = isMirror && checkMirror(t1.children.get(i), t2.children.get(j));
                }
                return isMirror;
            } else if (t1.children == null && t2.children == null) {
                return true;
            }
        }
        return false;
    }
}

class NaryTreeNode {
    int val;
    List<NaryTreeNode> children;

    public NaryTreeNode(int val) {
        this.val = val;
    }
}
