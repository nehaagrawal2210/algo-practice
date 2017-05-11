package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/23/2017.
 */
public class CircularLinkedList extends TestCase {

    public void traverse(Node list)
    {
        if(list==null) return;
        Node first = list;
        do{
            System.out.print(first.getData()+" ");
            first=first.getNext();
        }while (first!=list);
        System.out.println();
    }

    public void split(Node list){
        if(list==null) return;
        Node slow=list,fast=list;
        while (fast.next!=list && fast.next.next!=list)
        {
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        if(fast.next.next==list)
            fast=fast.getNext(); //move fast to last node
        Node head1=slow.getNext();
        fast.next=head1;
        slow.next=list;
        traverse(list);
        traverse(head1);
    }

    @Test
    public void testTraverse()
    {
        //       50->20->15->4->10->11->12
        Node head2 = new Node(50);
        head2.next = new Node(20);
        head2.next.next = new Node(15);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(10);
        head2.next.next.next.next.next = new Node(11);
        head2.next.next.next.next.next.next = new Node(12);
        head2.next.next.next.next.next.next.next=head2;
        traverse(head2);
    }

    @Test
    public void testSplit()
    {
        //       50->20->15->4->10->11
        Node head2 = new Node(50);
        head2.next = new Node(20);
        head2.next.next = new Node(15);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(10);
        head2.next.next.next.next.next = new Node(11);
//        head2.next.next.next.next.next.next = new Node(12);
        head2.next.next.next.next.next.next=head2;
        split(head2);
    }
}
