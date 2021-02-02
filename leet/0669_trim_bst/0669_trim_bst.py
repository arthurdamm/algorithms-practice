# 669. Trim a Binary Search Tree
# https://leetcode.com/problems/trim-a-binary-search-tree/
# O(n) time, O(h) space
class Solution:
    def trimBST(self, root: TreeNode, low: int, high: int) -> TreeNode:
        def _trimBST(root: TreeNode, local_low: int, local_high: int) -> TreeNode:
            if not root:
                return None
            if low <= root.val <= high:
                root.left = _trimBST(root.left, local_low, root.val)
                root.right = _trimBST(root.right, root.val, local_high)
                return root
            if root.val < low and local_high > low:
                return _trimBST(root.right, root.val, local_high)
            elif root.val > high and local_low < high:
                return _trimBST(root.left, local_low, root.val)
        return _trimBST(root, float('-inf'), float('inf'))
