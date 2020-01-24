# LeetCode 23. Merge k Sorted Lists

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import heapq

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ret = head = ListNode(0)
        nodes = [(node.val, i, node) for i, node in enumerate(lists) if node]
        heapq.heapify(nodes)
        while len(nodes):
            currTuple = heapq.heappop(nodes)
            node = currTuple[2]
            head.next = node
            head = node
            if node.next:
                heapq.heappush(nodes, (node.next.val, currTuple[1], node.next))
        return ret.next

