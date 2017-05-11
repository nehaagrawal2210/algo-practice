package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 1/16/2017.
 */
public class ListMergeSort extends TestCase{

    public Node  merge(Node a1,Node a2)
    {
        Node res=new Node(Integer.MAX_VALUE); //dummy node
        Node resTemp=res;
        while (a1!=null && a2!=null)
        {
            if(a1.data<=a2.data)
            {
                resTemp.next=a1;
                a1=a1.next;
            }
            else {
                resTemp.next=a2;
                a2=a2.next;
            }
            resTemp=resTemp.next;
        }
        if(a1!=null) resTemp.next=a1;
        if(a2!=null) resTemp.next=a2;
        return res.next;
    }

    public Node[] split(Node a)
    {
        Node slow=a,fast=a;
        while (fast.next!=null && fast.next.next!=null)
        {
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        Node[] res = new Node[2];
        res[1]= slow.next;
        slow.next=null;
        res[0]=a;
        return res;
    }

    public Node mergeSort(Node head)
    {
        if(head==null || head.next==null)
            return head; //<2 elems already sorted no need to split
        Node splitted[] = split(head);
        splitted[0] = mergeSort(splitted[0]);
        splitted[1] = mergeSort(splitted[1]);
        return merge(splitted[0],splitted[1]);
    }

    @Test
    public void testMergeSort()
    {
        //       50->20->15->4->10->11->12
        Node head2 = new Node(50);
        head2.next = new Node(20);
        head2.next.next = new Node(15);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(10);
        head2.next.next.next.next.next = new Node(11);
        head2.next.next.next.next.next.next = new Node(12);

        Node res=mergeSort(head2);
        LinkedList.traverseNode(res);
    }
}
