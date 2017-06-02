package practice;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by neagrawa on 5/29/17.
 */
public class NextGreaterElement extends TestCase{
    public void getNextGreaterElem(int[] a)
    {
        Stack<Integer> stack = new Stack<>();
        int ng;
        for (int i = a.length-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek()<=a[i])
                stack.pop();
            if(!stack.isEmpty()) ng = stack.peek();
            else ng = -1;
            stack.push(a[i]);
            a[i]=ng;
        }
        System.out.println(Arrays.toString(a));
    }

    public void testGetNg()
    {
        int[] a={4,5,2,25};
        int[] a1={11,13,21,3};
        getNextGreaterElem(a);
        getNextGreaterElem(a1);
    }
}
