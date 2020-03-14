package practice;

public class SortedLinkedListToBalancedBST {

    public static void main(String[] args) {

        Node node = new Node(1);
        Node temp = node;
        temp.setNext(new Node(2));
        temp = temp.getNext();
        temp.setNext(new Node(3));
        temp = temp.getNext();
        temp.setNext(new Node(4));
        temp = temp.getNext();
        temp.setNext(new Node(5));
        temp = temp.getNext();
        temp.setNext(new Node(6));
        temp = temp.getNext();
        temp.setNext(new Node(7));

        printList(node);
        TreeNode tree = getTree(node);
        tree.preOrder(tree);
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + ", ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    static Node head;

    private static TreeNode getTree(Node list) {
        head = list;
        int count = countNodes(list);
        return getTree(count);
    }

    private static TreeNode getTree(int count) {
        if (count <= 0) {
            return null;
        }

        TreeNode left = getTree(count / 2);
        TreeNode root = new TreeNode(head.getValue());
        root.left = left;
        head = head.getNext();
        root.right = getTree(count - count / 2 - 1);
        return root;
    }

    private static int countNodes(Node list) {
        Node temp = list;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}
