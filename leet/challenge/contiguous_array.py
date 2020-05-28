#!/usr/bin/env python3
"""
Contiguous Array
Solution
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
"""

class Solution:
    def findMaxLength(self, nums) -> int:
        seen = {0: -1}
        count = ret = 0
        for i, n in enumerate(nums):
            count += 1 if n == 1 else -1
            if count in seen:
                ret = max(ret, i - seen[count])
            else:
                seen[count] = i
        return ret

d = [0, 1, 0]
print("Solution", d, Solution().findMaxLength(d))
