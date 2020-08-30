# LeetCode 1022. Sum of Root To Leaf Binary Numbers
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        self.sum = 0
        def dfs(node, prefix):
            if not node: return
            prefix = (prefix << 1) + node.val
            if not node.left and not node.right:
                self.sum += prefix
            else:
                dfs(node.left, prefix)
                dfs(node.right, prefix)
        dfs(root, 0)
        return self.sum

