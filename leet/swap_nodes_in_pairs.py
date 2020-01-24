# LeetCode 24. Swap Nodes in Pairs

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head: return None
        if not head.next: return head
        prev = ret = ListNode(0)
        while head and head.next:
            prev.next = head.next  # connect previous node to next
            temp = head.next.next  # save the next next 
            head.next.next = head  # swap the current pair A
            head.next = temp       # swap the current pair B
            prev = head            # save head as prev
            head = temp            # set head as saved next next
        return ret.next
