package practice1;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringJoiner;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class StockSpan extends TestCase {

    class Stock {
        int price;
        int day;

        public Stock(int price, int day) {
            this.price = price;
            this.day = day;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Stock{");
            sb.append("price=").append(price);
            sb.append(", day=").append(day);
            sb.append('}');
            return sb.toString();
        }
    }

    @Test
    public void testSpan() {
        int[] a = { 10, 4, 5, 90, 120, 80 };
        int[] expected = { 1, 1, 2, 4, 5, 1 };
        int[] actual = stockSpan(a);
        Assert.assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    public void testSpan2() {
        int[] a = { 100, 80, 60, 70, 60, 75, 85 };
        int[] expected = { 1, 1, 1, 2, 1, 4, 6 };
        int[] actual = stockSpan(a);
        Assert.assertTrue(Arrays.equals(expected, actual));
    }

    private int[] stockSpan(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }
}
