package practice1;


import junit.framework.TestCase;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DecimalValue extends TestCase {
    public int getDecimalValue(ListNode head) {
        int digits = countDigits(head) - 1;
        int decVal = 0;
        while (head != null) {
            int powVal = (powOf2(digits));
            decVal = decVal + powVal * head.val;
            head = head.next;
            digits--;
        }
        return decVal;
    }

    public int powOf2(int n) {
        if (n == 0) {
            return 1;
        }
        int prod = powOf2(n / 2);
        if (n % 2 == 0) {
            return prod * prod;
        }
        return 2 * prod * prod;
    }

    int countDigits(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void testDecimalValue() {
//        [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
        ListNode list0 = new ListNode(1);
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode list3 = new ListNode(1);
        ListNode list4 = new ListNode(0);
        ListNode list5 = new ListNode(0);
        ListNode list6 = new ListNode(1);
        ListNode list7 = new ListNode(1);
        ListNode list8 = new ListNode(1);
        ListNode list9 = new ListNode(0);
        ListNode list10 = new ListNode(0);
        ListNode list11 = new ListNode(0);
        ListNode list12 = new ListNode(0);
        ListNode list13 = new ListNode(0);
        ListNode list14 = new ListNode(0);

        list0.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        list7.next = list8;
        list8.next = list9;
        list9.next = list10;
        list10.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;
        Map<String, Integer> domainCountMap = new HashMap<>();
        domainCountMap.entrySet().stream().map(x-> x.getValue() + " " + x.getKey()).collect(Collectors.toList());



        Map<Integer, Integer> count = new HashMap<>();

        System.out.println(getDecimalValue(list0));
    }
}
