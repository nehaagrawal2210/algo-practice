package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/22/2017.
 */
//http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
public class SumList extends TestCase {
    public Node getSumList(Node list1, Node list2)
    {
        Node sumList=null,temp,sumListTemp=null;
        int carrySum=0,data1,data2,sum;
        while (list1!=null || list2!=null){
            data1= (list1!=null)?list1.data:0;
            data2= (list2!=null)?list2.data:0;
            sum= data1+data2+carrySum;
            carrySum=(sum>=10)?1:0;
            sum%=10;
            temp=new Node(sum);
            if(sumList==null)  sumList=temp;
            else sumListTemp.next=temp;
            if(list1!=null)list1=list1.getNext();
            if(list2!=null)list2=list2.getNext();
            sumListTemp=temp;
        }
        if(carrySum>0)
            sumListTemp.next= new Node(carrySum);
        return sumList;
    }

    public Node getSumList1(Node a1,Node a2)
    {
        int m1=0,m2=0;
        Node resList=null,temp,prev=null;
        while (a1!=null){
            m1=m1*10+a1.data;
            a1=a1.next;
        }
        while (a2!=null){
            m2=m2*10+a2.data;
            a2=a2.next;
        }
        int res=m1+m2;
        while (res!=0)
        {
            temp= new Node(res%10);
            res/=10;
            if(resList==null)resList=temp;
            else prev.next=temp;
            prev=temp;
        }
        return resList;
    }

    @Test
    public void testGetSumList()
    {
        Node a1 = new Node(7);
        a1.next = new Node(5);
        a1.next.next = new Node(9);
//        a1.next.next.next = new Node(4);
//        a1.next.next.next.next = new Node(6);

        Node a2 = new Node(8);
        a2.next = new Node(4);
        a2.next.next = new Node(3);

        LinkedList.traverseNode(a1);
        LinkedList.traverseNode(a2);

        Node res = getSumList(a1,a2);
        LinkedList.traverseNode(res);
    }

    @Test
    public void testGetSumList1()
    {
        Node a1 = new Node(7);
        a1.next = new Node(5);
        a1.next.next = new Node(9);
//        a1.next.next.next = new Node(4);
//        a1.next.next.next.next = new Node(6);

        Node a2 = new Node(8);
        a2.next = new Node(4);
        a2.next.next = new Node(3);

        LinkedList.traverseNode(a1);
        LinkedList.traverseNode(a2);

        Node res = getSumList1(a1,a2);
        LinkedList.traverseNode(res);
    }
}
