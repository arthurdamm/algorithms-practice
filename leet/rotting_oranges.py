#!/usr/bin/env python3

class Solution:
    def orangesRotting(self, grid):
        rotting_tuples = []
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
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[i]) or grid[i][j] != 1:
                return 0
            new_rotting_tuples.append((i, j))
            grid[i][j] = 2
            return 1
        
        while fresh_count > 0:
            minutes += 1
            new_rotting_tuples = []
            for rotting in rotting_tuples:
                fresh_count -= (rot(rotting[0] - 1, rotting[1]) +
                rot(rotting[0], rotting[1] - 1) +
                rot(rotting[0] + 1, rotting[1]) +
                rot(rotting[0], rotting[1] + 1))
            if not new_rotting_tuples:
                minutes = -1
                break
            rotting_tuples = new_rotting_tuples
            new_rotting_tuples = []
        return minutes

input = [[2,1,1],[1,1,0],[0,1,1]]
print("Solution to", input, Solution().orangesRotting(input))
