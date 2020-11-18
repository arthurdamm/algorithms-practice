#!/usr/bin/env python3
# 858. Mirror Reflection
# O(p) time, O(1) space 

class Solution:
    def mirrorReflection(self, p: int, q: int) -> int:
        n, m = 1, 1
        while m * p != n * q:
            n += 1
            m = n * q // p
        if m % 2 == 1 and n % 2 == 1:
            return 1
        if m % 2 == 1 and n % 2 == 0:
            return 2
        if m % 2 == 0 and n % 2 == 1:
            return 0
