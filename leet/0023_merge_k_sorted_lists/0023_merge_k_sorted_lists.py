# LeetCode 23. Merge k Sorted Lists
# https://leetcode.com/problems/merge-k-sorted-lists/
# O(nlogk) time, O(k) space
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        saveHead = head = ListNode(0)
        heap = [(node.val, i, node) for i, node in enumerate(lists) if node]
        heapq.heapify(heap)
        while heap:
            val, i, node = heapq.heappop(heap)
            head.next = node
            head = head.next
            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next))
        return saveHead.next
