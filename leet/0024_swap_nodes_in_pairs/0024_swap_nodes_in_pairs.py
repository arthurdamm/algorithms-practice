# LeetCode 24. Swap Nodes in Pairs
# https://leetcode.com/problems/swap-nodes-in-pairs/
# O(n) time O(1) space
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        _head = ListNode()
        prev, next = _head, None
        prev.next = head
        while head and head.next:
            next = head.next
            head.next = next.next
            next.next = head
            prev.next = next

            prev = head
            head = head.next
        return _head.next


class SolutionB:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head:
            return None
        if not head.next:
            return head
        next = head.next
        head.next = self.swapPairs(next.next)
        next.next = head
        return next
