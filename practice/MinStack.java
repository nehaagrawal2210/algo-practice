package practice;

import java.util.Arrays;

public class MinStack {
    private int capacity;
    private int stackTop;
    private int[] mainStack;
    private int[] minStack;
    private int minStackTop;

    public MinStack(int capacity) {
        this.capacity = capacity;
        this.stackTop = -1;
        this.minStackTop = -1;
        mainStack = new int[capacity];
        minStack = new int[capacity];
    }

    public boolean isStackFull() {
        return stackTop == capacity - 1;
    }

    public boolean isStackEmpty() {
        return stackTop == -1;
    }

    public boolean isMinStackEmpty() {
        return minStackTop == -1;
    }

    public boolean push(int value) {
        if (isStackFull()) {
            return false;
        }
        mainStack[++stackTop] = value;
        pushMin(value);
        System.out.println("Current Stack State: "+ Arrays.toString(mainStack));
        System.out.println("Current Min Stack State: "+ Arrays.toString(minStack));
        return true;
    }

    public int pop() {
        if (isStackEmpty()) {
            return Integer.MIN_VALUE;
        }
        int value = mainStack[stackTop];
        mainStack[stackTop--] = 0;
        popMin(value);
        System.out.println("Current Stack State: "+ Arrays.toString(mainStack));
        System.out.println("Current Min Stack State: "+ Arrays.toString(minStack));
        return value;
    }

    public int min() {
        if (isMinStackEmpty()) {
            return Integer.MIN_VALUE;
        }
        System.out.println("Current Stack State: "+ Arrays.toString(mainStack));
        System.out.println("Current Min Stack State: "+ Arrays.toString(minStack));
        return minStack[minStackTop];
    }

    public void popMin(int value) {
        if (value == minStack[minStackTop]) {
            minStack[minStackTop] = 0;
            minStackTop--;
        }
    }

    public void pushMin(int value) {
        if (isMinStackEmpty()) {
            minStack[++minStackTop] = value;
            return;
        }
        if (value <= minStack[minStackTop]) {
            minStack[++minStackTop] = value;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack(6);
        minStack.push(4);
        minStack.push(1);

        System.out.println("Min = " + minStack.min());

        minStack.push(5);
        minStack.push(-1);
        System.out.println("Min = " + minStack.min());
        minStack.push(10);
        System.out.println("Min = " + minStack.min());
        minStack.push(-2);
        System.out.println("Min = " + minStack.min());

        System.out.println("Element = " + minStack.pop());
        System.out.println("Min = " + minStack.min());

        System.out.println("Element = " + minStack.pop());
        System.out.println("Min = " + minStack.min());


        System.out.println("Element = " + minStack.pop());
        System.out.println("Min = " + minStack.min());

        System.out.println("Element = " + minStack.pop());
        System.out.println("Min = " + minStack.min());


        System.out.println("Element = " + minStack.pop());
        System.out.println("Min = " + minStack.min());


        System.out.println("Element = " + minStack.pop());
        System.out.println("Min = " + minStack.min());

    }
}
