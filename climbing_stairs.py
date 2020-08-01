#!/usr/bin/env python3
"""
Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
"""

class Solution:
    def climbStairs(self, n: int) -> int:
        if n is 1:
            return 1
        a = b = 1
        for i in range(2, n + 1):
            c = a + b
            a = b
            b = c
        return c

