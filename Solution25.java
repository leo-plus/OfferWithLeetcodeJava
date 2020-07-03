/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode mergetHead;

        if (l1.val < l2.val) {
            mergetHead = l1;
            mergetHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergetHead = l2;
            mergetHead.next = mergeTwoLists(l1, l2.next);
        }

        return mergetHead;
    }
}