package practice;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by neagrawa on 5/31/17.
 */
public class CloneRandomTree extends TestCase{
    class randomTreeNode{
        int val;
        randomTreeNode left,right,random;

        public randomTreeNode(int val) {
            this.val = val;
        }

        public void traverseLevelOrder(randomTreeNode root)
        {
            Queue<randomTreeNode> queue = new LinkedList<>();
            queue.add(root);
            randomTreeNode temp;
            while (!queue.isEmpty())
            {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    temp = queue.poll();
                    System.out.print("Level "+i+"= "+temp.val);
                    if(temp.left!=null) {
                        System.out.print(", Left= "+temp.left.val);
                        queue.add(temp.left);
                    }
                    if(temp.right!=null){
                        System.out.print(", Right= "+temp.right.val);
                        queue.add(temp.right);
                    }
                    if(temp.random!=null)
                        System.out.print(", Random= "+temp.random.val);
                    System.out.println();
                }
            }
        }
    }

    public randomTreeNode cloneTree(randomTreeNode root,Map<randomTreeNode,randomTreeNode> map)
    {
        if(root==null) return root;
        randomTreeNode clonedRoot = new randomTreeNode(root.val);
        clonedRoot.left = cloneTree(root.left,map);
        clonedRoot.right = cloneTree(root.right,map);
        map.put(root,clonedRoot);
        return clonedRoot;
    }

    public void cloneRandom(randomTreeNode root, randomTreeNode clonedRoot, Map<randomTreeNode,
            randomTreeNode>
            map)
    {
        if(clonedRoot==null) return;
        clonedRoot.random = map.get(root.random);
        cloneRandom(root.left,clonedRoot.left,map);
        cloneRandom(root.right,clonedRoot.right,map);
    }

    public randomTreeNode cloneTree(randomTreeNode root)
    {
        Map<randomTreeNode,randomTreeNode> treeMap = new HashMap<>();
        randomTreeNode clonedRoot = cloneTree(root,treeMap);
        cloneRandom(root,clonedRoot,treeMap);
        return clonedRoot;
    }

    public void testCloneRandom()
    {
        randomTreeNode root = new randomTreeNode(1);
        root.left = new randomTreeNode(2);
        root.right = new randomTreeNode(3);
        root.left.left = new randomTreeNode(4);
        root.left.right = new randomTreeNode(5);
        root.right.left = new randomTreeNode(6);
        root.right.right = new randomTreeNode(7);
        root.left.left.right = new randomTreeNode(8);
        root.random = root.right.right;
        root.left.random = root.left.left.right;
        root.right.random = root.right.left;
        root.left.left.random = root.left.right;
        root.traverseLevelOrder(root);
        randomTreeNode cloned = cloneTree(root);
        System.out.println();
        root.traverseLevelOrder(cloned);
    }
}
