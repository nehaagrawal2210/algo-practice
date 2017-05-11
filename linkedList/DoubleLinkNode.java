package linkedList;

/**
 * Created by neha on 21-09-2016.
 */
public class DoubleLinkNode<T> {
    T data;
    DoubleLinkNode next;
    DoubleLinkNode prev;

    public DoubleLinkNode(T data) {
        this.data = data;
        next=null;
        prev=null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleLinkNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkNode next) {
        this.next = next;
    }

    public DoubleLinkNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkNode prev) {
        this.prev = prev;
    }

    public String toString()
    {
        return data+"";
    }
}
