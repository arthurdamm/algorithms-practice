# LeetCode 445. Add Two Numbers II
# https://leetcode.com/problems/add-two-numbers-ii/
# O(n + m) time and space
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        node, len1 = l1, 0
        while node:
            node, len1 = node.next, len1 + 1
        node, len2 = l2, 0
        while node:
            node, len2 = node.next, len2 + 1
        if len2 > len1:
            l1, len1, l2, len2 = l2, len2, l1, len1
        result = ListNode(0)
        result.val += self.recurse(l1, len1, l2, len2, result)
        return result if result.val else result.next
        
    def recurse(self, l1, len1, l2, len2, result):
        if not l1:
            return 0
        result.next = ListNode(l1.val)
        result = result.next
        if len1 > len2:
            result.val += self.recurse(l1.next, len1 - 1, l2, len2, result)
        else:
            result.val += self.recurse(l1.next, len1 - 1, l2.next, len2 - 1, result) + l2.val
        carry = 0
        if result.val > 9:
            carry = 1
            result.val -= 10        
        return carry
