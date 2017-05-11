package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/23/2017.
 */
//http://www.geeksforgeeks.org/rotate-a-linked-list/
public class RotationLinkedList extends TestCase {
    public Node rotate(Node list,int k)
    {
        if(k==0) return list;
        Node kth=null,last=list,tempHead=list,k1th;
        int c=1;
        while (last.next!=null){
            if(c==k) kth=last;
            last = last.getNext();
            c++;
        }
        if(c==k) return list;
        if(c<k) return null;
        k1th=kth.getNext();
        kth.next=null;
        last.next=tempHead;
        list=k1th;
        return list;
   }

   @Test
    public void testRotate()
   {
//       50->20->15->4->10->11->12
       Node head2 = new Node(50);
       head2.next = new Node(20);
       head2.next.next = new Node(15);
       head2.next.next.next = new Node(4);
       head2.next.next.next.next = new Node(10);
       head2.next.next.next.next.next = new Node(11);
       head2.next.next.next.next.next.next = new Node(12);

       Node rotated = rotate(head2,8);
       LinkedList.traverseNode(rotated);
       LinkedList.traverseNode(head2);
   }
}
