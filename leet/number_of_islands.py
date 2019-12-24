#!/usr/bin/env python3
# LeetCode Number of Islands problems
# O(n) time, O(1) space

from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not list: return 0
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    islands += 1
                    self.sink(grid, i, j)
        return islands
    
    def sink(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]):
            return;
        if grid[i][j] == '0':
            return
        grid[i][j] = '0'
        self.sink(grid, i - 1, j);
        self.sink(grid, i + 1, j);
        self.sink(grid, i, j - 1);
        self.sink(grid, i, j + 1);

if __name__ == "__main__":
	grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
	print("Solution:", Solution().numIslands(grid))
	print("Expected: 1")

