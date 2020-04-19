#!/usr/bin/env python3
"""
Given a m x n grid filled with non-negative numbers, find a path from top left to
bottom right which minimizes the sum of all numbers along its path.
"""

class Solution:
    def minPathSum(self, grid):
        dp = [0] * len(grid[0])
        for row in range(len(grid)):
            dp[0] += grid[row][0]
            for col in range(1, len(grid[row])):
                if row:
                    dp[col] = min(dp[col - 1], dp[col]) + grid[row][col]
                else:
                    dp[col] = dp[col - 1] + grid[row][col]
        return dp[-1]

d = [
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
print("Solution", d, Solution().minPathSum(d))
