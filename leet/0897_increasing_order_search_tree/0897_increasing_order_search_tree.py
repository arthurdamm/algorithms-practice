# LeetCode 897. Increasing Order Search Tree
# O(n) time, O(h) space
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        self.prev = dummy = TreeNode()
        self.inOrder(root)
        return dummy.right
    
    def inOrder(self, root: TreeNode):
        if not root:
            return
        self.inOrder(root.left)
        root.left = None
        self.prev.right = self.prev = root
        self.inOrder(root.right)
