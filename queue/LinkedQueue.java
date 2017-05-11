package queue;

import linkedList.Node;

/**
 * Created by neha on 2/26/2017.
 */
public class LinkedQueue {
    Node front;
    Node rear;
    int size;

    LinkedQueue()
    {
        size=0;
        front=rear=null;
    }

    public boolean isEmpty()
    {
        if(size==0) return true;
        return false;
    }

    public void enqueue(int value)
    {
        Node newNode=new Node(value);
        if(size==0)
        {
            front=rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
        size++;
    }

    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        int value=front.getData();
        front=front.getNext();
        if(front==null) rear=null;
        size--;
        return value;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return front.getData();
    }

    public int getSize()
    {
        return size;
    }
}
