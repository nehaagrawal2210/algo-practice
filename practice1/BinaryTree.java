package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTree {

    TreeNode root;

    class TreeNode {
        private Integer val;
        private char charVal;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(Integer val) {
            this.val = val;
        }

        public TreeNode(char val) {
            this.charVal = val;
        }

        public void inorderChar(TreeNode root) {
            if (root != null) {
                inorderChar(root.left);
                System.out.print(root.charVal + ", ");
                inorderChar(root.right);
            }
        }

        public void inorder(TreeNode root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.val + ", ");
                inorder(root.right);
            }
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("charVal=" + charVal)
                    .toString();
        }

        public void preorder(TreeNode root) {
            if (root != null) {
                System.out.print(root.val + ", ");
                preorder(root.left);
                preorder(root.right);
            }
        }
    }

    public TreeNode insert(Integer val) {
        if (root == null) {
            root = new TreeNode(val);
            root.parent = null;
            return root;
        }

        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.left == null) {
                temp.left = new TreeNode(val);
                temp.left.parent = temp;
                return temp.left;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new TreeNode(val);
                temp.right.parent = temp;
                return temp.right;
            } else {
                q.add(temp.right);
            }
        }
        return null;
    }

    public void deleteNode(int key) {
        TreeNode parent = root;

        if (parent == null) {
            return;
        }

        if (parent.left == null && parent.right == null) {
            if (parent.val == key) {
                root = null;
            }
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(parent);

        while (!q.isEmpty()) {
            parent = q.poll();
            if (parent.left != null) {
                if (parent.left.val == key) {
                    TreeNode temp = deleteAndGetLastNode();
                    temp.left = parent.left.left;
                    temp.right = parent.left.right;
                    parent.left = temp;
                    return;
                } else {
                    q.add(parent.left);
                }
            }
            if (parent.right != null) {
                if (parent.right.val == key) {
                    TreeNode temp = deleteAndGetLastNode();
                    temp.left = parent.right.left;
                    temp.right = parent.right.right;
                    parent.right = temp;
                    return;
                } else {
                    q.add(parent.right);
                }
            }
        }
    }

    private TreeNode deleteAndGetLastNode() {
        TreeNode temp = root, prev = root;
        while (temp != null && temp.right != null) {
            prev = temp;
            temp = temp.right;
        }
        if (temp.left != null) {
            prev = temp;
            temp = temp.left;
            prev.left = null;
        } else {
            prev.right = null;
        }
        return temp;
    }

    public boolean isContinuousTree() {
        TreeNode temp = root;
        return checkContinuousTree(temp);
    }

    private boolean checkContinuousTree(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }
        boolean isCurrentContinuous = true;
        if (node.left != null) {
            isCurrentContinuous &= Math.abs(node.val - node.left.val) == 1;
        }
        if (node.right != null) {
            isCurrentContinuous &= Math.abs(node.val - node.right.val) == 1;
        }
        boolean isLeftContinuous = checkContinuousTree(node.left);
        boolean isRightContinuous = checkContinuousTree(node.right);
        return isCurrentContinuous && isLeftContinuous && isRightContinuous;
    }

    public boolean isSymmetric() {
        return isMirror(root, root);
    }

    public boolean isFoldable() {
        if (root == null) {
            return true;
        }
        return isFoldable(root.left, root.right);
    }

    private boolean isFoldable(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return isFoldable(node1.left, node2.right) && isFoldable(node1.right, node2.left);
    }

    public void createMirror(TreeNode node) {
        if (node != null) {
            createMirror(node.left);
            createMirror(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 != null && node1.val == node2.val) {
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        return false;
    }



    public void printLevelOrder() {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            System.out.println("No elements");
            return;
        }
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.poll();
            vals.add(temp.val);
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        System.out.println(vals.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    public void iterativeInorder() {
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            if (!s.isEmpty()) {
                curr = s.pop();
                System.out.print(curr.val + ", ");
                curr = curr.right;
            }
        }
    }

    public void printPost(int[] inorder, int[] preorder, int inorderStart, int inorderEnd, Index preEleIndex) {
        if (inorderStart > inorderEnd) {
            return;
        }
        int preEle = preorder[preEleIndex.index++];
        int inorderIndex = search(inorder, inorderStart, inorderEnd, preEle);

        printPost(inorder, preorder, inorderStart, inorderIndex - 1, preEleIndex);
        printPost(inorder, preorder, inorderIndex + 1, inorderEnd, preEleIndex);
        System.out.print(inorder[inorderIndex] + ", ");
    }

    private int search(int[] inorder, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    public TreeNode constructBSTN2(int[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preOrder[i] > root.val) {
                break;
            }
        }

        root.left = constructBSTN2(preOrder, start + 1, i - 1);
        root.right = constructBSTN2(preOrder, i, end);
        return root;
    }

    public TreeNode constructBST(int[] preOrder, int min, int max, Index index) {
        if (index.index >= preOrder.length) {
            return null;
        }

        TreeNode root = null;
        int key = preOrder[index.index];
        if (key >= min && key <= max) {
            root = new TreeNode(key);
            index.index++;
            root.left = constructBST(preOrder, min, key, index);
            root.right = constructBST(preOrder, key, max, index);
        }
        return root;
    }

    public int kDistanceNodes(TreeNode root, int val, int k) {
        if (root == null) {
            return -1;
        }

        if (root.val == val) {
            printDownLevel(root, k);
            return 0;
        }

        int dl = kDistanceNodes(root.left, val, k);
        if (dl != -1) {
            if (dl + 1 == k) {
                System.out.print("root = " + root.val + ", ");
            } else {
                printDownLevel(root.right, k - dl - 2);
            }
            return dl + 1;
        }
        int dr = kDistanceNodes(root.right, val, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                System.out.println("root = " + root.val);
            } else {
                printDownLevel(root.left, k - dr - 2);
            }
            return dr + 1;
        }
        return -1;
    }

    public void printDownLevel(TreeNode root, int level) {
        if (root == null || level < 0) {
            return;
        }

        if (level == 0) {
            System.out.print("root.val = " + root.val + ", ");
        }
        printDownLevel(root.left, level - 1);
        printDownLevel(root.right, level - 1);
    }

    public TreeNode constructBSTStack(int[] preOrder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preOrder[0]);
        stack.push(root);
        for (int i = 1; i < preOrder.length; i++) {
            TreeNode temp = null;
            while (!stack.isEmpty() && preOrder[i] > stack.peek().val) {
                temp = stack.pop();
            }
            if (temp != null) {
                temp.right = new TreeNode(preOrder[i]);
                stack.push(temp.right);
            } else {
                temp = stack.pop();
                temp.left = new TreeNode(preOrder[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }

    public void postFromPreBST(int[] pre, int min, int max, Index index) {
        if (index.index >= pre.length) {
            return;
        }
        int key = pre[index.index];
        if (key >= min && key <= max) {
            index.index++;
            postFromPreBST(pre, min, key, index);
            postFromPreBST(pre, key, max, index);
            System.out.print(key + ", ");
        }
    }

    //    https://www.geeksforgeeks.org/replace-node-binary-tree-sum-inorder-predecessor-successor/

    private void replaceWithSum(TreeNode root, List<Integer> nums, Index index) {
        if (root == null) {
            return;
        }

        replaceWithSum(root.left, nums, index);
        root.val = nums.get(index.index - 1) + nums.get(index.index + 1);
        index.index++;
        replaceWithSum(root.right, nums, index);
    }

    private void saveInorderOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        saveInorderOrder(root.left, nums);
        nums.add(root.val);
        saveInorderOrder(root.right, nums);
    }

    public void replaceWithSum() {
        TreeNode temp = root;
        List<Integer> inorder = new ArrayList<>();
        inorder.add(0);
        saveInorderOrder(temp, inorder);
        inorder.add(0);

        Index idx = new Index();
        idx.index = 1;
        replaceWithSum(root, inorder, idx);
    }

    public void iterativeWithoutStackInorder() {
        TreeNode curr = root, pre;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + ", ");
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    System.out.print(curr.val + ", ");
                    curr = curr.right;
                }
            }
        }
    }


    public TreeNode inorderSuccessorBST(TreeNode root, TreeNode node) {
        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        TreeNode temp = root, successor = null;
        while (temp != null) {
            if (node.val < temp.val) {
                successor = temp;
                temp = temp.left;
            } else if (node.val > temp.val) {
                temp = temp.right;
            } else {
                //we already found our successor
                break;
            }
        }
        return successor;
    }


    public TreeNode inorderSuccessorBT(TreeNode root, TreeNode node) {

        if (root == null) {
            return null;
        }

        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        TreeNode parent = node.parent;
        TreeNode temp = node;
        while (parent != null && parent.left != temp) {
            temp = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        return 1 + Math.max(lheight, rheight);
    }

    public int density(TreeNode root, Size size) {
        if (root == null) {
            return 0;
        }

        int lHeight = density(root.left, size);
        int rHeight = density(root.right, size);

        size.s = size.s + 1;
        return Math.max(lHeight, rHeight) + 1;
    }

    public void printLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.val + ", ");
            return;
        }

        printLevel(root.left, level - 1);
        printLevel(root.right, level - 1);
    }

    public void reverseLevelOrder() {
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.poll();
            stack.push(temp);
            if (temp.right != null) {
                q.add(temp.right);
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
        }

        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.val + ", ");
        }
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.poll();
            System.out.print(temp.val + ", ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    class Height {
        int h = 0;
    }

    public int diameter(TreeNode root, Ans ans) {
        if (root == null) {
            ans.ans = 0;
            return 0;
        }

        int lheight = diameter(root.left, ans);
        int rheight = diameter(root.right, ans);

        ans.ans = Math.max(ans.ans, lheight + rheight + 1);
        return Math.max(lheight, rheight) + 1;
    }

    public void levelOrderByLine() {
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            int nodeCount = q.size();
            while (nodeCount > 0) {
                temp = q.poll();
                System.out.print(temp.val + ", ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public int diameter(TreeNode root, Height height) {

        if (root == null) {
            height.h = 0;
            return 0;
        }

        Height lh = new Height(), rh = new Height();
        int ldia = diameter(root.left, lh);
        int rdia = diameter(root.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ldia, rdia));
    }

    public void switchTreeAndPrint() {
        switchTree(root);
        switchTreeAndPrint(root);
    }

    public void switchTreeAndPrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.print(treeNode.val + ", ");
        switchTreeAndPrint(treeNode.right);
    }

    public int binaryTreeNumber(int nodeCount) {
        int[] dp = new int[nodeCount + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= nodeCount; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[nodeCount];
    }

    public TreeNode concatenate(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode leftLast = t1.left;
        TreeNode rightLast = t2.left;

        leftLast.right = t2;
        t2.left = leftLast;
        t1.left = rightLast;
        rightLast.right = t1;

        return t1;
    }

    public TreeNode treeToCircularDLL(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = treeToCircularDLL(root.left);
        TreeNode right = treeToCircularDLL(root.right);

        root.left = root.right = left;
        return concatenate(concatenate(left, root), right);
    }

    //    https://www.geeksforgeeks.org/modify-binary-tree-get-preorder-traversal-using-right-pointers/
    public TreeNode switchTree(TreeNode root) {

        TreeNode right = root.right, rightMost = root;

        if (root.left != null) {
            rightMost = switchTree(root.left);
            root.right = root.left;
            root.left = null;
        }

        if (right == null) {
            return rightMost;
        }

        rightMost.right = right;
        rightMost = switchTree(root.right);
        return rightMost;
    }

    public TreeNode reversePath(TreeNode root, int key, int level, Map<Integer, Integer> pathMap, Index index) {
        if (root == null) {
            return null;
        }

        pathMap.put(level, root.val);
        if (key == root.val) {
            root.val = pathMap.get(index.index);
            index.index++;
            return root;
        }

        TreeNode right = null;
        TreeNode left = reversePath(root.left, key, level + 1, pathMap, index);

        if (left == null) {
            right = reversePath(root.right, key, level + 1, pathMap, index);
        }

        if (left != null || right != null) {
            root.val = pathMap.get(index.index);
            index.index++;
            return left != null ? left : right;
        }
        return null;
    }

    public int leftSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = leftSubtreeSum(root.left);
        int rightSum = leftSubtreeSum(root.right);
        root.val = leftSum + root.val;
        return root.val + rightSum;
    }

    public TreeNode parse(char[] expression, Index idx) {
        if (idx.index >= expression.length) {
            return null;
        }

        TreeNode tn = new TreeNode(expression[idx.index]);
        idx.index++;

        if (idx.index < expression.length && expression[idx.index] == '?') {
            idx.index++;
            tn.left = parse(expression, idx);
            idx.index++;
            tn.right = parse(expression, idx);
        }

        return tn;
    }

    public boolean printAncestors(TreeNode root, int data) {
        if (root == null) {
            return false;
        }

        if (root.val == data) {
            return true;
        }

        boolean isKeyPresentInLeft = printAncestors(root.left, data);
        boolean isKeyPresentInRight = printAncestors(root.right, data);

        if (isKeyPresentInLeft || isKeyPresentInRight) {
            System.out.print(root.val + ", ");
        }
        return isKeyPresentInLeft || isKeyPresentInRight;
    }

    public void bottomView() {
        bottomView(root);
    }

    public int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public int nonLeafNodeCount(TreeNode root) {
        //if null or leaf node return 0
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        return 1 + nonLeafNodeCount(root.left) + nonLeafNodeCount(root.right);
    }

    public void bottomView(TreeNode root) {
        Queue<TreeNodeDist> q = new LinkedList<>();
        Map<Integer, Integer> eleMap = new TreeMap<>();
        q.add(new TreeNodeDist(0, root));
        TreeNodeDist temp;
        int maxLevel = Integer.MIN_VALUE, minLevel = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.hd < minLevel) {
                minLevel = temp.hd;
            }
            if (temp.hd > maxLevel) {
                maxLevel = temp.hd;
            }
            eleMap.put(temp.hd, temp.node.val);
            if (temp.node.left != null) {
                q.add(new TreeNodeDist(temp.hd - 1, temp.node.left));
            }
            if (temp.node.right != null) {
                q.add(new TreeNodeDist(temp.hd + 1, temp.node.right));
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            System.out.print(eleMap.get(i) + ", ");
        }

    }

    private void fillAncestors(TreeNode root, int[] ancestors) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            ancestors[root.left.val] = root.val;
            fillAncestors(root.left, ancestors);
        }

        if (root.right != null) {
            ancestors[root.right.val] = root.val;
            fillAncestors(root.right, ancestors);
        }
    }

    public int kthAncestor(TreeNode root, int n, int k, int keyToSearch) {
        int[] ancestors = new int[n + 1];
        ancestors[root.val] = -1;
        fillAncestors(root, ancestors);

        int count = 0;
        while (keyToSearch != -1) {
            keyToSearch = ancestors[keyToSearch];
            count++;
            if (count == k) {
                break;
            }
        }
        return keyToSearch;
    }

    boolean v1 = false, v2 = false;

    public TreeNode findLCAWithVisit(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }

        TreeNode temp = null;
        if (root.val == node1) {
            v1 = true;
            temp = root;
        }

        if (root.val == node2) {
            v2 = true;
            temp = root;
        }

        if (temp != null) {
            return temp;
        }

        TreeNode leftLCA = findLCAWithVisit(root.left, node1, node2);
        TreeNode rightLCA = findLCAWithVisit(root.right, node1, node2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public TreeNode findLCASingleTraversal(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }

        if (root.val == node1 || root.val == node2) {
            return root;
        }

        TreeNode leftLCA = findLCASingleTraversal(root.left, node1, node2);
        TreeNode rightLCA = findLCASingleTraversal(root.right, node1, node2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public int findLCA(TreeNode root, int node1, int node2) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        boolean isN1Available = findPath(root, node1, path1);
        boolean isN2Available = findPath(root, node2, path2);

        int i = 0;
        if (isN1Available && isN2Available) {
            for (i = 0; i < path1.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }
            return path1.get(i - 1).val;
        }

        return Integer.MIN_VALUE;
    }

    public boolean findPath(TreeNode root, int node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.val == node || findPath(root.left, node, path) || findPath(root.right, node, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public int findLevel(TreeNode root, int node, int level) {
        if (root == null) {
            return -1;
        }

        if (root.val == node) {
            return level;
        }

        int l = findLevel(root.left, node, level + 1);
        return l != -1 ? l : findLevel(root.right, node, level + 1);
    }

    int distance1 = -1, distance2 = -1, totalDistance = 0;

    public TreeNode distBetweenNodes(TreeNode root, int node1, int node2, int level) {
        if (root == null) {
            return null;
        }

        if (root.val == node1) {
            distance1 = level;
            return root;
        }

        if (root.val == node2) {
            distance2 = level;
            return root;
        }

        TreeNode leftLCA = distBetweenNodes(root.left, node1, node2, level + 1);
        TreeNode rightLCA = distBetweenNodes(root.right, node1, node2, level + 1);

        if (leftLCA != null && rightLCA != null) {
            totalDistance = (distance1 + distance2) - 2 * level;
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public boolean isChildSumProperty(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftVal = root.left != null ? root.left.val : 0;
        int rightVal = root.right != null ? root.right.val : 0;

        if (root.val != (leftVal + rightVal)) {
            return false;
        }

        if ((root.val != leftVal + rightVal) && isChildSumProperty(root.left) && isChildSumProperty(root.right)) {
            return true;
        }
        return false;
    }

    public int distBetweenNodes(TreeNode root, int node1, int node2) {
        TreeNode lca = findLCASingleTraversal(root, node1, node2);
        int node1Dist = findLevel(lca, node1, 0);
        int node2Dist = findLevel(lca, node2, 0);

        return node1Dist + node2Dist;
    }

    public boolean isSumTree(TreeNode root) {
        if (root == null || isLeafNode(root)) {
            return true;
        }

        int leftSum = getSum(root.left), rightSum = getSum(root.right);
        if ((root.val == leftSum + rightSum) && isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        }
        return false;
    }

    public int getSum(TreeNode node) {
        if (node != null) {
            if (isLeafNode(node)) {
                return node.val;
            }
            return node.val * 2;
        }
        return 0;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public boolean hasPathSum(TreeNode root, int sum, int sumSoFar) {
        if (root == null) {
            return false;
        }

        sumSoFar += root.val;
        if (root.left == null && root.right == null && sumSoFar == sum) {
            return true;
        }
        return hasPathSum(root.left, sum, sumSoFar) || hasPathSum(root.right, sum, sumSoFar);
    }

    public void printPath(TreeNode root, int sumTillNow, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }

        sumTillNow += root.val;
        path.add(root.val);

        if (sumTillNow == sum) {
            System.out.println(Arrays.toString(path.toArray()));
        }

        printPath(root.left, sumTillNow, sum, path);
        printPath(root.right, sumTillNow, sum, path);
        path.remove(path.size() - 1);
    }

    public int printKLeafDistanceNodes(TreeNode root, int k, int level) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            //this is a leaf node
            return level;
        }

        int dl = printKLeafDistanceNodes(root.left, k, level + 1);
        if (dl - level == k) {
            System.out.println("root = " + root.val);
        }
        int dr = printKLeafDistanceNodes(root.right, k, level + 1);
        if (dr - level == k) {
            System.out.println("root = " + root.val);
        }
        return dl;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        Ans a = new Ans();
        int dia = bt.diameter(bt.root, a);
        System.out.println("dia = " + a.ans);
    }

    public int longestLeafToLeafDia(TreeNode root, Ans ans) {
        if (root == null) {
            return 0;
        }

        int lHeight = longestLeafToLeafDia(root.left, ans);
        int rHeight = longestLeafToLeafDia(root.right, ans);

        int rootDia = 1 + lHeight + rHeight;
        if (rootDia > ans.ans) {
            ans.ans = rootDia;
            ans.diaNode = root;
            ans.lHeight = lHeight;
            ans.rHeight = rHeight;
        }

        return Math.max(lHeight, rHeight) + 1;
    }

    public void printPaths(TreeNode node, int[] path, int pathLen, int max, int[] isLeft) {
        if (node == null) {
            return;
        }

        path[pathLen++] = node.val;

        if (node.left == null && node.right == null) {
            if (pathLen == max && (isLeft[0] == 0 || isLeft[1] == 1)) {
                //print path array
                isLeft[0] = 2;
            }
        } else {
            printPaths(node.left, path, pathLen, max, isLeft);
            printPaths(node.right, path, pathLen, max, isLeft);
        }
    }
}

class TreeNodeDist {
    int hd;
    BinaryTree.TreeNode node;

    public TreeNodeDist(int hd, BinaryTree.TreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}

/**
 * Print postorder from inorder and preorder
 */
class Index {
    int index = 0;
}

class Size {
    int s = 0;

}

class Ans {
    int ans = 0;
    BinaryTree.TreeNode diaNode = null;
    int lHeight = 0;
    int rHeight = 0;
}
