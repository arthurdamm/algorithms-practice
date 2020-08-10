#!/usr/bin/env python3
from collections import deque

class Solution:
    def orangesRotting(self, grid):
        rotting_tuples = deque()
        fresh_count = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    rotting_tuples.append((i, j))
                elif grid[i][j] == 1:
                    fresh_count += 1
        if fresh_count == 0:
            return 0
        if len(rotting_tuples) == 0:
            return -1
        minutes = 0
        
        def rot(i, j):
            if 0<=i<len(grid) and 0<=j<len(grid[i]) and grid[i][j] == 1:
                rotting_tuples.append((i, j))
                grid[i][j] = 2
                return 1
            return 0
        
        while fresh_count and len(rotting_tuples) > 0:
            minutes += 1
            for _ in range(len(rotting_tuples)):
                rotting = rotting_tuples.popleft()
                fresh_count -= (rot(rotting[0] - 1, rotting[1]) +
                rot(rotting[0], rotting[1] - 1) +
                rot(rotting[0] + 1, rotting[1]) +
                rot(rotting[0], rotting[1] + 1))
        return minutes if not fresh_count else -1

input = [[2,1,1],[1,1,0],[0,1,1]]
#input = [[2,1,1],[0,1,1],[1,0,1]]
print("Solution to", input, Solution().orangesRotting(input))
