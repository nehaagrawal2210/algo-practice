package queue;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/26/2017.
 */
public class QueueTester extends TestCase {
    @Test
    public void testQueue()
    {
        Queue queue=new Queue(100);
        int[] a = {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            queue.enqueue(a[i]);
        }
        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        assertEquals(3,queue.dequeue());
        assertEquals(4,queue.dequeue());
        assertEquals(5,queue.dequeue());
    }

    @Test
    public void testLinkedQueue()
    {
        LinkedQueue queue=new LinkedQueue();
        int[] a = {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            queue.enqueue(a[i]);
        }
        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        queue.enqueue(10);
        assertEquals(3,queue.dequeue());
        assertEquals(4,queue.dequeue());
        assertEquals(5,queue.dequeue());
        assertEquals(10,queue.dequeue());
        assertEquals(Integer.MIN_VALUE,queue.dequeue());
    }

    @Test
    public void testQueueUsingStacks()
    {
        QueueUsingStacks queue= new QueueUsingStacks();
        int[] a = {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            queue.enqueue(a[i]);
        }
        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        queue.enqueue(10);
        assertEquals(3,queue.dequeue());
        assertEquals(4,queue.dequeue());
        assertEquals(5,queue.dequeue());
        assertEquals(10,queue.dequeue());
        assertEquals(Integer.MIN_VALUE,queue.dequeue());

        int[] a1 = {1,2,3,4,5};
        for (int i = 0; i < a1.length; i++) {
            queue.enqueue(a1[i]);
        }

        assertEquals(1,queue.dequeueRec());
        assertEquals(2,queue.dequeueRec());
        queue.enqueue(10);
        assertEquals(3,queue.dequeueRec());
        assertEquals(4,queue.dequeueRec());
        assertEquals(5,queue.dequeueRec());
        assertEquals(10,queue.dequeueRec());
        assertEquals(Integer.MIN_VALUE,queue.dequeueRec());
    }
}
