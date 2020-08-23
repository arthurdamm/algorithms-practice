#!/usr/bin/env python3
# O(n^2) time complexity, O(1) space

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.counter = 0
    def pathSum(self, root: TreeNode, sum: int) -> int:
        def dfs(node, sum):
            if not node.left and not node.right:
                if (node.val == sum):
                    self.counter += 1
                return
            if node.val == sum:
                self.counter += 1
            if node.left:
                dfs(node.left, sum - node.val)
            if node.right:
                dfs(node.right, sum - node.val)

        if not root:
            return self.counter
        dfs(root, sum)
        if root.left:
            self.pathSum(root.left, sum)
        if root.right:
            self.pathSum(root.right, sum)
        return self.counter

