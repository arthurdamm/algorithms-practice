#!/usr/bin/env python3
"""
Counting Bits
Solution
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
"""

class Solution:
    def countBits(self, num: int):
        results = [0] * (num + 1)
        for i in range(1, num + 1):
            results[i] = results[i // 2] + i % 2
        return results

d = 5
print("Solution", d, Solution().countBits(d))
