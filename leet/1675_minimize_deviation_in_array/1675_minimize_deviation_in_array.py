# LeetCode 1675. Minimize Deviation in Array
# https://leetcode.com/problems/minimize-deviation-in-array/
# O(klogn) time, O(n) space
class Solution:
    from heapq import heappush, heappop
    def minimumDeviation(self, nums: List[int]) -> int:
        nums_max = nums[:]
        _max = float('-inf')
        for i in range(len(nums)):
            if nums_max[i] & 1 == 1:
                nums_max[i] *= 2
            while nums[i] & 1 == 0:
                nums[i] //= 2
            _max = max(_max, nums[i])

        heap = []
        for i in range(len(nums)):
            heappush(heap, (nums[i], i))

        diff = float('inf')
        while True:
            val, i = heappop(heap)
            diff = min(diff, _max - val)
            if val == nums_max[i]:
                break
            heappush(heap, (val * 2, i))
            _max = max(_max, val * 2)
        return diff
