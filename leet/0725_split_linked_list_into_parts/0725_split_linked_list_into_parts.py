# LeetCode 725. Split Linked List in Parts
# https://leetcode.com/problems/split-linked-list-in-parts/
# O(n) time-and-space
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        size, node = 0, head
        while node:
            size += 1
            node = node.next
        subarraySize, remainder, array, node = size // k, size % k, [], head
        for i in range(k):
            subhead, prev = node, None
            for j in range(subarraySize + 1 if i < remainder else subarraySize):
                prev = node
                node = node.next
            if prev:
                prev.next = None
            array.append(subhead if subhead else None)
        return array
