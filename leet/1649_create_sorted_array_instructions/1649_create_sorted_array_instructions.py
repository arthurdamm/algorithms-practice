# LeetCode 1649. Create Sorted Array through Instructions
# https://leetcode.com/problems/create-sorted-array-through-instructions/
# O(nlogn) time, O(n) space
class Solution:
    def createSortedArray(self, instructions: List[int]) -> int:
        from sortedcontainers import SortedList
        sortedList = SortedList()
        cost = 0
        for instruction in instructions:
            cost += min(sortedList.bisect_left(instruction),
                       len(sortedList) - sortedList.bisect_right(instruction))
            cost %= 1000000007
            sortedList.add(instruction)
        return cost
