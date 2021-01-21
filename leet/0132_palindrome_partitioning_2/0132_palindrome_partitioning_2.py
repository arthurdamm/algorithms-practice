# LeetCode 132. Palindrome Partitioning II
# https://leetcode.com/problems/palindrome-partitioning-ii/
# O(n^3) time O(n) space
class Solution:
    def minCut(self, s: str) -> int:
        dpPalis = [[] for _ in range(len(s))]
        def populatePalis(i, j):
            while i >= 0 and j < len(s) and s[i] == s[j]:
                dpPalis[i].append(j + 1 - i)
                i -= 1
                j += 1        
        for i in range(len(s)):
            populatePalis(i, i)
            populatePalis(i, i + 1)
            
        dpCuts = [len(s) if _ < len(s) else 0 for _ in range(len(s) + 1)]
        for i in range(len(s) - 1, -1, -1):
            for length in dpPalis[i]:
                dpCuts[i] = min(dpCuts[i + length] + 1, dpCuts[i])
        return dpCuts[0] - 1
