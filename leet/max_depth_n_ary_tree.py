#!/usr/bin/env python3
"""
559. Maximum Depth of N-ary Tree

Given a n-ary tree, find its maximum depth.
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        return self._maxDepth(root, 1)
    def _maxDepth(self, root: 'Node', depth) -> int:
        if not root:
            return 0
        if not root.children:
            return depth
        return max(max([self._maxDepth(child, depth + 1) for child in root.children]), depth)

