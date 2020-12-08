# LeetCode 59. Spiral Matrix 2
# O(n*n) time, O(1) space
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        r1 = 0
        c1 = 0
        r2 = n - 1
        c2 = n - 1
        matrix = [[0] * n for _ in range(n)]
        i = 1
        while r2 >= r1 and c2 >= c1:
            for c in range(c1, c2 + 1):
                matrix[r1][c] = i
                i += 1
            for r in range(r1 + 1, r2 + 1):
                matrix[r][c2] = i
                i += 1
            if r2 != r1:
                for c in range(c2 - 1, c1 - 1, -1):
                    matrix[r2][c] = i
                    i += 1
            if c2 != c1:
                for r in range(r2 - 1, r1, -1):
                    matrix[r][c1] = i
                    i += 1
            r1 += 1
            c1 += 1
            r2 -= 1
            c2 -= 1
        return matrix
