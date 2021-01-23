# LeetCode 1329. Sort the Matrix Diagonally
# https://leetcode.com/problems/sort-the-matrix-diagonally/
# O(nmlog(nm)) time, O(nm) space
class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        diagonals = [[] for _ in range(m + n - 1)]
        for i in range(m):
            for j in range(n):
                k = j - i if j - i >= 0 else i - j + n - 1
                diagonals[k].append(mat[i][j])
        for diagonal in diagonals:
            diagonal.sort(reverse=True)
        for i in range(m):
            for j in range(n):
                k = j - i if j - i >= 0 else i - j + n - 1
                mat[i][j] = diagonals[k].pop()
        return mat
