# LeetCode 16. 3Sum Closest
# https://leetcode.com/problems/3sum-closest/
# O(n^2) time, O(1) space
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        best = float('inf')
        nums.sort()
        for k in range(len(nums)):
            i, j = k + 1, len(nums) - 1
            while i < j:
                sum3 = nums[k] + nums[i] + nums[j]
                if abs(sum3 - target) < abs(best - target):
                    best = sum3
                if sum3 > target:
                    j -= 1
                elif sum3 < target:
                    i += 1
                else:
                    return target
        return best
