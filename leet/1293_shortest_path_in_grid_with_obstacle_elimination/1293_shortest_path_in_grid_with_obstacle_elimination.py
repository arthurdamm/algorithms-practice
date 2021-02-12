# LeetCode 1293. Shortest Path in a Grid with Obstacles Elimination
# https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
# O(n*m*k) time-and-space
class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        m, n, steps = len(grid), len(grid[0]), 0
        dirs = ((0, 1), (1, 0), (-1, 0), (0, -1))
        visited = [[float('inf')] * n for _ in range(m)]
        queue = deque()
        queue.append([0, 0, 0])
        while queue:
            for _ in range(len(queue)):
                i, j, _k = queue.popleft()
                if i == m - 1 and j == n - 1:
                    return steps
                for ddi, ddj in dirs:
                    di, dj = i + ddi, j + ddj
                    if (0 <= di < m and 0 <= dj < n and
                        _k + grid[di][dj] <= k and
                        _k + grid[di][dj] < visited[di][dj]):
                            visited[di][dj] = _k + grid[di][dj]
                            queue.append([di, dj, _k + grid[di][dj]])
            steps += 1
        return -1
