from math import sqrt

class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        def getPrimeFactors(num):
            factors = set()
            while num % 2 == 0:
                num //= 2
                factors.add(2)
            for i in range(3, int(sqrt(num)) + 1, 2):
                while num % i == 0:
                    num //= i
                    factors.add(i)
                    if num <= 1:
                        break
            if num > 1:
                factors.add(num)
            return factors
        if len(s) < 2:
            return False
        factors = getPrimeFactors(len(s))
        if len(s) in factors:
            factors.remove(len(s))
        for factor in factors:
            if s[:(len(s) // factor)] * factor == s:
                return True
        if s[0] * len(s) == s:
            return True
        return False

s = "abaaba"
s = "abacababacab"
print("Solution to", s, Solution().repeatedSubstringPattern(s))
