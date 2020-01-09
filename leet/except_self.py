# LeetCode 238. Product of Array Except Self
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        ret = [1] * len(nums)
        pi, pj = 1, 1
        for i in range(len(nums)):
            j = len(nums) - 1 - i
            ret[i] *= pi;
            ret[j] *= pj;
            pi *= nums[i]
            pj *= nums[j]
        return ret

