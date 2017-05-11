package tree;

import linkedList.RandomNode;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neha on 2/21/2017.
 */
public class CloneTree extends TestCase{

    public RandomTreeNode cloneTree(RandomTreeNode treeNode, Map<RandomTreeNode, RandomTreeNode> map)
    {
        if(treeNode == null)
            return treeNode;
        RandomTreeNode rootCopy= new RandomTreeNode(treeNode.getData());
        map.put(treeNode,rootCopy);
        rootCopy.setLchild(cloneTree(treeNode.getLchild(),map));
        rootCopy.setRchild(cloneTree(treeNode.getRchild(),map));
        return rootCopy;
    }

    public RandomTreeNode cloneRandomTree(RandomTreeNode root)
    {
        Map<RandomTreeNode,RandomTreeNode> map = new HashMap<>();
        RandomTreeNode clonedTree = cloneTree(root,map);

        //set the random pointers
        copyRandom(root,clonedTree,map);
        return clonedTree;
    }

    public void copyRandom(RandomTreeNode root, RandomTreeNode copy,Map<RandomTreeNode,RandomTreeNode> map)
    {
        if(root==null)
            return;
        if(root.random!=null)
        copy.random = map.get(root.random);
        copyRandom(root.lchild,copy.lchild,map);
        copyRandom(root.rchild,copy.rchild,map);
    }

    @Test
    public void testCloneRandomTree()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//                    /
//                   8
//  Random:      2-->3 , 5-->8, 4-->1, 3--> 5
        RandomTreeNode root=new RandomTreeNode(1);
        root.setLchild(new RandomTreeNode(2));
        root.setRchild(new RandomTreeNode(3));
        root.getLchild().setLchild(new RandomTreeNode(4));
        root.getLchild().setRchild(new RandomTreeNode(5));
        root.getRchild().setLchild(new RandomTreeNode(6));
        root.getRchild().setRchild(new RandomTreeNode(7));
        root.getRchild().getRchild().setLchild(new RandomTreeNode(8));
        root.getLchild().setRandom(root.getRchild());
        root.getLchild().getRchild().setRandom(root.getRchild().getRchild().getLchild());
        root.getLchild().getLchild().setRandom(root);
        root.getRchild().setRandom(root.getLchild().getRchild());

        RandomTreeNode.inorderTraverseRec(root);
        RandomTreeNode randomTreeNode = cloneRandomTree(root);
        System.out.println();
        RandomTreeNode.inorderTraverseRec(randomTreeNode);
    }
}

class RandomTreeNode{
    int data;
    RandomTreeNode lchild;
    RandomTreeNode rchild;
    RandomTreeNode random;

    public RandomTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public RandomTreeNode getLchild() {
        return lchild;
    }

    public void setLchild(RandomTreeNode lchild) {
        this.lchild = lchild;
    }

    public RandomTreeNode getRchild() {
        return rchild;
    }

    public void setRchild(RandomTreeNode rchild) {
        this.rchild = rchild;
    }

    public RandomTreeNode getRandom() {
        return random;
    }

    public void setRandom(RandomTreeNode random) {
        this.random = random;
    }

    public static void inorderTraverseRec(RandomTreeNode root)
    {
        if(root==null)
            return;
        inorderTraverseRec(root.getLchild());
        System.out.print("["+root.getData());
        if(root.getRandom()!=null) System.out.print(", "+root.getRandom().getData()+"], ");
        else System.out.print(", Null], ");
        inorderTraverseRec(root.getRchild());
    }
}
