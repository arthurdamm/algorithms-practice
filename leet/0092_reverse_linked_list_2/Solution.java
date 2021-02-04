// LeetCode 92. Reverse Linked List II
// https://leetcode.com/problems/reverse-linked-list-ii/
// O(n) time, O(1) space
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode origHead = head, prevHead = null, prev = null;
        for (int i = 1; i < m; i++) {
            prevHead = head;
            head = head.next;
        }
        for (int i = m; i <= n; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        if (prevHead != null) {
            prevHead.next.next = head;
            prevHead.next = prev;
            return origHead;
        }
        origHead.next = head;
        return prev;
    }
}
