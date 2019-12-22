# House Robber 3
# Max sum of non-directly-linked nodes in binary tree
# O(n) time complexity

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rob(self, root: TreeNode) -> int:
        return max(self.robber(root))
        
    def robber(self, root: TreeNode) -> int:
        if not root: return (0, 0)
        left = self.robber(root.left)
        right = self.robber(root.right)
        return (root.val + left[1] + right[1],
                max(left) + max(right))
