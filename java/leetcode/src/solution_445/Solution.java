package solution_445;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> stack = new Stack<>();
        int inc = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int a = stack1.pop();
            int b = stack2.pop();
            int c = a + b + inc;
            if (c >= 10) {
                c = c - 10;
                inc = 1;
            } else {
                inc = 0;
            }
            stack.push(c);
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = 0;
            if (!stack1.isEmpty()) {
                a = stack1.pop();
            } else {
                a = stack2.pop();
            }
            int c = a + inc;
            if (c >= 10) {
                c = c - 10;
                inc = 1;
            } else {
                inc = 0;
            }
            stack.push(c);
        }
        if (inc == 1) {
            stack.push(inc);
        }

        ListNode pre = new ListNode(stack.pop());
        ListNode head = pre;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop());
            pre.next = node;
            pre = node;
        }
        return head;
    }
}
