# LeetCode 1463. Cherry Pickup II
# O(m*n^2) time & space
class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        @lru_cache(None)
        def dp(i, j, k):
            if not 0 <= j < len(grid[0]) or not 0 <= k < len(grid[0]) or j == k:
                return float('-inf')
            
            result = grid[i][j] + grid[i][k]
            if i == len(grid) - 1:
                return result
            _max = float('-inf')
            for j2 in range(j - 1, j + 2):
                for k2 in range(k - 1, k + 2):
                    _max = max(_max, dp(i + 1, j2, k2))
            return result + _max

        return dp(0, 0, len(grid[0]) - 1)
