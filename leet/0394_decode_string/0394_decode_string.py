# LeetCode 394. Decode String
# https://leetcode.com/problems/decode-string/
# O(n) time-and-space
class Solution:
    def decodeString(self, s: str) -> str:
        numStack, indexStack, strStack = [], [], []
        num = 0
        substr = ""
        for i, c in enumerate(s):
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':
                strStack.append(substr)
                substr = ""
                numStack.append(num)
                num = 0
            elif c == "]":
                substr = strStack.pop() + numStack.pop() * substr
            else:
                substr += c
        return substr
