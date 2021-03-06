package practice;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by neagrawa on 5/29/17.
 */
public class Tree extends TestCase {
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + ", ");
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + ", ");
        inorder(root.right);
    }

    public void levelOrder(TreeNode root) {
        java.util.Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                System.out.print(temp.val + ", ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            System.out.println();
        }
    }


    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    class Height {
        int h;
    }

    public int getDiameter(TreeNode root) {
        if (root == null) return 0;

        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);

        int lDiameter = getDiameter(root.left);
        int rDiameter = getDiameter(root.right);

        return Math.max(Math.max(lDiameter, rDiameter), 1 + lheight + rheight);
    }

    public int getDiameter(TreeNode root, Height h) {
        if (root == null) {
            h.h = 0;
            return 0;
        }

        Height lHeight = new Height(), rHeight = new Height();
        int lDia = getDiameter(root.left, lHeight);
        int rDia = getDiameter(root.right, rHeight);

        h.h = Math.max(lHeight.h, rHeight.h) + 1;
        return Math.max(lHeight.h + rHeight.h + 1, Math.max(lDia, rDia));
    }

    public TreeNode cloneTree(TreeNode root) {
        if (root == null) return root;
        TreeNode cloneRoot = new TreeNode(root.val);
        cloneRoot.left = cloneTree(root.left);
        cloneRoot.right = cloneTree(root.right);
        return cloneRoot;
    }

    public boolean printAncestors(TreeNode root, int key) {
        if (root == null) return false;
        else if (root.val == key) return true;
        else if (printAncestors(root.left, key) || printAncestors(root.right, key)) {
            System.out.print(" ," + root.val);
            return true;
        }
        return false;
    }

    public void printKDistantNodesFromRoot(TreeNode root, int k) {
        if (root == null) return;
        if (k == 0) {
            System.out.print(", " + root.val);
            return;
        }
        printKDistantNodesFromRoot(root.left, k - 1);
        printKDistantNodesFromRoot(root.right, k - 1);
    }

    //sorted array to a BST with minimum height
    public static TreeNode minimalTree(int[] a) {
        return minimalTree(a, 0, a.length - 1);
    }

    public static TreeNode minimalTree(int[] a, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode treeNode = new TreeNode(a[mid]);
        treeNode.left = minimalTree(a, start, mid - 1);
        treeNode.right = minimalTree(a, mid + 1, end);
        return treeNode;
    }

    class level {
        int level;
    }

    public int getLevel(TreeNode root, int key, int level) {
        if (root == null) return 0;
        if (root.val == key) return level;
        int downLevel = getLevel(root.left, key, level + 1);
        if (downLevel != 0) return downLevel;
        downLevel = getLevel(root.right, key, level + 1);
        return downLevel;
    }

    public int printKDistantNode(TreeNode root, TreeNode target, int k) {
        if (root == null) return -1;
        if (root.val == target.val) {
            printKDistantNodesFromRoot(root, k);
            return 0;
        }

        int dl = printKDistantNode(root.left, target, k);
        if (dl != -1) {
            if (dl + 1 == k)
                System.out.print(", " + root.val);
            else
                printKDistantNodesFromRoot(root.right, k - dl - 2);
            return dl + 1;
        }

        int dr = printKDistantNode(root.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k)
                System.out.print(", " + root.val);
            else
                printKDistantNodesFromRoot(root.left, k - dr - 2);
            return 1 + dr;
        }
        //target not present
        return -1;
    }

    public int getLevel(TreeNode root, int key) {
        return getLevel(root, key, 1);
    }

    class Min {
        int min;
    }

    class Max {
        int max;
    }

    public void getMinMaxWidth(TreeNode root, Min min, Max max, int hd) {
        if (root == null) return;

        if (hd < min.min) min.min = hd;
        if (hd > max.max) max.max = hd;
        getMinMaxWidth(root.left, min, max, hd - 1);
        getMinMaxWidth(root.right, min, max, hd + 1);
    }

    public void printVerticalLine(TreeNode root, int lineNo, int hd) {
        if (root == null) return;
        if (hd == lineNo)
            System.out.println(root.val);
        printVerticalLine(root.left, lineNo, hd - 1);
        printVerticalLine(root.right, lineNo, hd + 1);
    }

    public void printVerticalOrder(TreeNode root) {
        Min min = new Min();
        Max max = new Max();
        min.min = 0;
        max.max = 0;

        getMinMaxWidth(root, min, max, 0);

        for (int i = min.min; i <= max.max; i++) {
            printVerticalLine(root, i, 0);
        }
    }

    public void printKDistanceFromLeafNode(TreeNode root, int k) {
        int[] path = new int[1000];
        boolean[] visited = new boolean[1000];
        printKDistanceFromLeafNode(root, k, path, visited, 0);
    }

    public void printKDistanceFromLeafNode(TreeNode root, int targetDist, int[] path, boolean[] visited, int pathLen) {
        if (root == null) return;
        path[pathLen] = root.val;
        visited[pathLen++] = false;

        if (root.left == null && root.right == null && pathLen - targetDist - 1 >= 0 && !visited[pathLen - targetDist - 1]) {
            System.out.println(path[pathLen - targetDist - 1]);
            visited[pathLen - targetDist - 1] = true;
            return;
        }
        printKDistanceFromLeafNode(root.left, targetDist, path, visited, pathLen);
        printKDistanceFromLeafNode(root.right, targetDist, path, visited, pathLen);
    }

    public boolean getChildSum(TreeNode root) {
        int leftD = 0, rightD = 0;
        if (root == null || (root.left == null && root.right == null))
            return true;
        else {
            if (root.left != null) leftD = root.left.val;
            if (root.right != null) rightD = root.right.val;
            if (root.val == (leftD + rightD) && getChildSum(root.left) && getChildSum(root.right))
                return true;
        }
        return false;
    }

    public void printPath(TreeNode treeNode, int[] path, int pathLen) {
        if (treeNode == null) return;
        path[pathLen++] = treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            for (int i = 0; i < pathLen; i++) {
                System.out.print(path[i] + ", ");
            }
            System.out.println();
        }
        printPath(treeNode.left, path, pathLen);
        printPath(treeNode.right, path, pathLen);
    }

    public boolean rootToLeafPathSum(TreeNode treeNode, int pathSum, int targetSum) {
        if (treeNode == null) return false;
        pathSum += treeNode.val;
        if ((treeNode.left == null && treeNode.right == null && pathSum == targetSum)
                || rootToLeafPathSum(treeNode.left, pathSum, targetSum)
                || rootToLeafPathSum(treeNode.right, pathSum, targetSum))
            return true;
        return false;
    }

    public void serialize(TreeNode root, StringBuffer s) {
        if (root == null) {
            s.append('$');
            return;
        }
        s.append(root.val);
        serialize(root.left, s);
        serialize(root.right, s);
    }

    class Index {
        int index;

        public Index(int index) {
            this.index = index;
        }
    }

    public TreeNode deserialize(String s, Index index) {
        char c = s.charAt(index.index);
        index.index++;
        if (index.index >= s.length() || c == '$') return null;
        TreeNode root = new TreeNode(Character.getNumericValue(c));
        root.left = deserialize(s, index);
        root.right = deserialize(s, index);
        return root;
    }

    public void testTraversal() {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        root.left.left.right = new TreeNode(8);

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode treeNode = minimalTree(a);
        levelOrder(treeNode);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = getFrequency(words);
        final Map<String, Integer> sortedByCount = frequencyMap.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()).thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<String> topKFrequency = new LinkedList<>();
        int count = 0;
        for (String word : sortedByCount.keySet()) {
            topKFrequency.add(word);
            count++;
            if (count >= k) {
                break;
            }
        }

        return topKFrequency;
    }

    private Map<Character, Integer> getCharacterFrequency(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }

    private Map<String, Integer> getFrequency(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    public void testTopFrequent() {
        Map<Character, Integer> frequencyMap = getCharacterFrequency("Aabb");
        final Map<Character, Integer> sortedByCount = frequencyMap.entrySet()
                .stream()
                .sorted((Map.Entry.<Character, Integer>comparingByValue().reversed()).thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder str = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedByCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                str.append(entry.getKey());
            }
        }

        System.out.println(str.toString());
    }

}
