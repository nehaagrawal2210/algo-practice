package queue;

import java.util.Stack;

/**
 * Created by neha on 2/26/2017.
 */
public class QueueUsingStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStacks()
    {
        s1= new Stack<>();
        s2= new Stack<>();
    }

    public void enqueue(int val)
    {
        s1.push(val);
    }

    public boolean isEmpty()
    {
        if(s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
    }

    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue Empty!!");
            return Integer.MIN_VALUE;
        }
        if(s2.isEmpty())
        {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int dequeueRec()
    {
        int x,res;
        if(s1.isEmpty())
        {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        else if(s1.size()==1)
            return s1.pop();
        else {
            x=s1.pop();
            res=dequeueRec();
            s1.push(x);
            return res;
        }
    }
}
