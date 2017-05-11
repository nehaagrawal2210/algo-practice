package array;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by neha on 2/21/2017.
 */
public class Leaders extends TestCase{
    public void getLeaders(int[] a)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length-1; i >= 0 ; i--) {
            if(stack.isEmpty()) stack.push(a[i]);
            else if(a[i]>stack.peek()) stack.push(a[i]);
        }
        while (!stack.isEmpty()) System.out.print(stack.pop()+" ");
        System.out.println();
    }

    @Test
    public void testGetLeaders()
    {
        int a[] = {16, 17, 4, 3, 5, 2};
        int a1[] = {1,2,3,4,5};
        int a2[] = {5,4,3,2,1};
        getLeaders(a);
        getLeaders(a1);
        getLeaders(a2);
    }
}
