# LeetCode 273. Integer to English Words
# https://leetcode.com/problems/integer-to-english-words/
# O(logn) time and space
class Solution:
    def numberToWords(self, num: int) -> str:
        under_twenty = ["Zero", "One", "Two", "Three", "Four", "Five",
                        "Six", "Seven", "Eight", "Nine", "Ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                        "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
                         "Seventy", "Eighty", "Ninety"]
        chunks = ["", "Thousand", "Million", "Billion"]
        def chunk(n):
            if n == 0:
                return ""
            if n < 20:
                return under_twenty[n] + " "
            if n < 100:
                return tens[n // 10] + " " + chunk(n % 10)
            return under_twenty[n // 100] + " Hundred " + chunk(n % 100) + ""
        
        if num == 0:
            return "Zero"
        i = 0
        s = ""
        while num > 0:
            if num % 1000 != 0:
                s = chunk(num % 1000) + chunks[i] + " " + s
            num //= 1000
            i += 1
        return s.strip()
