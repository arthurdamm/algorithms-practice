# LeetCode 1003. Check If Word Is Valid After Substitutions
# https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
# O(n) time-and-space
class Solution:
    def isValid(self, s: str) -> bool:
        s1, s2 = [], []
        for i in range(len(s)):
            while s1 and len(s1) > i:
                s2.append(s1.pop())
            if len(s1) == i or s1[-1] != s[i]:
                if s[i] == "a":
                    s1.extend(["a", "b", "c"])
                else:
                    if not s2 or s2[-1] != s[i]:
                        return False
                    s1.append(s2.pop())
        return not s2
