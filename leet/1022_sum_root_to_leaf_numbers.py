# LeetCode 1022. Sum of Root To Leaf Binary Numbers
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        def dfs(node, prefix):
            if not node: return 0
            prefix = (prefix << 1) + node.val
            if not node.left and not node.right:
                return prefix
            return dfs(node.left, prefix) + dfs(node.right, prefix)
        return dfs(root, 0)

