# LeetCode 754. Reach a Number
# https://leetcode.com/problems/reach-a-number/
# O(1) time O(1) space
class Solution:
    def reachNumber(self, target: int) -> int:
        target = abs(target)
        n = math.ceil((-1 + math.sqrt(1 + 8*target)) / 2)
        s = n * (n + 1) / 2
        if (s - target) % 2 == 0:
            return n
        return n + (1 if (s + n + 1 - target) % 2 == 0 else 2)

# O(root(n)) time O(1) space
class Solution:
    def reachNumber(self, target: int) -> int:
        target = abs(target)
        n, s = 0, 0
        while s < target:
            n += 1
            s += n
        if (s - target) % 2 == 0:
            return n
        return n + (1 if (s + n + 1 - target) % 2 == 0 else 2)
