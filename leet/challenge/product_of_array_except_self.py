#!/usr/bin/env python3
# Product of array of integers except self

class Solution:
    def productExceptSelf(self, nums):
        left = [0]*len(nums)
        left[0] = 1
        print("LEFT IS", left)
        for i in range(1, len(nums), 1):
            left[i] = nums[i - 1] * left[i - 1]
        right = 1
        print("nums IS", nums)
        print("LEFT IS", left)
        for i in range(len(nums) - 1, 0, -1):
            left[i] *= right
            right *= nums[i]
        left[0] = right
        return left

d = [3,5,7,11]
print(d, "Solution", Solution().productExceptSelf(d))
