package stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Array;

/**
 * Created by neha on 2/24/2017.
 */
class MinStack<T extends Comparable> extends SpecialStack {
//    http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
    SpecialStack<T> minStack;

    MinStack(Class c,int size)
    {
        super(c,size);
        minStack = new SpecialStack<T>(c,size);
    }

    @Override
    public void push(Comparable value) {
        super.push(value);
        if(minStack.isEmpty() || value.compareTo(minStack.peek())<0)
        {
            minStack.push(value);
        }
    }

    @Override
    public Comparable pop() {
        Comparable value = super.pop();
        if(minStack.peek().equals(value))
        {
            minStack.pop();
        }
        return value;
    }

    public Comparable getMin()
    {
        if(minStack.isEmpty())
        {
            System.out.println("Stack empty");
            System.exit(1);
        }
        return minStack.peek();
    }
}

class SpecialStack<T extends Comparable>{
    int top;
    Comparable[] a;
    private static int SIZE;

    SpecialStack(Class c,int size)
    {
        top = -1;
        SIZE=size;
        a = (T[]) Array.newInstance(c,size);
    }

    public boolean isFull()
    {
        if(top==SIZE-1)
            return true;
        return false;
    }

    public boolean isEmpty()
    {
        if(top==-1) return true;
        return false;
    }

    public Comparable pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return a[top--];
    }

    public void push(Comparable value)
    {
        if(isFull()){
            System.out.println("Stack is full");
            System.exit(1);
        }
        a[++top]=value;
    }

    public Comparable peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return a[top];
    }
}

public class MinStackTester extends TestCase{

    @Test
    public void testMinStack()
    {
        Integer[] a = {16,15,29,19,18};
        MinStack<Integer> minStack = new MinStack<>(Integer.class,100);
        for (int i = 0; i < a.length; i++) {
            minStack.push(a[i]);
        }
        assertEquals(15,minStack.getMin());
        minStack.pop();
        assertEquals(15,minStack.getMin());
        minStack.pop();
        assertEquals(15,minStack.getMin());
        minStack.pop();
        assertEquals(15,minStack.getMin());
        minStack.pop();
        assertEquals(16,minStack.getMin());
    }
}

