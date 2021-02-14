# LeetCode 407. Trapping Rain Water II
# https://leetcode.com/problems/trapping-rain-water-ii/
# O(nlogn) time, O(n) space
class Solution:
    from heapq import heappush, heappop
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        m, n, heap = len(heightMap), len(heightMap[0]), []
        visited = [[False] * n for _ in range(m)]
        dirs = ((-1, 0), (0, 1), (1, 0), (0, -1))
        for i in range(m):
            if i == 0 or i == m - 1:
                for j in range(n):
                    heappush(heap, (heightMap[i][j], i, j))
                    visited[i][j] = True
            else:
                heappush(heap, (heightMap[i][0], i, 0))
                visited[i][0] = True
                heappush(heap, (heightMap[i][n - 1], i, n - 1))
                visited[i][n - 1] = True
        maxHeight, water = 0, 0
        while heap:
            h, i, j = heappop(heap)
            maxHeight = max(maxHeight, h)
            for ddi, ddj in dirs:
                di, dj = i + ddi, j + ddj
                if 0 <= di < m and 0 <= dj < n and not visited[di][dj]:
                    visited[di][dj] = True
                    water += max(maxHeight - heightMap[di][dj], 0)
                    heappush(heap, (heightMap[di][dj], di, dj))
        return water
