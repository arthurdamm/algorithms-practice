# LeetCode 142. Linked List Cycle II
# https://leetcode.com/problems/linked-list-cycle-ii/
# O(n) time, O(1) space
class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        if not fast or not fast.next:
            return None
        slow = head;
        while fast != slow:
            slow = slow.next
            fast = fast.next
        return slow

