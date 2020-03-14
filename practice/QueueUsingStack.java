package practice;

import java.util.Stack;

public class QueueUsingStack<T> {
    private Stack<T> oldStack;
    private Stack<T> newStack;

    public QueueUsingStack() {
        oldStack = new Stack<>();
        newStack = new Stack<>();
    }

    public void enqueue(T value) {
        newStack.push(value);
    }

    private void transferStacks() {
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }
    }

    public T peek() {
        transferStacks();
        return oldStack.peek();
    }

    public T dequeue() {
        transferStacks();
        return oldStack.pop();
    }
}
