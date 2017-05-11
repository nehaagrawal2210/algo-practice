package stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.Stack;

/**
 * Created by neha on 2/24/2017.
 */
public class RecursionReverse extends TestCase{
    public java.util.Stack reverse(Stack a,Stack m)
    {
        if(a.isEmpty()) return m;
        m.push(a.pop());
        m= reverse(a,m);
        return m;
    }

    public void insertAtBottom(Stack<Integer> stack,int item)
    {
        if(stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int temp= stack.pop();
        insertAtBottom(stack,item);
        stack.push(temp);
    }

    public void reverse(Stack<Integer> s)
    {
        if(s.isEmpty()) return;
        int item = s.pop();
        reverse(s);
        insertAtBottom(s,item);
    }

    @Test
    public void testReverse()
    {
        Stack a = new Stack();
        a.push(4);
        a.push(3);
        a.push(2);
        a.push(1);

        Stack m = reverse(a,new Stack());
        while (!m.isEmpty()) System.out.println(m.pop());
    }

    @Test
    public void testReverseRec()
    {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        reverse(s);
        while (!s.isEmpty()) System.out.println(s.pop());
    }
}
