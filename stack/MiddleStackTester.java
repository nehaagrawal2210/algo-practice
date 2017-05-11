package stack;

import linkedList.DoubleLinkNode;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/25/2017.
 */
//http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
class MiddleStack {
    DoubleLinkNode<Integer> head;
    DoubleLinkNode<Integer> middle;
    int count;

    public MiddleStack()
    {
        head=null;
        middle=null;
        count=0;
    }

    public boolean isEmpty()
    {
        if(count==0) return true;
        return false;
    }

    public void push(int value)
    {
        DoubleLinkNode stackNode = new DoubleLinkNode(value);
        count++;
        if(count==1)
        {
            //first node
            head = stackNode;
            middle = stackNode;
        }
        else {
            //make stackNode as head
            stackNode.setNext(head);
            stackNode.setPrev(null);
            head.setPrev(stackNode);
            head = stackNode;

            if(count%2==0)
            {
                //move middle pointer up
                middle=middle.getPrev();
            }
        }
    }

    public int pop()
    {
        if(count==0)
        {
            System.out.println("Stack empty");
            return Integer.MIN_VALUE;
        }

        int val= head.getData();
        count--;
        if(count%2!=0)
        {
            //move down middle if count becomes odd
            middle=middle.getNext();
        }
        //update head pointers
        DoubleLinkNode newHead= head.getNext();
        head.setNext(null);
        if(newHead!=null)newHead.setPrev(null);
        head=newHead;
        return val;
    }

    public int getMiddle()
    {
        if(count==0)
        {
            System.out.println("Stack empty!!");
            return Integer.MIN_VALUE;
        }
        return middle.getData();
    }

    public int deleteMiddle()
    {
        if(count==0)
        {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int val=middle.getData();
        count--;
        if(count==0) //no remaining nodes
        {
            head=null;
            middle=null;
            return val;
        }
        if(count==1) //only 1 remaining node
        {
            //head is middle elem, 2 elems in stack
            middle=middle.getNext();
            head=head.getNext();
            head.setPrev(null);
            return val;
        }
        //more than 2 elems
        DoubleLinkNode newMiddle= (count%2!=0)?middle.getNext():middle.getPrev();
        middle.getPrev().setNext(middle.getNext());
        middle.getNext().setPrev(middle.getPrev());
        middle.setNext(null);
        middle.setPrev(null);
        middle=newMiddle;
        return val;
    }
}

public class MiddleStackTester extends TestCase{
    @Test
    public void testMiddleStack()
    {
        MiddleStack stack = new MiddleStack();
        Integer[] a = {16,15,29,19,18};
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
        }
        assertEquals(29,stack.getMiddle());
        assertEquals(18,stack.pop());
        assertEquals(29,stack.getMiddle());
        assertEquals(19,stack.pop());
        assertEquals(15,stack.getMiddle());
        assertEquals(29,stack.pop());
        assertEquals(15,stack.getMiddle());
        assertEquals(15,stack.pop());
        assertEquals(16,stack.getMiddle());
        assertEquals(16,stack.pop());

        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
        }

        assertEquals(29,stack.deleteMiddle());
        assertEquals(19,stack.deleteMiddle());
        assertEquals(15,stack.deleteMiddle());
        assertEquals(18,stack.deleteMiddle());
        assertEquals(16,stack.deleteMiddle());
    }
}
