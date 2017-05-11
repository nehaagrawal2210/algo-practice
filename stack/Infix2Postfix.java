package stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by neha on 2/23/2017.
 */
//http://quiz.geeksforgeeks.org/stack-set-2-infix-to-postfix/
public class Infix2Postfix extends TestCase {
    public String infixToPostfix(String expr)
    {
        String postfixExpr="";
        char c;
        java.util.Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            c= expr.charAt(i);
            if(isOperand(c)) postfixExpr+=Character.toString(c);
            else if(c=='(') stack.push(c);
            else if(c== ')'){
                while (!stack.isEmpty() && stack.peek()!='(')
                    postfixExpr+=Character.toString(stack.pop());
                if(stack.isEmpty()) return "Invalid Expression";
                else stack.pop();
            }
            else {
                //received operator
                while (!stack.isEmpty() && getPrecedence(c)<=getPrecedence(stack.peek()))
                    postfixExpr+=Character.toString(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) postfixExpr+=Character.toString(stack.pop());
        return postfixExpr;
    }

    public boolean isOperand(char c)
    {
        return ((c>='a') && (c<='z')) || ((c>='A')&&(c<='Z'));
    }

    public int getPrecedence(char operator)
    {
        switch (operator)
        {
            case '^':
                return 3;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    @Test
    public void testGetPostfixExpr()
    {
        String expr = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(expr));
    }

}
