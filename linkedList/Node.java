package linkedList;

import java.util.StringJoiner;

/**
 * Created by neha on 17-09-2016.
 */
public class Node {
    public int data;
    public Node next;

    // constructor to create a new node, next will be by default Null.
    public Node(int number) {
        this.data = number;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}