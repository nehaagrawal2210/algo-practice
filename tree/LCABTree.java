package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neha on 2/5/2017.
 */
public class LCABTree extends TestCase{

    public static int getLCA(TreeNode root,int a1,int a2)
    {
        List<Integer> pathA1= new ArrayList<>();
        List<Integer> pathA2= new ArrayList<>();

        boolean pathA1Exists=getPath(root,a1,pathA1);
        boolean pathA2Exists=getPath(root,a2,pathA2);

        if(!pathA1Exists || !pathA2Exists)
            return Integer.MIN_VALUE;

        int i;
        for (i = 0; i < pathA1.size() && i < pathA2.size(); i++) {
            if(pathA1.get(i) != pathA2.get(i))
                break;
        }
        return pathA1.get(i-1);
    }

    public static int getLCASingleTraverse(TreeNode root,int a1,int a2)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        if(root.getData()==a1 || root.getData()==a2)
            return root.getData();
        int leftLCA=getLCASingleTraverse(root.getLchild(),a1,a2);
        int rightLCA=getLCASingleTraverse(root.getRchild(),a1,a2);

        if(leftLCA!=Integer.MIN_VALUE && rightLCA!=Integer.MIN_VALUE)
            return root.getData();
        return (leftLCA!=Integer.MIN_VALUE)?leftLCA:rightLCA;
    }

    public static boolean getPath(TreeNode root,int k,List<Integer> path)
    {
        if(root==null)
            return false;
        path.add(root.getData());
        if(root.getData()==k)
            return true;
        else if((root.getLchild()!=null && getPath(root.getLchild(),k,path)) ||
                (root.getRchild()!=null && getPath(root.getRchild(),k,path)))
            return true;
        path.remove(path.size()-1);
        return false;
    }

    @Test
    public static void testGetPath()
    {

//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
        TreeNode root1=new TreeNode(1);
        root1.setLchild(new TreeNode(2));
        root1.setRchild(new TreeNode(3));
        root1.getLchild().setLchild(new TreeNode(4));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(6));
        root1.getRchild().setRchild(new TreeNode(7));
        List<Integer> path= new ArrayList<>();
        getPath(root1,5,path);
        assertEquals("[1, 2, 5]",path.toString());
        assertEquals(false,getPath(root1,9,path));
        System.out.println(path.toString());
    }

    @Test
    public static void testGetLCA()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /          \
//          9            8
        TreeNode root1=new TreeNode(1);
        root1.setLchild(new TreeNode(2));
        root1.setRchild(new TreeNode(3));
        root1.getLchild().setLchild(new TreeNode(4));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(6));
        root1.getRchild().setRchild(new TreeNode(7));
        root1.getLchild().getLchild().setLchild(new TreeNode(9));
        root1.getRchild().getRchild().setRchild(new TreeNode(8));
        assertEquals(1,getLCA(root1,2,3));
        assertEquals(2,getLCA(root1,9,5));
        assertEquals(3,getLCA(root1,6,8));
        assertEquals(4,getLCA(root1,4,9));
        assertEquals(3,getLCA(root1,6,7));
        assertEquals(Integer.MIN_VALUE,getLCA(root1,11,12));
    }

    @Test
    public static void testGetLCASingleTraverse()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
//           /          \
//          9            8
        TreeNode root1=new TreeNode(1);
        root1.setLchild(new TreeNode(2));
        root1.setRchild(new TreeNode(3));
        root1.getLchild().setLchild(new TreeNode(4));
        root1.getLchild().setRchild(new TreeNode(5));
        root1.getRchild().setLchild(new TreeNode(6));
        root1.getRchild().setRchild(new TreeNode(7));
        root1.getLchild().getLchild().setLchild(new TreeNode(9));
        root1.getRchild().getRchild().setRchild(new TreeNode(8));
        assertEquals(1,getLCASingleTraverse(root1,2,3));
        assertEquals(2,getLCASingleTraverse(root1,9,5));
        assertEquals(3,getLCASingleTraverse(root1,6,8));
        assertEquals(4,getLCASingleTraverse(root1,4,9));
        assertEquals(3,getLCASingleTraverse(root1,6,7));
        assertEquals(Integer.MIN_VALUE,getLCASingleTraverse(root1,11,12));
    }
}
