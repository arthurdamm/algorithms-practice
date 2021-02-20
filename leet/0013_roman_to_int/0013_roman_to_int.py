# LeetCode 13. Roman to Integer
# https://leetcode.com/problems/roman-to-integer/
# O(n) time, O(1) space
class Solution:
    def romanToInt(self, s):
        digits = {"I": 1, "V": 5, "X": 10, "L": 50, "C":100, "D": 500, "M":1000}
        num = 0
        for i in range(len(s) - 1, -1, -1):
            if i < len(s) - 1 and digits[s[i]] < digits[s[i + 1]]:
                num -= digits[s[i]]
            else:
                num += digits[s[i]]
        return num
