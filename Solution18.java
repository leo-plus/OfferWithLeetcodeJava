/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        if (cur.val == val)
            return head.next;

        while (cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    // https://github.com/ryderchan/point-to-offer-edition2/blob/master/src/chapter3/P119_DeleteNodeInList.java
}