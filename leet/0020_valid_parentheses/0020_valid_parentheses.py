# LeetCode 20. Valid Parentheses
# https://leetcode.com/problems/valid-parentheses/
# O(n) time-and-space
class Solution:        
    def isValid(self, s: str) -> bool:
        parentheses = {"(":")", "{":"}", "[":"]"}
        stack = []
        for c in s:
            closing = parentheses.get(c, "")
            if closing:
                stack.append(closing)
            elif not stack or stack.pop() != c:
                return False
        return not stack
