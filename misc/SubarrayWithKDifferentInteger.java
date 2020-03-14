package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SubarrayWithKDifferentInteger {
    public static int[] replaceElements(int[] arr) {
        Stack<Integer> s = new Stack();
        for(int i=arr.length-1;i>=0;i--){
            if(s.isEmpty() || s.peek()<=arr[i]){
                s.push(arr[i]);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(!s.isEmpty() && s.peek()==arr[i]){
                s.pop();
            }
            arr[i] = s.isEmpty()?-1:s.peek();
        }
        return arr;
    }

    public static void main(String[] args) {
    }
}
