# LeetCode 2. Add Two Numbers
# https://leetcode.com/problems/add-two-numbers/
# O(m + n) time, O(1) space
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head, prev, carry = l1, None, 0
        while l1:
            if l2:
                if not l1.next:
                    l1.next, l2.next = l2.next, None
                l1.val += l2.val
            l1.val += carry
            carry = l1.val // 10
            l1.val %= 10
            prev, l1, l2 = l1, l1.next, l2.next if l2 else None
        if carry:
            prev.next = ListNode(carry)
        return head
