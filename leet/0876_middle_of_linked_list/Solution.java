// LeetCode 876. Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list/
// O(n) time, O(1) space
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
