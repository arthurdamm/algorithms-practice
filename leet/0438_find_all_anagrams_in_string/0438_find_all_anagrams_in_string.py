# LeetCode 438. Find All Anagrams in a String
# https://leetcode.com/problems/find-all-anagrams-in-a-string/
# O(n + m) time, O(m) space
from collections import Counter, defaultdict
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        needCounter = Counter(p)
        haveCounter = defaultdict(int)
        extraLetters = 0
        needLetters = sum(needCounter.values())
        solution = []
        i = 0
        j = -1
        while j < len(s):
            if j < i or (extraLetters == 0 and needLetters > 0):
                j += 1
                if j == len(s): break
                if s[j] in needCounter:
                    haveCounter[s[j]] += 1
                    if haveCounter[s[j]] <= needCounter[s[j]]:
                        needLetters -= 1
                        if needLetters == 0 and extraLetters == 0:
                            solution.append(i)
                    else:
                        extraLetters += 1
                else:
                    extraLetters += 1
            else:
                if s[i] in needCounter:
                    haveCounter[s[i]] -= 1
                    if haveCounter[s[i]] < needCounter[s[i]]:
                        needLetters += 1
                    else:
                        extraLetters -= 1
                else:
                    extraLetters -= 1
                i += 1
        return solution
