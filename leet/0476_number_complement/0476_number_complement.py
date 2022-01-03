# LeetCode 476. Number Complement
# https://leetcode.com/problems/number-complement/
# O(1) time-and-space
class Solution:
    def findComplement(self, num: int) -> int:
        n = num
        n = n | n >> 1
        n = n | n >> 2
        n = n | n >> 4
        n = n | n >> 8
        n = n | n >> 16
        return n & ~num;
