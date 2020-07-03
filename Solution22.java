/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode pAhead = head;
        for (int i = 1; i < k; i++) {
            pAhead = pAhead.next;
            if (pAhead == null) {
                return null;
            } else {
                continue;
            }
        }

        ListNode pBehind = head;
        while (pAhead.next != null) {
            pBehind = pBehind.next;
            pAhead = pAhead.next;
        }

        return pBehind;

    }
}