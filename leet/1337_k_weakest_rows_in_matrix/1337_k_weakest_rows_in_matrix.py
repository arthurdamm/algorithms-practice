# LeetCode 1337. The K Weakest Rows in a Matrix
# https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
# O(m(logn + logk)) time, O(m) space
class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        from heapq import heappush, heappop
        heap = []
        def binarySearchFirstZero(row):
            lo, hi = 0, len(row)
            while lo < hi:
                mid = lo + (hi - lo) // 2
                if row[mid] == 1:
                    lo = mid + 1
                else:
                    hi = mid
            return lo
        strengths = [(binarySearchFirstZero(row), i) for i, row in enumerate(mat)]
        for strength, i in strengths:
            if (len(heap) < k or strength < -heap[0][0] or
                (strength == -heap[0][0] and i < -heap[0][1])):
                if len(heap) >= k:
                    heappop(heap)
                heappush(heap, (-strength, -i))
        return reversed([-heappop(heap)[1] for _ in range(len(heap))])
