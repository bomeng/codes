package solution_160;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            headA = headA.next;
        }
        while (headA != null) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
    }
}
