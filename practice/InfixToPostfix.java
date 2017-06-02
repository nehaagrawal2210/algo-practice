package practice;

import junit.framework.TestCase;

import java.util.Stack;

/**
 * Created by neagrawa on 5/29/17.
 */
public class InfixToPostfix extends TestCase {
    public String convert(String infix)
    {
        String res="";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if(c=='(')
                stack.push(c);
            else if(c==')')
            {
                while (!stack.isEmpty() && stack.peek()!='(')
                    res+=stack.pop();
                stack.pop();
            }
            else if(isOperator(c))
            {
                while (!stack.isEmpty() && getPriority(c)<=getPriority(stack.peek()))
                    res+=stack.pop();
                stack.push(c);
            }
            else //this is operand
            res+=c;
        }
        while (!stack.isEmpty()) res+=stack.pop();
        return res;
    }


    public boolean isOperator(char c)
    {
        return c=='+' || c=='-' || c=='/' || c=='*' || c=='^';
    }

    public int getPriority(char c)
    {
        switch (c)
        {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    public boolean isOperand(char c)
    {
        int val = Character.getNumericValue(c);
        return val>=0 && val<=9;
    }

    public int evaluate(String postfix)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if(isOperand(c)) stack.push(Character.getNumericValue(c));
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(getValue(val1,val2,c));
            }
        }
        return stack.pop();
    }

    public int getValue(int val1,int val2,char c)
    {
        switch (c)
        {
            case '+':
                return val1+val2;
            case '-':
                return val2-val1;
            case '*':
                return val1*val2;
            case '/':
                return val2/val1;
            case '^':
                return (int)Math.pow(val2,val1);
            default:
                return Integer.MAX_VALUE;
        }
    }

    public void testConvert()
    {
        String exp="a+b*(c^d-e)^(f+g*h)-i";
        assertEquals("abcd^e-fgh*+^*+i-",convert(exp));
        assertEquals(-4,evaluate("231*+9-"));
    }
}
