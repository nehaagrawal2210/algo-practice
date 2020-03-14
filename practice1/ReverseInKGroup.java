package practice1;

import junit.framework.TestCase;
import linkedList.Node;

public class ReverseInKGroup extends TestCase {

    public void testReverse() {
        Node a1 = new Node(1);
        a1.next = new Node(2);
        a1.next.next = new Node(3);
        a1.next.next.next = new Node(4);
        a1.next.next.next.next = new Node(5);
        a1.next.next.next.next.next = new Node(6);

        a1.traverse(a1);
        Node reversed = reverse(a1, 4);
        reversed.traverse(reversed);
    }

    private int countSize(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private Node reverse(Node node, int k) {
        int count = countSize(node);
        Node res = reverse(node, k, count / k);
        return res;
    }

    private Node reverse(Node node, int k, int groupSize) {

        if (node == null || node.next == null || groupSize <= 0) {
            return node;
        }

        int count = k;
        Node curr = node, prev = null, next = null;
        while (curr != null && count > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        node.next = reverse(curr, k, groupSize - 1);
        return prev;
    }
}
