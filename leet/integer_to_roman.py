# LeetCode 12. Integer to Roman
import bisect

class Solution:
    def intToRoman(self, num: int) -> str:
        mapIntToRoman = {1000: 'M', 900: 'CM', 500: 'D', 400: 'CD', 100: 'C', 90: 'XC', 50: 'L', 40: 'XL', 10: 'X', 9: 'IX', 5: 'V', 4: 'IV', 1: 'I'}
        keys = sorted(list(mapIntToRoman.keys()))
        ret = ""
        while num > 0:
            digit = keys[bisect.bisect(keys, num) - 1]
            ret += mapIntToRoman[digit]
            num -= digit
        return ret

