public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLen(headA);
        int lengthB = getLen(headB);

        ListNode a = headA;
        ListNode b = headB;

        if (lengthA > lengthB) {
            for (int i = 0; i < (lengthA - lengthB); i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < (lengthB - lengthA); i++) {
                b = b.next;
            }
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}