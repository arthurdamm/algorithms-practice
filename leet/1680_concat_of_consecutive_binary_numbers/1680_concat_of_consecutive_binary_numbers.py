# LeetCode 1680. Concatenation of Consecutive Binary Numbers
# https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
# O(n) time, O(n) space
class Solution:
    def concatenatedBinary(self, n: int, memo=[0]) -> int:
        MOD, k = int(1e9 + 7), 1
        for i in range(len(memo) - 1, n + 1):
            memo.append(((memo[-1] << i.bit_length()) + i) % MOD)
        return memo[n + 1]
