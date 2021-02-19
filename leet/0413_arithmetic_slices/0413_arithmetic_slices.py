# LeetCode 413. Arithmetic Slices
# https://leetcode.com/problems/arithmetic-slices/
# O(n) time, O(1) space
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        if len(A) < 3: return 0
        length, diff, slices = 1, A[1] - A[0], 0;
        for i in range(len(A) - 1):
            if A[i + 1] - A[i] == diff:
                length += 1
            else:
                slices += (length - 2) * (length - 1) // 2
                diff = A[i + 1] - A[i]
                length = 2
        slices += (length - 2) * (length - 1) // 2
        return slices
