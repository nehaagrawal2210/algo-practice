package stack;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/25/2017.
 */
//    http://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
class SpecialMinStack {

    SpecialStack<Integer> stack;
    int minElem;

    public SpecialMinStack(int size){
        stack = new SpecialStack<>(Integer.class,size);
    }

    public void push(Integer value)
    {
        if(stack.isEmpty()) {
            minElem=value;
            stack.push(value);
        }
        else if(value.compareTo(minElem)>=0)
            stack.push(value);
        else {
            int tempVal= value;
            value=2*value-minElem;
            stack.push(value);
            minElem=tempVal;
        }
    }

    public Integer pop()
    {
        if(stack.isEmpty())
        {
            System.out.println("Stack empty");
            return null;
        }

        Integer val= (Integer) stack.pop();
        if(val>=minElem)
            return val;

        int temp = minElem;
        minElem = 2*minElem-val;
        return temp;
    }

    public Comparable peek()
    {
        return stack.peek();
    }

    public int getMin()
    {
        if(stack.isEmpty())
        {
            System.out.println("Stack empty!!");
            return Integer.MIN_VALUE;
        }
        return minElem;
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public boolean isFull()
    {
        return stack.isFull();
    }
}

public class SpecialMinStackTester extends TestCase{

    @Test
    public void testSpecialMinStack()
    {
        Integer[] a = {16,15,29,19,18};
        SpecialMinStack minStack = new SpecialMinStack(100);
        for (int i = 0; i < a.length; i++) {
            minStack.push(a[i]);
        }

        System.out.println("Min= "+minStack.getMin());
        assertEquals(15,minStack.getMin());
        System.out.println("Pop= "+minStack.pop()+" Min= "+minStack.getMin());
        assertEquals(15,minStack.getMin());
        System.out.println("Pop= "+minStack.pop()+" Min= "+minStack.getMin());
        assertEquals(15,minStack.getMin());
        System.out.println("Pop= "+minStack.pop()+" Min= "+minStack.getMin());
        assertEquals(15,minStack.getMin());
        System.out.println("Pop= "+minStack.pop()+" Min= "+minStack.getMin());
        assertEquals(16,minStack.getMin());
    }
}
