# LeetCode 907. Sum of Subarray Minimums
# https://leetcode.com/problems/sum-of-subarray-minimums/
# O(n) time-and-space
class Solution:
    def hammingWeight(self, n: int) -> int:
        weight = 0
        while n != 0:
            weight += n & 1
            n >>= 1
        return weight
