package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/22/2017.
 */
//http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
public class GroupedReverse extends TestCase {
    Node result;

    public Node groupedReverse(Node list,int k)
    {
        Node curr=list,prev=null,next=null;
        int count = 0;
        while (curr!= null && count<k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!= null)
            list.next = groupedReverse(next,k);
        return prev;
    }

    public void reverse(Node curr,Node prev)
    {
        if(curr.next==null)
        {
            result= curr;
            curr.next=prev;
            return;
        }
        Node next = curr.next;
        curr.next = prev;
        reverse(next,curr);
    }

    @Test
    public void testGroupedReverse()
    {
        int [] a1 = {2,8,25,35};
        int [] a2 = {1,4,7,28,40};
        LinkedListGen list1 = new LinkedListGen();
        LinkedListGen list2 = new LinkedListGen();

        for (int i = 0; i < a1.length; i++) {
            list1.addNode(a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            list2.addNode(a2[i]);
        }
//        Node reversed = groupedReverse(list1.head,3);
//        Node reversed1 = groupedReverse(list2.head,3);
        list1.traverseList();
//        new LinkedListGen(reversed).traverseList();
//        new LinkedListGen(reversed1).traverseList();
        reverse(list1.head,null);
        new LinkedListGen(result).traverseList();
    }
}
