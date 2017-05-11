package stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by neha on 2/25/2017.
 */
public class StockSpan extends TestCase {
    public int[] getStockSpan(int[] a)
    {
        Stack<Integer> stack=new Stack(Integer.class);
        int[] span= new int[a.length];
        span[0]=1;
        stack.push(0);
        for (int i = 1; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peek()]<=a[i])
                stack.pop();
            span[i]=stack.isEmpty()?(i+1):(i-stack.peek());
            stack.push(i);
        }
        return span;
    }

    @Test
    public void testGetStockSpan()
    {
        int[] a= {100,80,60,70,60,75,85};
        int[] span= getStockSpan(a);
        System.out.println(Arrays.toString(span));
        assertTrue(Arrays.equals(new int[]{1,1,1,2,1,4,6},span));
        int price[] = {10, 4, 5, 90, 120, 80};
        int[] stockSpan = getStockSpan(price);
        System.out.println(Arrays.toString(stockSpan));
        assertTrue(Arrays.equals(new int[]{1,1,2,4,5,1},stockSpan));
    }
}
