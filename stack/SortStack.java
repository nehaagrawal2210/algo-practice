package stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.Stack;

/**
 * Created by neha on 2/24/2017.
 */
public class SortStack extends TestCase {
    public void sortStack(java.util.Stack<Integer> s)
    {
        if(s.isEmpty()) return;
        int temp=s.pop();
        sortStack(s);
        sortedInsert(s,temp);
    }

    public void sortedInsert(Stack<Integer> s,int item)
    {
        if(s.isEmpty() || s.peek()>item){
            s.push(item);
            return;
        }
        int temp=s.pop();
        sortedInsert(s,item);
        s.push(temp);
    }

    @Test
    public void testSortStack()
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        sortStack(s);
        while (!s.isEmpty()) System.out.println(s.pop());
    }
}
