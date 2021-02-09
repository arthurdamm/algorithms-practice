# LeetCode 538. Convert BST to Greater Tree
# https://leetcode.com/problems/convert-bst-to-greater-tree/
# O(n) time, O(h) space
class Solution:
    def convertBST(self, root: TreeNode) -> TreeNode:
        def sumRight(root: TreeNode, greater: int) -> int:
            if not root:
                return greater
            rightSum = sumRight(root.right, greater)
            leftSum = sumRight(root.left, root.val + rightSum)
            root.val += rightSum
            return leftSum
        sumRight(root, 0)
        return root
