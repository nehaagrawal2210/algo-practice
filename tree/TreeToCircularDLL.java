package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/2/2017.
 */
public class TreeToCircularDLL extends TestCase{

    public TreeNode concatenate(TreeNode list1,TreeNode list2)
    {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        TreeNode list1LastNode=list1.getLchild();
        TreeNode list2LastNode=list2.getLchild();
        list1LastNode.rchild=list2;
        list2.lchild=list1LastNode;
        list2LastNode.rchild=list1;
        list1.lchild=list2LastNode;
        return list1;
    }

    public TreeNode treeToCircularDLL(TreeNode treeNode)
    {
        if(treeNode==null)
            return null;
        TreeNode list1=treeToCircularDLL(treeNode.getLchild());
        TreeNode list2=treeToCircularDLL(treeNode.getRchild());
        TreeNode rootList=treeNode;
        rootList.lchild=rootList.rchild=treeNode;
        return concatenate(concatenate(list1,rootList),list2);
    }

    public void traverseDLL(TreeNode root)
    {
        TreeNode cur=root;
        do
        {
            System.out.print(cur.getData()+" ");
            cur=cur.getRchild();
        }while (cur!=root);
    }

    @Test
    public void testTreeToCircularDLL()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//                    /
//                   8
        TreeNode root=new TreeNode(1);
        root.setLchild(new TreeNode(2));
        root.setRchild(new TreeNode(3));
        root.getLchild().setLchild(new TreeNode(4));
        root.getLchild().setRchild(new TreeNode(5));
        root.getRchild().setLchild(new TreeNode(6));
        root.getRchild().setRchild(new TreeNode(7));
        root.getRchild().getRchild().setLchild(new TreeNode(8));

        TreeNode dll=treeToCircularDLL(root);
        traverseDLL(dll);
    }
}
