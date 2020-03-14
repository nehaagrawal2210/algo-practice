package practice;

import stack.Stack;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {

    private Node head;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public Node getKthLast(Node head, int k) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }

        temp = head;
        int currentCount = 0;
        int expectedCount = size - k;
        if (expectedCount < 0) {
            return null;
        }

        while (temp != null && expectedCount != currentCount) {
            temp = temp.getNext();
            currentCount++;
        }
        return temp;
    }

    public void removeDuplicates() {
        Map<Integer, Node> nodeMap = new HashMap<>();

        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (nodeMap.containsKey(temp.getValue())) {
                //this key is duplicate, remove this node
                prev.setNext(temp.getNext());
            } else {
                prev = temp;
                nodeMap.put(temp.getValue(), temp);
            }
            temp = temp.getNext();
        }
    }

    public void removeDuplicatesN2() {

        Node current = head;
        while (current != null) {
            int value = current.getValue();
            Node runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getValue() == current.getValue()) {
                    //dup node, remove it
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
    }

    public void addValue(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        Node addNode = new Node(val);
        temp.setNext(addNode);
    }

    public LinkedList partition1(int k) {
        Node before = head;
        Node after = head;

        Node tempHead = head;
        while (tempHead != null) {
            Node next = tempHead.getNext();
            if (tempHead.getValue() < k) {
                tempHead.setNext(before);
                before = tempHead;
            } else {
                after.setNext(tempHead);
                after = tempHead;
            }
            tempHead = next;
        }
        after.setNext(null);
        head = before;
        return new LinkedList(before);
    }

    public LinkedList partition(int k) {
        Node tempHead = head;
        Node smallStart = null, smallEnd = null, largeStart = null, largeEnd = null;
        Node next;
        while (tempHead != null) {
            next = tempHead.getNext();
            tempHead.setNext(null);
            if (tempHead.getValue() < k) {
                if (smallStart == null) {
                    smallStart = tempHead;
                    smallEnd = tempHead;
                } else {
                    smallEnd.setNext(tempHead);
                    smallEnd = smallEnd.getNext();
                }
            } else {
                if (largeStart == null) {
                    largeStart = tempHead;
                    largeEnd = tempHead;
                } else {
                    largeEnd.setNext(tempHead);
                    largeEnd = largeEnd.getNext();
                }
            }
            tempHead = next;
        }
        if (smallStart == null) {
            return new LinkedList(largeStart);
        }
        smallEnd.setNext(largeStart);
        return new LinkedList(smallStart);
    }

    public LinkedList oneSumList(LinkedList l1, LinkedList l2) {
        Node firstNumber = l1.getHead();
        Node secondNumber = l2.getHead();

        Node result = new Node(-1);
        Node resultRunner = result;
        int carry = 0, firstValue, secondValue, resultValue;
        while (firstNumber != null || secondNumber != null) {
            firstValue = firstNumber != null ? firstNumber.getValue() : 0;
            secondValue = secondNumber != null ? secondNumber.getValue() : 0;
            resultValue = firstValue + secondValue + carry;
            carry = resultValue > 10 ? 1 : 0;
            resultValue = resultValue > 10 ? resultValue - 10 : resultValue;
            resultRunner.setNext(new Node(resultValue));
            firstNumber = firstNumber != null ? firstNumber.getNext() : null;
            secondNumber = secondNumber != null ? secondNumber.getNext() : null;
            resultRunner = resultRunner.getNext();
        }
        //remove dummy node
        if (carry != 0) {
            resultRunner.setNext(new Node(carry));
        }
        result = result.getNext();
        return new LinkedList(result);
    }

    public Node oneSumListRec(Node head1, Node head2, int carry) {

        if (head1 == null && head2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (head1 != null) {
            value += head1.getValue();
        }

        if (head2 != null) {
            value += head2.getValue();
        }

        Node result = new Node(value % 10);

        if (head1 != null || head2 != null) {
            Node next = oneSumListRec(head1 == null ? null : head1.getNext(), head2 == null ? null : head2.getNext(), value >= 10 ? 1 : 0);
            result.setNext(next);
        }
        return result;
    }

    public LinkedList tenSumList(LinkedList head1, LinkedList head2) {
        int size1 = head1.getLength();
        int size2 = head2.getLength();

        if (size1 < size2) {
            padList(size2 - size1);
        } else {
            padList(size1 - size2);
        }

        PartialSum sum = sumHelper(head1.getHead(), head2.getHead());
        if (sum.carry == 0) {
            return new LinkedList(sum.sum);
        } else {
            Node node = insertBefore(sum.sum, sum.carry);
            return new LinkedList(node);
        }
    }

    private PartialSum sumHelper(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return new PartialSum();
        }

        PartialSum sum = sumHelper(head1.getNext(), head2.getNext());
        int value = head1.getValue() + head2.getValue() + sum.carry;

        Node fullResult = insertBefore(sum.sum, value % 10);
        sum.sum = fullResult;
        sum.carry = value / 10;
        return sum;
    }

    public Node insertBefore(Node head, int value) {
        Node data = new Node(value);
        if (head != null) {
            data.setNext(head);
        }
        return data;
    }

    class PartialSum {
        int carry = 0;
        Node sum = null;
    }

    public void padList(int nodesToPad) {
        Node temp = head;
        while (nodesToPad != 0) {
            Node padNode = new Node(0);
            padNode.setNext(temp);
            nodesToPad--;
            temp = padNode;
        }
        head = temp;
    }

    public int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public boolean palindromeList() {
        Node temp = head;
        Stack<Integer> integerStack = new Stack<>(Integer.class);

        while (temp != null) {
            integerStack.push(temp.getValue());
            temp = temp.getNext();
        }

        temp = head;
        while (temp != null) {
            if (temp.getValue() != integerStack.pop()) {
                return false;
            }
            temp = temp.getNext();
        }
        return true;
    }

    class PalindromeResult {
        Node head;
        boolean result;

        public PalindromeResult(Node head, boolean result) {
            this.head = head;
            this.result = result;
        }
    }

    public PalindromeResult palindromeListRec(Node head, int length) {
        if (head == null || length <= 0) {
            return new PalindromeResult(head, true);
        } else if (length == 1) {
            return new PalindromeResult(head.getNext(), true);
        }

        PalindromeResult res = palindromeListRec(head.getNext(), length - 2);

        if (!res.result || res.head == null) {
            return res;
        }

        res.result = (head.getValue() == res.head.getValue());
        res.head = res.head.getNext();
        return res;
    }

    public static void main(String[] args) {

        LinkedList l3 = new LinkedList();
        l3.addValue(3);
        l3.addValue(1);
        l3.addValue(2);
        l3.addValue(2);
        l3.addValue(8);
        l3.addValue(3);

        PalindromeResult pr = l3.palindromeListRec(l3.getHead(), l3.getLength());
        System.out.println(pr.result);
    }
}

class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
