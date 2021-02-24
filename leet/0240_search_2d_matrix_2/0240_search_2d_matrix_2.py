# LeetCode 240. Search a 2D Matrix II
# https://leetcode.com/problems/search-a-2d-matrix-ii/
# O(log(max(n, m)) time and space
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        return self.search(matrix, target, 0, 0, len(matrix), len(matrix[0]))
    
    def search(self, matrix, target, i, j, n, m):
        if not 0 <= i < len(matrix) or not 0 <= j < len(matrix[0]):
            return False
        if n == 1 or m == 1:
            return self.binarySearchRowOrColumn(matrix, target, i, j, n, m)

        pivot = self.binarySearchDiagonal(matrix, target, i, j, n, m)
        if matrix[pivot[0]][pivot[1]] > target:
            return False
        if matrix[pivot[0]][pivot[1]] == target:
            return True
        return (self.search(matrix, target, i, pivot[1] + 1, pivot[0] - i + 1, m - (pivot[1] + 1 - j)) or
                self.search(matrix, target, pivot[0] + 1, j, n - (pivot[0] + 1 - i), pivot[1] + 1 - j))
        
    def binarySearchDiagonal(self, matrix, target, i, j, n, m):
        lo_i, lo_j, hi_i, hi_j = i, j, i + n, j + m
        while lo_i < hi_i and lo_j < hi_j:
            mid_i, mid_j = (lo_i + hi_i) // 2, (lo_j + hi_j) // 2
            if matrix[mid_i][mid_j] == target:
                return (mid_i, mid_j)
            elif matrix[mid_i][mid_j] < target:
                lo_i, lo_j, = mid_i + 1, mid_j + 1
            else:
                hi_i, hi_j = mid_i, mid_j
        return (max(i, lo_i - 1), max(j, lo_j - 1))

    def binarySearchRowOrColumn(self, matrix, target, i, j, n, m):
        if n == 1:
            lo, hi = j, j + m
            while lo < hi:
                mid = (lo + hi) // 2
                if matrix[i][mid] == target:
                    return True
                elif matrix[i][mid] < target:
                    lo = mid + 1
                else:
                    hi = mid
            return False
        elif m == 1:
            lo, hi = i, i + n
            while lo < hi:
                mid = (lo + hi) // 2
                if matrix[mid][j] == target:
                    return True
                elif matrix[mid][j] < target:
                    lo = mid + 1
                else:
                    hi = mid
            return False

# O(m + n) time, O(1) space
class SolutionB:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i, j = len(matrix) - 1, 0
        while i >= 0 and j < len(matrix[0]):
            if target == matrix[i][j]:
                return True
            elif target > matrix[i][j]:
                j += 1
            else:
                i -= 1
        return False
