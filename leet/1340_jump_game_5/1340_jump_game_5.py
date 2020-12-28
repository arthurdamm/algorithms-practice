# LeetCode 1340. Jump Game V
# https://leetcode.com/problems/jump-game-v/
# O(n^2) time O(n) space
class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        def dfs(i):
            dp[i] = 1
            for j in range(i - 1, max(0, i - d) - 1, -1):
                if arr[j] >= arr[i]:
                    break
                dp[i] = max(dp[i], 1 + (dp[j] if dp[j] > 0 else dfs(j)))
            for j in range(i + 1, min(len(arr) - 1, i + d) + 1):
                if arr[j] >= arr[i]:
                    break
                dp[i] = max(dp[i], 1 + (dp[j] if dp[j] > 0 else dfs(j)))
            return dp[i]
        
        dp = [0] * len(arr)
        for i in range(len(arr)):
            if dp[i] == 0:
                dfs(i)
        return max(dp)
