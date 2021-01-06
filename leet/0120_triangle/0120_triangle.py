# LeetCode 120. Triangle
# https://leetcode.com/problems/triangle/
# O(n) time O(1) space
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for i in range(1, len(triangle)):
            for j in range(len(triangle[i])):
                temp = float('inf')
                if j != len(triangle[i]) - 1:
                    temp = min(temp, triangle[i - 1][j])
                if j != 0:
                    temp = min(temp, triangle[i - 1][j - 1])
                triangle[i][j] += temp
        return min(triangle[-1])
