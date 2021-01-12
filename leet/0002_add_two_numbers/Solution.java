// LeetCode 2. Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/
// O(m + n) time, O(1) space
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1, prev = null;
        int carry = 0;
        while (l1 != null) {
            if (l2 != null) {
                if (l1.next == null) {
                    l1.next = l2.next;
                    l2.next = null;
                }
                l1.val += l2.val;
                l2 = l2.next;
            }
            l1.val += carry;
            carry = l1.val / 10;
            l1.val %= 10;
            prev = l1;
            l1 = l1.next;
        }
        if (carry != 0)
            prev.next = new ListNode(carry);
        return head;
    }
}
