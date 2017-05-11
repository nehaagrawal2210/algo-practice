package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/22/2017.
 */
//http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
public class SortedMerge extends TestCase{

    public Node sortedMerge(Node a1, Node a2)
    {
        Node res = new Node(Integer.MAX_VALUE),resTemp=res;
        while (a1!= null && a2!=null)
        {
            if(a1.data <= a2.data)
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
        if (a1!=null) resTemp.next=a1;
        if (a2!=null) resTemp.next=a2;
        return res.next;
    }

    @Test
    public void testSortedMerge()
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
        Node sortedList = sortedMerge(list1.head,list2.head);
        LinkedListGen sorted = new LinkedListGen(sortedList);
        sorted.traverseList();
    }
}
