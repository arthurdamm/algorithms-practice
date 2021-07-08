# LeetCode 378. Kth Smallest Element in a Sorted Matrix
# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
# O(nlogn) time, O(1) space
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n, lo, hi = len(matrix), matrix[0][0], matrix[-1][-1]
        
        while lo < hi:
            mid = (hi - lo) // 2 + lo
            j, count = n - 1, 0
            for i in range(0, n):
                while j >= 0 and matrix[i][j] > mid:
                    j -= 1
                count += j + 1
            if count < k:
                lo = mid + 1
            else:
                hi = mid
        return lo

