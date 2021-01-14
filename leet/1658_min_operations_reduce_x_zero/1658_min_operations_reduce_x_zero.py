# LeetCode 1658. Minimum Operations to Reduce X to Zero
# https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
# O(n) time O(1) space
class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        i, maxSubarray, target = 0, 0, sum(nums) - x
        if target <= 0:
            return len(nums) if target == 0 else -1
        for j in range(len(nums)):
            target -= nums[j]
            while target < 0:
                target += nums[i]
                i += 1
            if target == 0:
                maxSubarray = max(maxSubarray, j - i + 1)
        return len(nums) - maxSubarray if maxSubarray > 0 else -1
