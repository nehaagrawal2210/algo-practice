package queue;

/**
 * Created by neha on 2/25/2017.
 */
public class Queue {
    int rear;
    int front;
    int[] a;
    int CAPACITY;
    int size;

    public Queue(int capacity) {
        CAPACITY =capacity;
        a=new int[capacity];
        size=0;
        rear=front=-1;
    }

    public boolean isFull()
    {
        if(size==CAPACITY)
            return true;
        return false;
    }

    public boolean isEmpty()
    {
        if(size==0) return true;
        return false;
    }

    public void enqueue(int val)
    {
        if(isFull())
        {
            System.out.println("Queue Full!");
            return;
        }
        else if(rear==-1)
        {
            front=0;
            rear=0;
            a[rear]=val;
        }
        else{
            rear=(rear+1)%CAPACITY;
            a[rear]=val;
        }
        size++;
    }

    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue Empty!!");
            return Integer.MIN_VALUE;
        }
        int item= a[front];
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else front=(front+1)%CAPACITY;
        size--;
        return item;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue Empty");
            return Integer.MIN_VALUE;
        }
        return a[front];
    }

    public int getSize()
    {
        return size;
    }
}
