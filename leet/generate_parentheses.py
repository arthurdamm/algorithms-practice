# LeetCode 22 Generate Parentheses

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        return self.pg(n)

    def pg(self, n):
      if n == 1:
        return ["()"]
      l = []
      for s in self.pg(n-1):
        i = s.find(')')
        while i != -1:
          l.append(s[:i] + "()" + s[i:])
          l.append(s[:i + 1] + "()" + s[i + 1:])
          i = s.find(')', i + 1)
      return set(l)
