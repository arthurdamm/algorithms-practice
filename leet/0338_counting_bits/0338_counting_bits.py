"""
LeetCode 338. Counting Bits
https://leetcode.com/problems/counting-bits/
O(n) time-and-space
"""
class Solution:
    def countBits(self, n: int) -> List[int]:
        dp = [0 if i == 0 else 1 for i in range(n + 1)]
        for i in range(3, n + 1):
            if i % 2 == 1:
                dp[i] = dp[(i - 1) // 2] + 1
            else:
                dp[i] = dp[i // 2]
        return dp
