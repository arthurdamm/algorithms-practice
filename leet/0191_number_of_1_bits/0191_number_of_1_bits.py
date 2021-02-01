# LeetCode 191. Number of 1 Bits
# https://leetcode.com/problems/number-of-1-bits/
# O(logn) time, O(1) space
class Solution:
    def hammingWeight(self, n: int) -> int:
        weight = 0
        while n != 0:
            weight += n & 1
            n >>= 1
        return weight
