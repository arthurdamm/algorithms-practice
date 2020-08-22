#!/usr/bin/env python3
"""
543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.diameter = float('-inf')
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.maxHeights(root)
        return self.diameter
    def maxHeights(self, root):
        if not root:
            return 0
        left_height = self.maxHeights(root.left)
        right_height = self.maxHeights(root.right)
        self.diameter = max(self.diameter, left_height + right_height)
        return max(left_height, right_height) + 1

