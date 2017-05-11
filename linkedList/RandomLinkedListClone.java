package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/13/2017.
 */
public class RandomLinkedListClone extends TestCase{

    public RandomNode copyLinkedList(RandomNode head)
    {
        //make copy of every node
        RandomNode temp=head,cloned,clonedTemp;
        while (temp!=null)
        {
            //make a copy & insert
            RandomNode copy=new RandomNode(temp.getData());
            copy.next=temp.next;
            temp.next=copy;
            temp = temp.next!=null? temp.next.next:temp.next;
        }

        //update random pointers
        temp=head;
        while (temp!=null)
        {
            temp.next.random=temp.random.next;
            temp = temp.next!=null? temp.next.next:temp.next;
        }

        //update original list
        temp=head;
        cloned=clonedTemp=head.next;

        while (temp!=null && clonedTemp!=null)
        {
            temp.next= (temp.next!=null)?temp.next.next:temp.next;
            clonedTemp.next= (clonedTemp.next!=null)?clonedTemp.next.next:clonedTemp.next;
            temp=temp.next;
            clonedTemp=clonedTemp.next;
        }
        return cloned;
    }

    @Test
    public void testCopyLinkedList()
    {
        RandomNode start = new RandomNode(1);
        start.next = new RandomNode(2);
        start.next.next = new RandomNode(3);
        start.next.next.next = new RandomNode(4);
        start.next.next.next.next = new RandomNode(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random =
                start.next.next.next.next;
        start.next.next.next.random =
                start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random =
                start.next;

        RandomNode.traverse(start);
        RandomNode copy=copyLinkedList(start);
        RandomNode.traverse(copy);
    }

}
