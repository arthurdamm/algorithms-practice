# LeetCode 205. Isomorphic Strings
# https://leetcode.com/problems/isomorphic-strings/
# O(n) time-and-space

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        def getSignature(s):
            # rewrite the string using smallest letters in order
            # so `foobar` & 'ziirab' gets turned into 'abbcde'
            keys, values = dict(), set()
            currentLetter = 'a'
            signature = [''] * len(s)
            for i in range(len(s)):
                if s[i] not in keys:
                    keys[s[i]] = currentLetter
                    currentLetter = chr(ord(currentLetter) + 1)
                signature[i] = keys[s[i]]
            return signature

        return getSignature(s) == getSignature(t)

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(set(zip(s, t))) == len(set(s)) == len(set(t))

