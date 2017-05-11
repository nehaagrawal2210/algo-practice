package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by neha on 2/5/2017.
 */
public class PostfixExpConversionONP {

    public static String getReversePolishNotation(String s)
    {
        Stack<Character> stack=new Stack<>();
        char k;

        String postfix="";

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='(')
                stack.push(c);
            else if((c>='a' && c<='z') || (c>='A' && c<='Z'))
                postfix+=c;
            else if(c==')')
            {
                while ((k=stack.pop())!='(')
                {
                    postfix+=k;
                }
            }
            else { //c will be an operator
                while (getPrecedence(stack.peek())!=-1 && getPrecedence(stack.peek())>=getPrecedence(c))
                    {
                        postfix+=stack.pop();
                    }
                    stack.push(c);
            }
        }
        while (!stack.isEmpty())
            postfix+=stack.pop();
        return postfix;
    }

    public static int getPrecedence(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            String expr=br.readLine();
            String postfixExpr= getReversePolishNotation(expr);
            System.out.println(postfixExpr);
        }

    }
}
