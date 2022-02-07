# LeetCode 389. Find the Difference
# https://leetcode.com/problems/find-the-difference/
# O(n) time-and-space
class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        return list((Counter(t) - Counter(s)).keys())[0]
