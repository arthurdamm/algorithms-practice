// LeetCode 82. Remove Duplicates from Sorted List II
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// O(n) time, O(1) space
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(), prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val)
                    head.next = head.next.next;
                head = head.next;
                if (head == null)
                    prev.next = null;
            } else {
                prev.next = head;
                prev = prev.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
