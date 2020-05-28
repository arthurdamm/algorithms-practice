#!/usr/bin/env python3
"""
Uncrossed Lines
We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

Example:

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
"""

class Solution:
    def maxUncrossedLines(self, A, B) -> int:
        A = [-1] + A
        B = [-1] + B
        dp = [ [0 for _ in range(len(B))] for _ in range(len(A))]
        for i in range(1, len(A)):
            for j in range(1, len(B)):
                if A[i] == B[j]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        return dp[-1][-1]

A = [2,5,1,2,5]
B = [10,5,2,1,5,2]
print("Solution", A, B, Solution().maxUncrossedLines(A, B))
