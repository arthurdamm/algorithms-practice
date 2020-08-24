#!/usr/bin/env python3
"""
437. Path Sum III
O(n) time, O(n) space solution.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root, sum, target):
        if not root: return
        sum += root.val
        self.count += self.seen[sum - target]
        self.seen[sum] += 1
        self.dfs(root.left, sum, target)
        self.dfs(root.right, sum, target)
        self.seen[sum] -= 1
        
    def pathSum(self, root: TreeNode, sum: int) -> int:
        self.seen = defaultdict(int)
        self.count = 0
        self.seen[0] += 1
        self.dfs(root, 0, sum)
        return self.count
