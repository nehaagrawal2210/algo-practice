package treePractice;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/27/2017.
 */
public class TreeTester extends TestCase {
    
    public TreeNode getTree()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
        TreeNode treeNode =new TreeNode(1);
        treeNode.setLchild(new TreeNode(2));
        treeNode.setRchild(new TreeNode(3));
        treeNode.getLchild().setLchild(new TreeNode(4));
        treeNode.getLchild().setRchild(new TreeNode(5));
        treeNode.getRchild().setLchild(new TreeNode(6));
        treeNode.getRchild().setRchild(new TreeNode(7));
        return treeNode;
    }

    public TreeNode getSkewedTree()
    {
//                    1
//               /       \
//              2         3
//             / \       / \
//            4   5     6   7
//           /     \
//          12      8
//         /         \
//       13           9
//       /             \
//      14              10
//     /                 \
//   15                   11
        TreeNode treeNode =new TreeNode(1);
        treeNode.setLchild(new TreeNode(2));
        treeNode.setRchild(new TreeNode(3));
        treeNode.getLchild().setLchild(new TreeNode(4));
        treeNode.getLchild().setRchild(new TreeNode(5));
        treeNode.getRchild().setLchild(new TreeNode(6));
        treeNode.getRchild().setRchild(new TreeNode(7));
        treeNode.getLchild().getRchild().setRchild(new TreeNode(8));
        treeNode.getLchild().getRchild().setRchild(new TreeNode(8));
        treeNode.getLchild().getRchild().getRchild().setRchild(new TreeNode(9));
        treeNode.getLchild().getRchild().getRchild().getRchild().setRchild(new TreeNode(10));
        treeNode.getLchild().getRchild().getRchild().getRchild().getRchild().setRchild(new TreeNode(11));
        treeNode.getLchild().getLchild().setLchild(new TreeNode(12));
        treeNode.getLchild().getLchild().getLchild().setLchild(new TreeNode(13));
        treeNode.getLchild().getLchild().getLchild().getLchild().setLchild(new TreeNode(14));
        treeNode.getLchild().getLchild().getLchild().getLchild().getLchild().setLchild(new TreeNode(15));
        return treeNode;
    }

    public ConnectedNode getConnectedTree()
    {
//                 1
//               /  \
//              2    3
//             / \  / \
//            4  5 6   7
        ConnectedNode treeNode =new ConnectedNode(1);
        treeNode.setLchild(new ConnectedNode(2));
        treeNode.setRchild(new ConnectedNode(3));
        treeNode.getLchild().setLchild(new ConnectedNode(4));
        treeNode.getLchild().setRchild(new ConnectedNode(5));
        treeNode.getRchild().setLchild(new ConnectedNode(6));
        treeNode.getRchild().setRchild(new ConnectedNode(7));
        return treeNode;
    }

    public ConnectedNode getConnectedSkewedTree()
    {
//                    1
//               /       \
//              2         3
//             / \       / \
//            4   5     6   7
//           /     \
//          12      8
//         /         \
//       13           9
//       /             \
//      14              10
//     /                 \
//   15                   11
        ConnectedNode treeNode =new ConnectedNode(1);
        treeNode.setLchild(new ConnectedNode(2));
        treeNode.setRchild(new ConnectedNode(3));
        treeNode.getLchild().setLchild(new ConnectedNode(4));
        treeNode.getLchild().setRchild(new ConnectedNode(5));
        treeNode.getRchild().setLchild(new ConnectedNode(6));
        treeNode.getRchild().setRchild(new ConnectedNode(7));
        treeNode.getLchild().getRchild().setRchild(new ConnectedNode(8));
        treeNode.getLchild().getRchild().setRchild(new ConnectedNode(8));
        treeNode.getLchild().getRchild().getRchild().setRchild(new ConnectedNode(9));
        treeNode.getLchild().getRchild().getRchild().getRchild().setRchild(new ConnectedNode(10));
        treeNode.getLchild().getRchild().getRchild().getRchild().getRchild().setRchild(new ConnectedNode(11));
        treeNode.getLchild().getLchild().setLchild(new ConnectedNode(12));
        treeNode.getLchild().getLchild().getLchild().setLchild(new ConnectedNode(13));
        treeNode.getLchild().getLchild().getLchild().getLchild().setLchild(new ConnectedNode(14));
        treeNode.getLchild().getLchild().getLchild().getLchild().getLchild().setLchild(new ConnectedNode(15));
        return treeNode;
    }


    @Test
    public void testGetHeight()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        assertEquals(3,tree.getHeight(root));
    }
    @Test
    public void testInOrderTraversal()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        System.out.print("Inorder: ");
        tree.inorderTraversal(root);
        System.out.println();
    }
    @Test
    public void testPreOrderTraversal()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        System.out.print("Preorder: ");
        tree.preorderTraversal(root);
        System.out.println();
    }
    @Test
    public void testPostOrderTraversal()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        System.out.print("Postorder: ");
        tree.postorderTraversal(root);
        System.out.println();
    }
    @Test
    public void testLevelOrderTraversal()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        System.out.print("Level Order: ");
        tree.levelOrderTraversal(root);
    }
    @Test
    public void testLevelOrderTraversalSeparatedByLevel()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        System.out.print("Level Order By Level: ");
        tree.levelOrderTraversalSeparatedByLevel(root);
    }
    @Test
    public void testPrintGivenLevel()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        int level=2;
        System.out.print("Given Level "+level+": ");
        tree.printGivenLevel(root,level);
        System.out.println();
    }

    @Test
    public void testGetDiameter()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        assertEquals(5,tree.getDiameter(root));
        TreeNode treeNode= getSkewedTree();
        assertEquals(11,tree.getDiameter(treeNode));
    }

    @Test
    public void testNonRecursiveInorderTraversal()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        tree.inorderTreeTraversalNonRecursive(root);
    }

    @Test
    public void testMorrisTraversal()
    {
        TreeNode root= getTree();
        BinaryTree tree=new BinaryTree();
        tree.morrisTraversal(root);
    }


    @Test
    public void testPrintAncestors()
    {
        TreeNode root=getSkewedTree();
        BinaryTree tree=new BinaryTree();
        tree.printAncestors(root,10);
        System.out.println();
    }

    @Test
    public void testIsSubtree()
    {
        TreeNode root=getSkewedTree();
        BinaryTree tree=new BinaryTree();
        assertTrue(tree.isSubTree(root,root.lchild));
    }

    @Test
    public void testConnectNodesAtSameLevel()
    {
        ConnectedNode root=getConnectedTree();
        BinaryTree tree=new BinaryTree();
        tree.connectNodesAtSameLevel(root);
        tree.printNextRight(root);
        ConnectedNode root1=getConnectedSkewedTree();
        tree.connectNodesAtSameLevel(root1);
        System.out.println();
        tree.printNextRight(root1);
    }

    @Test
    public void testConverToSumTree()
    {
        TreeNode root=getTree();
        BinaryTree tree=new BinaryTree();
        tree.convertToSumTree(root);
        tree.inorderTraversal(root);
        TreeNode root1=getSkewedTree();
        tree.convertToSumTree(root1);
        System.out.println();
        tree.inorderTraversal(root1);
    }
}
