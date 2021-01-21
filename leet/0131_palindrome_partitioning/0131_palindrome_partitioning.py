# LeetCode 131. Palindrome Partitioning
# https://leetcode.com/problems/palindrome-partitioning/
# O(n*2^n) time-and-space, bottom-up DP + backtracking
# print(len(partitions), sum([sum([len(s) for s in part]) for part in partitions]))
class Solution:
    def partition(self, s: str):
        dpPalis = [[] for _ in range(len(s))]
        partitions = []
        for i in range(len(s)):
            for j in range(1, len(s) - i + 1):
                if s[i: i + j // 2] == s[i + (j + 1) // 2: i + j][::-1]:
                    dpPalis[i].append(s[i : i + j])
                    
        def backtrack(i, partition):
            if i == len(s):
                partitions.append(partition[:])
                return
            for palindrome in dpPalis[i]:
                partition.append(palindrome)
                backtrack(i + len(palindrome), partition)
                partition.pop()

        backtrack(0, [])        
        return partitions
