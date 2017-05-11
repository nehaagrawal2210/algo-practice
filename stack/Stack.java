package stack;

import java.lang.reflect.Array;

/**
 * Created by neha on 21-09-2016.
 */
public class Stack<T> {
    T a[];
    int top;
    private static final int CAPACITY= 100;

    public Stack(Class<T> c)
    {
        a = (T[])Array.newInstance(c,CAPACITY);
        top = -1;
    }

    public boolean isEmpty()
    {
        if(top == -1)
            return true;
        return false;
    }

    public boolean isFull()
    {
        if(top == (CAPACITY-1))
            return true;
        return false;
    }
    public void push(T data)
    {
        if (isFull())
        {
            System.out.println("Stack is full. Operation aborted...");
            return;
        }
        a[++top] = data;
//        System.out.println("Item pushed to the minStack...");
    }

    public T pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty. Cannot pop");
            return null;
        }
        return a[top--];
    }

    public T peek()
    {
        if(!isEmpty())
        {
            return a[top];
        }
        System.out.println("Stack is empty");
        return null;
    }

    public void reverseStack()
    {
        if(!isEmpty())
        {
            T value = pop();
            reverseStack();
            reverseInsert(value);
        }
    }

    public void reverseInsert(T value)
    {
        if(isEmpty())
            push(value);
        else
        {
            T temp = pop();
            reverseInsert(value);
            push(temp);
        }
    }

    public void traverseStack()
    {
        while (!isEmpty())
        {
            System.out.println(pop());
        }
    }


    public static void main(String args[])
    {
        Stack<Integer> a = new Stack<>(Integer.class);
        a.push(5);
        a.push(4);
        a.push(7);
        a.push(1);
        a.push(2);

        a.traverseStack();
//        System.out.println(a.peek());
//        System.out.println(a.pop());
//        System.out.println(a.pop());
//        System.out.println(a.pop());
//        System.out.println(a.pop());
    }
}
