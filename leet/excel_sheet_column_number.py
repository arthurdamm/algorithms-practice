#!/usr/bin/env python3
# Excel Sheet Column Number

class Solution:
    def titleToNumber(self, s: str) -> int:
        base, num = 1, 0
        for digit in reversed(s):
            num += base * (ord(digit) - ord('A') + 1)
            base *= 26
        return num

input = "ZY"
print("Solution to", input, Solution().titleToNumber(input))
