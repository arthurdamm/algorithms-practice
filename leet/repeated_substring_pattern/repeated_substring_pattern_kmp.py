class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        def KMPTable(s):
            f = [0] * len(s)
            for i in range(1, len(s)):
                t = f[i - 1]
                while t > 0 and s[i] != s[t]:
                    t = f[t - 1]
                if s[i] == s[t]:
                    t += 1
                f[i] = t
            return f
        kmp = KMPTable(s)
        n =  len(s)
        return kmp[n - 1] and (n % (n - kmp[n - 1]) == 0)

s = "abaaba"
s = "abacababacab"
print("Solution to", s, Solution().repeatedSubstringPattern(s))
