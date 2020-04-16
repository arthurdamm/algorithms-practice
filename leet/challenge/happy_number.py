#!/usr/bin/env python3
"""Is A Number Happy? Magical!"""

class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n not in seen and n != 1:         
            seen.add(n)
            squaresum = 0
            while n:
                squaresum += (n % 10) ** 2
                n //= 10
            n = squaresum
        return n == 1            

d = 123456
print("Solution", d, Solution().isHappy(d))

