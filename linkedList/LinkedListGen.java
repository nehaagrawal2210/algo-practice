package linkedList;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/22/2017.
 */
//http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
public class LinkedListGen extends TestCase{

    Node head;

    public LinkedListGen(Node head) {
        this.head = head;
    }

    public LinkedListGen(){
        head = null;
    }

    public void addNode(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next!= null)
            temp = temp.getNext();
        temp.next = newNode;
    }

    public void reverseList()
    {
        Node curr=head,prev=null,next;
        while (curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        head= prev;
    }

    public void traverseList()
    {
        Node temp = head;
        while (temp!=null)
        {
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    @Test
    public void testReverseList()
    {
        LinkedListGen list = new LinkedListGen();
        int[] a = {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            list.addNode(a[i]);
        }
        list.traverseList();
        list.reverseList();
        list.traverseList();
    }

}
