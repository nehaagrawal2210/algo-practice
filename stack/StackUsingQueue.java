package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neha on 2/26/2017.
 */
public class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue()
    {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void push(int val)
    {
        q2.add(val);
        while (!q1.isEmpty())
            q2.add(q1.remove());
        Queue q3=q1;
        q1=q2;
        q2=q3;
    }

    public int pop()
    {
        if(q1.isEmpty()){
            System.out.println("Queue is empty!");
            return Integer.MIN_VALUE;
        }
        return q1.remove();
    }

    public boolean isEmpty()
    {
        if(q1.isEmpty()) return true;
        return false;
    }
}
