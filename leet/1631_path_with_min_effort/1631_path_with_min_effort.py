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

# O(nlogk) O(n) Binary Search for k
class SolutionBinarySeach:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        self.heights = heights
        lo, hi = 0, int(1e6 + 1) 
        while lo < hi:
            mid = lo + (hi - lo) // 2
            if self.kPossible(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo

    def kPossible(self, k):
        m, n = len(self.heights), len(self.heights[0])
        visited = [[False] * n for _ in range(m)]
        def dfs(i, j):
            if i == m - 1 and j == n - 1:
                return True
            visited[i][j] = True
            for ddi, ddj in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                di, dj = i + ddi, j + ddj
                if 0 <= di < m and 0 <= dj < n and not visited[di][dj] and \
                    abs(self.heights[i][j] - self.heights[di][dj]) <= k:
                    if dfs(di, dj):
                        return True
            return False
        return dfs(0, 0)
