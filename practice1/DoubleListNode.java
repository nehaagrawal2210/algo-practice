package practice1;

public class DoubleListNode {
    DoubleListNode prev;
    DoubleListNode next;
    int val;

    public DoubleListNode(int val) {
        this.val = val;
    }

    public void traverse(DoubleListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }
}
