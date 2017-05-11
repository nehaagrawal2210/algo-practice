package queue;

import java.util.*;

/**
 * Created by neha on 2/26/2017.
 */
public class MaxElemKWindow {

    public void printKMax(int[] a,int k)
    {
        int len= a.length,i,index=0;
        Deque<Integer> queue= new LinkedList<>();
        int[] maxElems=new int[len-k+1];
        for (i = 0; i < k; i++) {
            while (!queue.isEmpty() && a[i]>=queue.peekLast())
                queue.pollLast();
            queue.addLast(i);
        }

        for (; i < len; i++) {
            maxElems[index++]= queue.peekFirst();
            while (!queue.isEmpty() && queue.peekFirst()<(i-k))
                queue.pollFirst();
            while (!queue.isEmpty() && queue.peekLast()<=a[i])
                queue.pollLast();
            queue.addLast(i);
        }
        maxElems[index++]= queue.peekFirst();
    }

    
}
