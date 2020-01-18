# LeetCode 13. Roman to Integer
class Solution:
    def romanToInt(self, s: str) -> int:
        mapRomanToInt = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        prev = 0
        num = 0
        for r in s:
            val = mapRomanToInt[r]
            if val > prev:
                num -= prev * 2
            num += val
            prev = val
        return num

