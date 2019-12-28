#!/usr/bin/env python3
# LeetCode 62 Unique Paths
# O(n) time & space solution

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * m] * n
        for i in range(0, n):
            for j in range(0, m):
                if i == 0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j -1]
        return dp[n - 1][m - 1]

if __name__ == "__main__":
    d = (7, 3)
    print("Solution for", d, ":", Solution().uniquePaths(*d))

