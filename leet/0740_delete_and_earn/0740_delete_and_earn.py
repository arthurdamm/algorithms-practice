"""
LeetCode 740. Delete and Earn
https://leetcode.com/problems/delete-and-earn/
O(n + M - m) time-and-space, M=Max, m=min
Key Insight: Just like house robber 1: dp(val) is max of
count[val]*val + dp(val - 2) or dp(val - 1)
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        from collections import Counter
        c = Counter(nums)
        minVal = min(nums)
        maxVal = max(nums)
        dp = [0] * (maxVal - minVal + 1)
        for i in range(minVal, maxVal + 1):
            val = i * c[i]
            j = i - minVal
            dp[j] = max(val + (dp[j - 2] if j > 1 else 0), dp[j - 1])
        return dp[maxVal - minVal]
            
