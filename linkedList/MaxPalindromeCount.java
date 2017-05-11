package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/13/2017.
 */
public class MaxPalindromeCount extends TestCase{

    public int getMaxPalindromeLength(Node head)
    {
        Node next,prev=null,current=head;
        int result=0;

        while (current!=null)
        {
            next=current.next;
            current.next=prev;

            result=Math.max(result,2*countCommon(prev,next)+1); //odd
            result=Math.max(result,2*countCommon(current,next)); //even

            prev=current;
            current=next;
        }
        return result;
    }

    public int countCommon(Node a1,Node a2)
    {
        int c=0;
        for(;a1!=null && a2!=null;a1=a1.next,a2=a2.next)
        {
            if(a1.getData()==a2.getData())
                c++;
            else
                break;
        }
        return c;
    }

    @Test
    public void testGetMaxPalindromeLength()
    {
//        2->4->3->4->2->15
        Node head=new Node(2);
        head.next=new Node(4);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(2);
        head.next.next.next.next.next=new Node(15);
        LinkedList.traverseNode(head);
        assertEquals(5,getMaxPalindromeLength(head));
    }
}
