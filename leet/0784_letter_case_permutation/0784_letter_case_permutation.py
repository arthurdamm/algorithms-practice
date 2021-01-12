# LeetCode 784. Letter Case Permutation
# https://leetcode.com/problems/letter-case-permutation/
# O(2^n) time, O(n) space
class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        self.answers = []
        self.backtrack(list(S), 0)
        return self.answers

    def backtrack(self, string, i):
        if i == len(string):
            self.answers.append("".join(string))
            return
        string[i] = string[i].upper()
        self.backtrack(string, i + 1)
        if string[i].upper() != string[i].lower():
            string[i] = string[i].lower()
            self.backtrack(string, i + 1)
