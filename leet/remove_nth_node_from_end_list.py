# LeetCode 19. Remove Nth Node From End of List

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        slow = fast = head
        if not head.next: return None
        elif not head.next.next:
            if n == 2: return head.next
            head.next = None
            return head
        for _ in range(n if n > 1 else 2):
            fast = fast.next
        while fast:
            fast = fast.next
            slow = slow.next
        if slow == head:
            return head.next
        if n > 1:
            slow.val = slow.next.val
            slow.next = slow.next.next
        else:
            slow.next = None
        return head

