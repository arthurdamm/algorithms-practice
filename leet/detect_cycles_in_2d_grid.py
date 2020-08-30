# LeetCode 1559. Detect Cycles in 2D Grid
class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        def dfs(m, n, pm, pn):
            if m < 0 or m >= len(grid) or n < 0 or n >= len(grid[m]):
                return False
            if grid[m][n].lower() != grid[pm][pn].lower():
                return False
            if grid[m][n].isupper():
                return True
            grid[m][n] = grid[m][n].upper()
            for dir in dirs:
                if m + dir[0] != pm or n + dir[1] != pn:
                    if (dfs(m + dir[0], n + dir[1], m, n)):
                        return True
            return False
        for m in range(len(grid)):
            for n in range(len(grid[m])):
                if grid[m][n].islower():
                    if dfs(m, n, m, n):
                        return True
        return False
            
