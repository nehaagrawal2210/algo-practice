package linkedList;

/**
 * Created by neha on 2/20/2017.
 */
public class DoubleLinkedList<T> {

    //This is for cache
    private DoubleLinkNode<T> head;
    private DoubleLinkNode<T> tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public DoubleLinkNode getHead() {
        return head;
    }

    public void setHead(DoubleLinkNode head) {
        this.head = head;
    }

    public DoubleLinkNode getTail() {
        return tail;
    }

    public void setTail(DoubleLinkNode tail) {
        this.tail = tail;
    }


    public void printList() {
        DoubleLinkNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }

    public void moveNodeToHead(DoubleLinkNode doubleLinkNode) {
        if (doubleLinkNode == null || doubleLinkNode == head)
            return;

        //if node is at last
        if (doubleLinkNode == getTail()) {
            tail = doubleLinkNode.getPrev();
            tail.setNext(null);
        }

        //remove from mid
        else {
            DoubleLinkNode prevNode = doubleLinkNode.getPrev();
            DoubleLinkNode nextNode = doubleLinkNode.getNext();

            prevNode.setNext(doubleLinkNode.getNext());
            nextNode.setPrev(doubleLinkNode.getPrev());
        }

        //move to head
        doubleLinkNode.setNext(getHead());
        getHead().setPrev(doubleLinkNode);
        doubleLinkNode.setPrev(null);
        setHead(doubleLinkNode);
    }

    public DoubleLinkNode addNodeToHead(T data) {
        DoubleLinkNode doubleLinkNode = new DoubleLinkNode(data);

        if(getHead()==null)
        {
            //first page
            setTail(doubleLinkNode);
            setHead(doubleLinkNode);
            return doubleLinkNode;
        }

        //add the node to the head
        doubleLinkNode.setNext(getHead());
        getHead().setPrev(doubleLinkNode);
        doubleLinkNode.setPrev(null);
        setHead(doubleLinkNode);
        return doubleLinkNode;
    }

    public void removeTail()
    {
        setTail(getTail().getPrev());
        getTail().setNext(null);
    }
}
