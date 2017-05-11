package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/22/2017.
 */
public class LoopLinkedList extends TestCase{
//    http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
    public Node detectLoop(Node head)
    {
        Node slow=head,fast=head;
        while (slow!=null && fast!=null && fast.next!=null)
        {
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast)
                return slow;
        }
        return null;
    }

    public void removeLoop1By1(Node head)
    {
        Node loop= detectLoop(head);
        if(loop==null)
            return; //no loop in list
        Node temp=head,loopTemp;
        while (true){
            loopTemp=loop;
            while (loopTemp.next!=loop && loopTemp.next!=temp)
                loopTemp=loopTemp.getNext();
            if(loopTemp.next==temp)
                break;
            temp=temp.getNext();
        }
        loopTemp.next=null; //remove loop
    }

    public void removeLoopCount(Node head)
    {
        Node loop= detectLoop(head);
        if(loop==null)
            return;
        Node loop1=loop,loop2=loop;

        //count loop nodes:k
        int count=1;
        while (loop1.next!=loop2)
        {
            count++;
            loop1=loop1.getNext();
        }

//      fix one pointer at head & other at k nodes after head
        loop1=loop2=head;
        for (int i = 0; i <count ; i++) {
            loop2=loop2.getNext();
        }

//        they will meet at loop starting node
        while (loop1.next!=loop2.next){
            loop1=loop1.getNext();
            loop2=loop2.getNext();
        }
        
        loop2.next=null;
    }

    public void removeLoop(Node head)
    {
        Node loop= detectLoop(head);
        if(loop== null)
            return;
        Node tempHead= head;
        while (tempHead.next != loop.next)
        {
            tempHead=tempHead.getNext();
            loop=loop.getNext();
        }
        loop.next=null;
    }

    @Test
    public void testDetectLoop()
    {
        //        2.4.3.4.2.15__
//                      |___________|
        Node head=new Node(2);
        head.next=new Node(4);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(2);
        head.next.next.next.next.next=new Node(15);
        head.next.next.next.next.next.next= head.next.next;

        assertNotNull(detectLoop(head));

        //        2.4.3.4.2.15
        Node head1=new Node(2);
        head1.next=new Node(4);
        head1.next.next=new Node(3);
        head1.next.next.next=new Node(4);
        head1.next.next.next.next=new Node(2);
        head1.next.next.next.next.next=new Node(15);

        assertNull(detectLoop(head1));
    }

    @Test
    public void testRemoveLoop1By1()
    {
//                2.4.3.4.2.15__
//                      |___________|
        Node head=new Node(2);
        head.next=new Node(4);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(2);
        head.next.next.next.next.next=new Node(15);
        head.next.next.next.next.next.next= head.next.next;

        assertNotNull(detectLoop(head));
        removeLoop1By1(head);
        assertNull(detectLoop(head));
        LinkedList.traverseNode(head);
    }

    @Test
    public void testRemoveLoopByCount()
    {
//                2.4.3.4.2.15__
//                      |___________|
        Node head=new Node(2);
        head.next=new Node(4);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(2);
        head.next.next.next.next.next=new Node(15);
        head.next.next.next.next.next.next= head.next.next;

        assertNotNull(detectLoop(head));
        removeLoopCount(head);
        assertNull(detectLoop(head));
        LinkedList.traverseNode(head);
    }

    @Test
    public void testRemoveLoop()
    {
//                2.4.3.4.2.15______
//                      |___________|
        Node head=new Node(2);
        head.next=new Node(4);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(2);
        head.next.next.next.next.next=new Node(15);
        head.next.next.next.next.next.next= head.next.next;

        assertNotNull(detectLoop(head));
        removeLoop(head);
        assertNull(detectLoop(head));
        LinkedList.traverseNode(head);

        Node head2 = new Node(50);
        head2.next = new Node(20);
        head2.next.next = new Node(15);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(10);
 
    /* Create a loop for testing */
        head2.next.next.next.next.next = head2.next.next;
        assertNotNull(detectLoop(head2));
        removeLoop(head2);
        assertNull(detectLoop(head2));
        LinkedList.traverseNode(head2);
    }
}
