package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/23/2017.
 */
public class TreeToCircularDLL extends TestCase {
//    http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
    public DoubleLinkNode concatenate(DoubleLinkNode a1, DoubleLinkNode a2)
    {
        if(a1==null) return a2;
        if(a2==null) return a1;
        DoubleLinkNode last1= a1.getPrev(); //to join the lists
        DoubleLinkNode last2= a2.getPrev(); //to make list circular

        //join the lists
        last1.setNext(a2);
        a2.setPrev(last1);

        //set circular list to point new head & prev to new last
        last2.setNext(a1);
        a1.setPrev(last2);

        return a1;
    }

    public DoubleLinkNode treeToCDLL(DoubleLinkNode root)
    {
        if(root==null)
            return null;
        DoubleLinkNode left= treeToCDLL(root.getPrev());
        DoubleLinkNode right= treeToCDLL(root.getNext());
        root.setPrev(root);
        root.setNext(root);
        return concatenate(concatenate(left,root),right);
    }

    public void display(DoubleLinkNode list)
    {
        if(list==null) return;
        DoubleLinkNode temp=list;
        do{
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }while (temp!=list);
        System.out.println();
    }
    
    @Test
    public void testTreeToCDLL()
    {
//                1
//             /    \
//            2      3
//          /  \   /   \
//        4     5  6    7

        DoubleLinkNode root = new DoubleLinkNode(1);
        root.prev = new DoubleLinkNode(2);
        root.next = new DoubleLinkNode(3);
        root.prev.prev = new DoubleLinkNode(4);
        root.prev.next = new DoubleLinkNode(5);
        root.next.prev = new DoubleLinkNode(6);
        root.next.next = new DoubleLinkNode(7);
        DoubleLinkNode res= treeToCDLL(root);
        display(res);
    }
}
