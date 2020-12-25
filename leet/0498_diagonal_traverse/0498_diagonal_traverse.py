# LeetCode 498. Diagonal Traverse
# https://leetcode.com/problems/diagonal-traverse/
# O(m * n) time & space
class Solution:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix or not matrix[0]:
            return []
        m, n, i, j, k = len(matrix), len(matrix[0]), 0, 0, 0
        A = [0] * (m * n);
        while k < m * n:
            while i >= 0 and j <= n - 1:
                A[k] = matrix[i][j]
                i -= 1
                j += 1
                k += 1
            i += 1
            if j >= n:
                i += 1
                j -= 1
            while i <= m - 1 and j >= 0:
                A[k] = matrix[i][j]
                i += 1
                j -= 1
                k += 1
            j += 1
            if i >= m:
                j += 1
                i -= 1
        return A

class SolutionB:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix or not matrix[0]:
            return []
        m, n = len(matrix), len(matrix[0])
        diagonals = [[] for _ in range(m + n)]
        for i in range(m):
            for j in range(n):
                diagonals[i + j].append(matrix[i][j])
        A = []
        for i in range(m + n):
            A.extend(reversed(diagonals[i]) if i % 2 == 0 else diagonals[i])
        return A
