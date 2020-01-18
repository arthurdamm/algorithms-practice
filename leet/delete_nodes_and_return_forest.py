# LeetCode 1110. Delete Nodes And Return Forest
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        to_delete = set(to_delete)
        forest = []
        root = self.dfs(root, to_delete, forest)
        if root: forest.append(root)
        return forest

    def dfs(self, root, to_delete, forest):
        if not root: return
        root.left = self.dfs(root.left, to_delete, forest)
        root.right = self.dfs(root.right, to_delete, forest)
        if root.val in to_delete:
            if root.left: forest.append(root.left)
            if root.right: forest.append(root.right)
            return None
        return root

