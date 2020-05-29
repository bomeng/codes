package solution_61;

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int size = 0;
        ListNode node = head;
        ListNode end = null;
        while (node != null) {
            if (node.next == null) {
                end = node;
            }
            size++;
            node = node.next;
        }

        k = k % size;
        if (k == 0) {
            return head;
        }

        int i = 1;
        ListNode start = head;
        node = head;
        while ((size - i) > k) {
            node = node.next;
            i++;
        }
        head = node.next;
        node.next = null;
        end.next = start;
        return head;
    }
}
