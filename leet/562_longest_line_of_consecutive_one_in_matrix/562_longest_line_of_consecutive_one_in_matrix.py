"""
LeetCode 562. Longest Line of Consecutive One in Matrix
https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
O(n * m) time, O(m) space
Key Insight: DP in 4 previous directions += 1 if cell 1 else set to 0.
"""
class Solution:
    def longestLine(self, mat: List[List[int]]) -> int:
        dpLeft = 0
        dpTop = [0] * len(mat[0])
        dpDiagPrev = [0] * len(mat[0])
        dpDiag = [0] * len(mat[0])
        dpAntiDiagPrev = [0] * len(mat[0])
        dpAntiDiag = [0] * len(mat[0])
        maxLine = 0
        for r in range(len(mat)):
            for c in range(len(mat[0])):
                if mat[r][c] == 0:
                    dpLeft = dpTop[c] = dpDiag[c] = dpAntiDiag[c] = 0
                else:
                    dpTop[c] += 1
                    dpLeft += 1
                    dpDiag[c] = (dpDiagPrev[c - 1] if c > 0 else 0) + 1
                    dpAntiDiag[c] = (dpAntiDiagPrev[c + 1] if c < len(mat[0]) - 1 else 0) + 1
                    maxLine = max(maxLine, dpTop[c], dpLeft, dpDiag[c], dpAntiDiag[c])
            dpLeft = 0
            dpDiag, dpDiagPrev = dpDiagPrev, dpDiag
            dpAntiDiag, dpAntiDiagPrev = dpAntiDiagPrev, dpAntiDiag
        return maxLine
