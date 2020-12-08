# LeetCode 54. Spiral Matrix
# O(m*n) time, O(1) space
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        r1 = 0
        c1 = 0
        r2 = len(matrix) - 1
        c2 = len(matrix[0]) - 1
        flat = []
        while r2 >= r1 and c2 >= c1:
            for c in range(c1, c2 + 1):
                flat.append(matrix[r1][c])
            for r in range(r1 + 1, r2 + 1):
                flat.append(matrix[r][c2])
            if r2 != r1:
                for c in range(c2 - 1, c1 - 1, -1):
                    flat.append(matrix[r2][c])
            if c2 != c1:
                for r in range(r2 - 1, r1, -1):
                    flat.append(matrix[r][c1])
            r1 += 1
            c1 += 1
            r2 -= 1
            c2 -= 1
        return flat

