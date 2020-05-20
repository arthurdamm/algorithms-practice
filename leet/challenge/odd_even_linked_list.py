#!/usr/bin/env python3

"""
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head or not head.next or not head.next.next:
            return head
        _evens = evens = ListNode()
        _head = odds = head
        head = head.next
        i = 2
        while head:
            if i % 2:
                odds.next = head
                odds = odds.next
            else:
                evens.next = head
                evens = evens.next
            head = head.next
            i += 1
        if evens:
            evens.next = None
        odds.next = _evens.next
        return _head
