# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        self.i = 1
        def insert(node, hi):
            if self.i < len(preorder) and preorder[self.i] < node.val:
                node.left = TreeNode(preorder[self.i])
                self.i += 1
                insert(node.left, node.val)
            if self.i < len(preorder) and preorder[self.i] <= hi:
                node.right = TreeNode(preorder[self.i])
                self.i += 1
                insert(node.right, hi)
            
        root = TreeNode(preorder[0])
        insert(root, float('inf'))
        return root
