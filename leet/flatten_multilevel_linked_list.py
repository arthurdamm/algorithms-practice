#!/usr/bin/env python3
"""
Flatten a Multilevel Doubly Linked List

# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        return self._flatten(head)[0]
    def _flatten(self, head: 'Node') -> 'Node':
        _head = head
        while head:
            if head.child:
                temp = head.next
                head_and_tail = self._flatten(head.child)
                head.next = head_and_tail[0]
                head.child = None
                head.next.prev = head
                head = head_and_tail[1]
                head.next = temp
                if temp:
                    temp.prev = head
            elif head.next:
                head = head.next
            else:
                break
        return (_head, head)

