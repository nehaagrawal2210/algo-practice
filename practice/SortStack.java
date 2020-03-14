package practice;

import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    private Stack<Integer> stack;
    private Stack<Integer> bufferStack;

    public SortStack() {
        stack = new Stack<>();
        bufferStack = new Stack<>();
    }

    public void push(int a) {
        stack.push(a);
    }

    public int pop() {
        return stack.pop();
    }

    public void sort() {
        while (!stack.isEmpty()) {
            int currentElement = stack.pop();
            while (!bufferStack.isEmpty() && bufferStack.peek() < currentElement) {
                stack.push(bufferStack.pop());
            }
            bufferStack.push(currentElement);
        }
        while (!bufferStack.isEmpty()) {
            stack.push(bufferStack.pop());
        }
        System.out.println("Sorted list: " + Arrays.toString(stack.toArray()));
    }

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        sortStack.push(5);
        sortStack.push(10);
        sortStack.push(1);
        sortStack.push(-1);
        sortStack.push(11);
        sortStack.push(0);
        sortStack.push(3);
        sortStack.sort();
    }
}
