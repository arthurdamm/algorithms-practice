# LeetCode 1631. Path With Minimum Effort
# https://leetcode.com/problems/path-with-minimum-effort/
# O(nlogk) O(n)
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        heap = [(0, (0,0))]
        visited = [[float('inf') for _ in range(len(heights[0]))] for _ in range(len(heights))]
        while heap:
            currMax, (i, j) = heapq.heappop(heap)
            if i == len(heights) - 1 and j == len(heights[0]) - 1:
                return currMax
            if visited[i][j] <= currMax:
                continue
            visited[i][j] = currMax
            for di, dj in ((0, -1), (0, 1), (1, 0), (-1, 0)):
                if 0 <= i + di < len(heights) and 0 <= j + dj < len(heights[0]):
                    tempMax = max(currMax, abs(heights[i][j] - heights[i + di][j + dj]))
                    if visited[i + di][j + dj] > tempMax:
                        heapq.heappush(heap, (tempMax, (i + di, j + dj)))
        return float('inf')
