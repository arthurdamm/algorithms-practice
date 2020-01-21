# LeetCode 16. 3Sum Closest
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        best = float('inf')
        for i, num in enumerate(nums):
            ret = num + self.twoSumClosest(nums, i + 1, target - num)
            if abs(target - ret) < abs(target - best):
                best = ret
        return best
    
    def twoSumClosest(self, nums, i, target):
        j = len(nums) - 1
        best = float('inf')
        while i < j:
            twosum = nums[i] + nums[j]
            if abs(target - twosum) < abs(target - best):
                best = twosum
            if twosum < target:
                i += 1
            elif twosum > target:
                j -= 1
            else: return best
        return best

