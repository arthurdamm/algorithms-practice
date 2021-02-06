# LeetCode 71. Simplify Path
# https://leetcode.com/problems/simplify-path/
# O(n) time-and-space
class Solution:
    def simplifyPath(self, path: str, stack=[]) -> str:
        return (stack.clear(), [stack.append(part) if part != ".." else stack.pop() if stack else None for part in path.split("/") if part not in {"", "."}], "/" + "/".join(stack))[-1]
