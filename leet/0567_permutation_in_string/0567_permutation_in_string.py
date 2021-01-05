# LeetCode 567. Permutation in String
# https://leetcode.com/problems/permutation-in-string/
# O(n + m) time, O(1) space
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        c1, c2 = [0] * 26, [0] * 26
        sum1, sum2 = 0, 0

        for c in s1:
            c1[ord(c) - 97] += 1
            sum1 += 1
        for i, c in enumerate(s2):
            c = ord(c) - 97
            if c1[c] > 0: # add window right
                if c2[c] < c1[c]:
                    sum2 += 1
                c2[c] += 1
            if i >= len(s1): # remove window left
                c_left = ord(s2[i - len(s1)]) - 97
                if c1[c_left] > 0:
                    c2[c_left] -= 1
                    if c1[c_left] > c2[c_left]:
                        sum2 -= 1
            if sum2 == sum1:
                break
        return sum2 == sum1

# O(n + m) time, O(1) space
class SolutionDict:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        c1, c2 = Counter(s1), Counter()
        sum1, sum2 = sum(c1.values()), 0
        for i, c in enumerate(s2):
            if c1[c] > 0: # add window right
                if c2[c] < c1[c]:
                    sum2 += 1
                c2[c] += 1
            if i >= len(s1): # remove window left
                c_left = i - len(s1)
                if c1[s2[c_left]] > 0:
                    c2[s2[c_left]] -= 1
                    if c1[s2[c_left]] > c2[s2[c_left]]:
                        sum2 -= 1
            if sum2 == sum1:
                break
        return sum2 == sum1
