// LeetCode 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/
// O(n) time, O(1) space
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
