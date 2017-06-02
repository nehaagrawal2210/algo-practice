package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/28/17.
 */
public class ReverseLinkedList extends TestCase {
    class node{
        int val;
        node next;
        node(int val)
        {
            this.val = val;
            this.next = null;
        }

        @Override public String toString() {
            return ""+val;
        }
    }

    public void reverseList(node head)
    {
        node prev = null,next= head;
        node tempNext;
        while (next!=null)
        {
            tempNext = next.next;
            next.next = prev;
            prev = next;
            next = tempNext;
        }
        head = prev;
        node temp = head;
        while (temp!=null)
        {
            System.out.print(temp.val+", ");
            temp=temp.next;
        }
        System.out.println();
    }

    public node reverseList(node head,int k)
    {
        node prev=null,next=null,current=head;
        int count = 0;
        while(current!=null && count<k)
        {
            next = current.next;
            current.next=prev;
            prev = current;
            current = next;
            count++;
        }
        if(next!=null)
        {
            head.next=reverseList(next,k);
        }
        return prev;
    }

    public void testReverse()
    {
        node a = new node(1);
        a.next = new node(2);
        a.next.next = new node(3);
        a.next.next.next = new node(4);
        a.next.next.next.next = new node(5);
        a.next.next.next.next.next = new node(6);
        node b = reverseList(a,2);
        while (b!=null)
        {
            System.out.print(b.val+",");
            b=b.next;
        }
    }
}
