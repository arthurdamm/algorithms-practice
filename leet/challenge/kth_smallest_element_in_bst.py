#!/usr/bin/env python3
"""
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.count = 0
        self.k = k
        def inOrderTraversal(root):
            if not root:
                return
            inOrderTraversal(root.left)
            self.count += 1
            if self.count == self.k:
                self.ret = root.val
                return
            inOrderTraversal(root.right)
        inOrderTraversal(root)
        return self.ret
