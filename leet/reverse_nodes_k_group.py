# LeetCode 25. Reverse Nodes in k-Group

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseKGroup(self, head, k: int):
        if not head: return None
        curr = head
        size = 0
        # First get length of list
        while curr:
            curr = curr.next
            size += 1
        curr = head
        ret_head, prev_tail, new_tail = None, None, None
        for i in range(size // k):  # How many groups
            new_head, new_tail, curr = self.reverseK(curr, k)
            if not ret_head: ret_head = new_head
            if prev_tail: prev_tail.next = new_head
            prev_tail = new_tail
        if new_tail: new_tail.next = curr
        return ret_head if ret_head else head

    def reverseK(self, head, k):
        new_tail = curr = head
        prev = None
        next = None
        for i in range(k):
            next = curr.next;
            curr.next = prev
            prev = curr
            curr = next
        return (prev, new_tail, curr)

