#!/usr/bin/env python3
"""
93. Restore IP Addresses
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
"""
class Solution:
    def restoreIpAddresses(self, s: str):
        solutions = []
        def dfs(parts, i):
            if len(parts) == 4:
                if i == len(s):
                    solutions.append(parts)
                return
            if i >= len(s):
                return
            dfs(parts + [s[i]], i + 1)
            if len(s) - i >= 2 and s[i] != '0':
                dfs(parts + [s[i:i+2]], i + 2)
                if len(s) - i >= 3 and int(s[i:i+3]) <= 255:
                    dfs(parts + [s[i:i+3]], i + 3)
        dfs([], 0)
        return ['.'.join(solution) for solution in solutions]

input = "25525511135"
print("Solution to", input, Solution().restoreIpAddresses(input))
