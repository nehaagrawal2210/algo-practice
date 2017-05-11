package linkedList;

/**
 * Created by neha on 21-09-2016.
 */
public class DoublyLinkedList {

    DoubleLinkNode head;
    DoubleLinkNode tail;

    public static void main(String args[])
    {
        DoublyLinkedList list = new DoublyLinkedList();
        list.head = new DoubleLinkNode(0);
        list.tail = list.head;
        list.append(3);
        list.append(5);
        list.append(7);
        list.append(9);

        list.traverseList();
        list.reverseTraverse();
    }

    public void push(int data)
    {
        DoubleLinkNode newNode = new DoubleLinkNode(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void append(int data)
    {
        DoubleLinkNode newNode = new DoubleLinkNode(data);
//        DoubleLinkNode temp = head;
        newNode.next = null;
//        while (temp.next!=null)
//        {
//            temp = temp.next;
//        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void traverseList()
    {
        DoubleLinkNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.getData()+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverseTraverse()
    {
        DoubleLinkNode temp = tail;
        while (temp != null)
        {
            System.out.print(temp.getData()+" ");
            temp = temp.prev;
        }
        System.out.println();
    }
}
