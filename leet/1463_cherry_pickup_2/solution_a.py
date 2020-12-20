# LeetCode 1463. Cherry Pickup II
# O(m*n^2) time & space
class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        dp = [[[0 for _ in range(len(grid[i]))] for _ in range(len(grid[i]))] for i in range(len(grid))]
        dp[0][0][-1] = grid[0][0] + grid[0][-1] + 1
        for i in range(1, len(grid)):
            for j in range(len(grid[i])):
                for k in range(len(grid[i])):
                    if j == k: continue
                    for j2 in range(j - 1, j + 2):
                        if 0 <= j2 < len(grid[i]):
                            for k2 in range(k - 1, k + 2):
                                if 0 <= k2 < len(grid[i]):
                                    dp[i][j][k] = max(dp[i][j][k],
                                                     dp[i - 1][j2][k2])
                    if dp[i][j][k] > 0:
                        dp[i][j][k] += grid[i][j] + grid[i][k]
        return max([max(dp[-1][i]) for i in range(len(dp[-1]))]) - 1
