# LeetCode 22. Generate Parentheses
# https://leetcode.com/problems/generate-parentheses/
# O(4^n / root(n)) time and space
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        self.answers = []
        self.backtrack(n, list("." * (2 * n)), 0, 0, 0)
        return self.answers
        
    def backtrack(self, n, string, i, opened, closed):
        if i == n * 2:
            self.answers.append("".join(string))
            return
        if opened == closed:
            string[i] = "("
            self.backtrack(n, string, i + 1, opened + 1, closed)
        else: # opened > closed
            string[i] = ")"
            self.backtrack(n, string, i + 1, opened, closed + 1)
            if opened < n:
                string[i] = "("
                self.backtrack(n, string, i + 1, opened + 1, closed)
