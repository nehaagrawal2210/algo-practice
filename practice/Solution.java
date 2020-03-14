package practice;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        int size = 3;
        MovingAverage obj = new MovingAverage(size);
        double param_1 = obj.next(1);
        double param_2 = obj.next(10);
        System.out.println("param_2 = " + param_2);
        double param_3 = obj.next(3);
        double param_4 = obj.next(5);
    }
}

class MovingAverage {

    int window;
    int currentSum;
    int currentSize;
    Queue<Integer> q;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = size;
        currentSum = 0;
        currentSize = 0;
        q = new LinkedList<>();
    }

    public double next(int val) {
        if (currentSize >= window) {
            currentSum -= q.poll();
            currentSize--;
        }
        q.add(val);
        currentSum += val;
        currentSize++;
        double average = (double) currentSum / currentSize;
        return average;
    }
}
