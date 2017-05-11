package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neha on 2/16/2017.
 */
public class ChildSumPropertyNAry extends TestCase{

    class TreeNodeNAry{
        int data;
        List<TreeNodeNAry> children;

        public TreeNodeNAry(int data)
        {
            this.data = data;
            children = new ArrayList<>();
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public boolean childSumProperty(TreeNodeNAry root)
    {
        if(root==null || root.children.isEmpty())
            return true;

        int sum = root.children.parallelStream().mapToInt(i->i.getData()).sum();

        if(sum!=root.getData())
            return false;

        for (int i = 0; i < root.children.size(); i++) {
            if(!childSumProperty(root.children.get(i)))
                return false;
        }
        return true;
    }

    @Test
    public void testChildSumProperty()
    {
//               20
//           /  \    \
//         10    3    7
//        / \ \   \   / \
//       5  3  2   3  4  3
        TreeNodeNAry root = new TreeNodeNAry(20);
        root.children.add(new TreeNodeNAry(10));
        root.children.add(new TreeNodeNAry(3));
        root.children.add(new TreeNodeNAry(7));

        //2nd level
        root.children.get(0).children.add(new TreeNodeNAry(5));
        root.children.get(0).children.add(new TreeNodeNAry(3));
        root.children.get(0).children.add(new TreeNodeNAry(2));

        root.children.get(1).children.add(new TreeNodeNAry(3));

        root.children.get(2).children.add(new TreeNodeNAry(4));
        root.children.get(2).children.add(new TreeNodeNAry(3));

        assertEquals(true,childSumProperty(root));

    }
}
