package stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.Stack;

/**
 * Created by neha on 2/24/2017.
 */
public class NextGreaterElement extends TestCase{
    public void getNextGreaterElem(int[] a)
    {
        java.util.Stack<Integer> stack= new Stack();
        int cge;
        for (int i = a.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek()<=a[i])
                stack.pop();
            if(!stack.isEmpty()) cge= stack.peek();
            else cge=-1;
            stack.push(a[i]);
            a[i]=cge;
        }
    }

    @Test
    public void testGetNextGreaterElem()
    {
        int[] a1={4,5,2,25};
        int[] a2={13,7,6,12};

        System.out.println(Arrays.toString(a1));
        getNextGreaterElem(a1);
        System.out.println(Arrays.toString(a1));

        System.out.println(Arrays.toString(a2));
        getNextGreaterElem(a2);
        System.out.println(Arrays.toString(a2));
    }
}
