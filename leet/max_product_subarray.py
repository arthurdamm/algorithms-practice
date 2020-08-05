#!/usr/bin/env python3
"""
152. Maximum Product Subarray
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
"""

class TwoPassSolution:
    def maxProduct(self, nums) -> int:
        result = float('-inf')
        prod = 1
        for num in nums:
            prod *= num
            result = max(result, prod)
            prod = 1 if prod == 0 else prod
        prod = 1
        for num in reversed(nums):
            prod *= num
            result = max(result, prod)
            prod = 1 if prod == 0 else prod
        return result

input = [2,3,-2,4]
print("Solution", input, TwoPassSolution().maxProduct(input))
