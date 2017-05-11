package stack;

/**
 * Created by neha on 10/6/2016.
 */
public class TwoStack {

    private int top1, top2;
    private int arr[];
    private static final int CAPACITY = 100;
    private int size;

    TwoStack()
    {
        arr = new int[CAPACITY];
        size = CAPACITY;
        top1 = -1;
        top2 = CAPACITY;
    }

    public void push1(int p)
    {
        if (top1 < (top2-1))
        {
            arr[++top1] = p;
        }
        else
        {
            System.out.println("Stack Overflow----");
            return;
        }
    }

    public void push2(int p)
    {
        if(top2 > (top1+1))
        {
            arr[--top2] = p;
        }
        else
        {
            System.out.println("Stack Overflow----");
            return;
        }
    }

    public int pop1()
    {
        if(top1 >= 0)
        {
            return arr[top1--];
        }
        System.out.println("Stack Overflow----");
        return -999999999;
    }

    public int pop2()
    {
        if(top2 < size)
        {
            return arr[top2++];
        }
        System.out.println("Stack Overflow----");
        return -999999999;
    }
}
