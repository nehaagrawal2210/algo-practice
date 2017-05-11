package stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.Stack;

/**
 * Created by neha on 2/24/2017.
 */
public class PostfixExprEvaluation extends TestCase{
    public int getResult(String expr)
    {
        Stack<Integer> stack = new Stack<>();
        char c;
        int a1,a2;
        for (int i = 0; i < expr.length(); i++) {
            c=expr.charAt(i);
            if(isNumber(c)) stack.push(Character.getNumericValue(c));
            else if(isOperator(c)){
                a1=stack.pop();
                a2=stack.pop();
                switch (c)
                {
                    case '+': stack.push(a1+a2); break;
                    case '/': stack.push(a2/a1); break;
                    case '*': stack.push(a2*a1); break;
                    case '-': stack.push(a2-a1); break;
                    case '^': stack.push((int)Math.pow(a2,a1));
                }
            }
            else {
                System.out.println("Invalid Expr");
                return Integer.MIN_VALUE;
            }
        }
        return stack.pop();
    }

    public boolean isNumber(char c)
    {
        return (c>='0' && c<='9');
    }
    public boolean isOperator(char c)
    {
        return (c=='+' || c=='/' || c=='*' || c=='-' || c=='^');
    }

    @Test
    public void testGetResult()
    {
        String expr = "231*+9-";
        String expr1= "23^5+";
        assertEquals(-4,getResult(expr));
        assertEquals(13,getResult(expr1));
    }
}
