# LeetCode 131. Palindrome Partitioning
# https://leetcode.com/problems/palindrome-partitioning/
# O(n*2^n) time-and-space, top-down DP + backtracking
# print(len(partitions), sum([sum([len(s) for s in part]) for part in partitions]))
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        memo = [[] for _ in range(len(s) + 1)]
        memo[-1].append("")
        partitions = []
        
        def dp(i):
            if memo[i]:
                return
            for j in range(1, len(s) - i + 1):
                if s[i: i + j // 2] == s[i + (j + 1) // 2: i + j][::-1]:
                    memo[i].append(s[i : i + j])
                    dp(i + j)
        
        def backtrack(i, partition):
            if i == len(s):
                partitions.append(partition[:])
                return
            for palindrome in memo[i]:
                partition.append(palindrome)
                backtrack(i + len(palindrome), partition)
                partition.pop()
        
        dp(0)
        backtrack(0, [])        
        return partitions
