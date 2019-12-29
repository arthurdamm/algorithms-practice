#!/usr/bin/env python3
# LeetCode 113 Path Sum 2

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        ret = []
        self.dfs(root, sum, [], ret)
        return ret
    
    def dfs(self, root, sum, path, ret):
        if not root: return
        path.append(root.val)
        if not root.left and not root.right and root.val == sum:
            ret.append(path[:])
        if root.left: self.dfs(root.left, sum - root.val, path, ret)
        if root.right: self.dfs(root.right, sum - root.val, path, ret)
        path.pop()
