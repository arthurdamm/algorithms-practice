# LeetCode 199. Binary Tree Right Side View
# https://leetcode.com/problems/binary-tree-right-side-view/
# O(n) time, O(h) space
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        def dfs(root, depth):
            if not root:
                return
            if len(rightNodes) < depth + 1:
                rightNodes.append(root.val)
            else:
                rightNodes[depth] = root.val
            dfs(root.left, depth + 1)
            dfs(root.right, depth + 1)
        rightNodes = []
        dfs(root, 0)
        return rightNodes
