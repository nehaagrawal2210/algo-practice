package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by neha on 10/6/2016.
 */
public class NextGreaterElement {

    public static void main(String args[]) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(isr);

        System.out.println("Enter length----");
        int l = Integer.parseInt(r.readLine());
        int[] a = new int[l];

        System.out.println("Enter prices----");
        for (int i = 0;i<l;i++)
        {
            a[i] = Integer.parseInt(r.readLine());
        }

        stockSpan(a);
    }

    public static void printNextGreaterElement(int[] k)
    {
        Stack<Integer> s = new Stack<>();
        s.push(k[0]);
        int current,next;
        for (int i = 1;i<k.length;i++)
        {
            next = k[i];
            if(!s.isEmpty())
            {
                current = s.pop();
                while (current < next)
                {
                    System.out.println(current + " " + next);
                    if(s.isEmpty())
                        break;
                    current = s.pop();
                }
                if(current > next)
                    s.push(current);
            }
            s.push(next);
        }
        while (!s.isEmpty())
        {
            System.out.println(s.pop() + " -1");
        }
    }

    public static void stockSpan(int price[])
    {
        int[] span = new int[price.length];
        Stack<Integer> temp = new Stack<Integer>();
        temp.push(0);
        span[0] = 1;

        for(int i=1;i<price.length;i++)
        {
            while (!temp.isEmpty() && price[temp.peek()]<= price[i])
            {
                temp.pop();
            }
            span[i] = (temp.isEmpty()) ? (i+1) : (i-temp.peek());
            temp.push(i);
        }

        //print span
        System.out.println("Span of the stocks is---");
        for (int i = 0;i<price.length;i++)
        {
            System.out.println(price[i] + "     " + span[i]);
        }

    }

}
