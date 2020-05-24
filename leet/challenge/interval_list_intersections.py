#!/usr/bin/env python3
"""
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
"""

# O(A + B) time, O(min(A, B)) space complexity
class Solution:
    def intervalIntersection(self, A, B):
        i, j = 0, 0
        intervals = []
        while i < len(A) and j < len(B):
            if B[j][0] <= A[i][0] <= B[j][1]:
                if B[j][1] < A[i][1]:
                    intervals.append([A[i][0], B[j][1]])
                    j += 1
                else:
                    intervals.append([A[i][0], A[i][1]])
                    i += 1
            elif A[i][0] <= B[j][0] <= A[i][1]:
                if B[j][1] < A[i][1]:
                    intervals.append([B[j][0], B[j][1]])
                    j += 1
                else:
                    intervals.append([B[j][0], A[i][1]])
                    i += 1
            else:
                if A[i][1] < B[j][1]:
                    i += 1
                else:
                    j += 1
        return intervals

A = [[0,2],[5,10],[13,23],[24,25]]
B = [[1,5],[8,12],[15,24],[25,26]]
print("Solution to", A, B, "is",
        Solution().intervalIntersection(A, B))
