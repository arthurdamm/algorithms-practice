# LeeCode 1219. Path with Maximum Gold
# https://leetcode.com/problems/path-with-maximum-gold/
# O(n^3) time, O(n) space
class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        gold = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                gold = max(gold, self.backtrack(grid, i, j))
        return gold
    
    def backtrack(self, grid, i, j):
        if grid[i][j] == 0:
            return 0
        gold = grid[i][j]
        grid[i][j] = 0
        maxgold = 0
        if i > 0:
            maxgold = max(maxgold, gold + self.backtrack(grid, i - 1, j))
        if i < len(grid) - 1:
            maxgold = max(maxgold, gold + self.backtrack(grid, i + 1, j))
        if j > 0:
            maxgold = max(maxgold, gold + self.backtrack(grid, i, j - 1))
        if j < len(grid[i]) - 1:
            maxgold = max(maxgold, gold + self.backtrack(grid, i, j + 1))
        grid[i][j] = gold
        return maxgold
