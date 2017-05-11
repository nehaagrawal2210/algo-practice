package linkedList;

/**
 * Created by neha on 2/13/2017.
 */
public class RandomNode{
    RandomNode random;
    RandomNode next;
    int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public RandomNode(int data)
    {
        this.data=data;
        random=null;
    }

    public static void traverse(RandomNode r)
    {
        while (r!=null)
        {
            System.out.print(" Data: "+r.getData());
            if(r.random!=null)System.out.print(" Random: "+r.random.getData());
            System.out.println();
            r=r.next;
        }
        System.out.println("---------------------------------");
    }

    public RandomNode getNext() {
        return next;
    }

    public void setNext(RandomNode next) {
        this.next = next;
    }

    public RandomNode getRandom() {
        return random;
    }

    public void setRandom(RandomNode random) {
        this.random = random;
    }
}
