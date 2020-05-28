#!/usr/bin/env python3
"""
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.
"""

import collections

class Solution:
    def possibleBipartition(self, N: int, dislikes) -> bool:
        if not dislikes: return True
        dislikedict= collections.defaultdict(list)
        colors = [0] * (N + 1)
        for a, b in dislikes:
            dislikedict[a].append(b)
            dislikedict[b].append(a)

        def dfs(person, color):
            colors[person] = color
            for dislike in dislikedict[person]:
                if colors[dislike] == color or (not colors[dislike] and not dfs(dislike, -color)):
                    return False
            return True

        for n in range(1, N + 1):
             if not colors[n] and not dfs(n, 1):
                    return False
        return True

N = 4
dislikes = [[1,2],[1,3],[2,4]]
print("Solution", N, dislikes, Solution().possibleBipartition(N, dislikes))
