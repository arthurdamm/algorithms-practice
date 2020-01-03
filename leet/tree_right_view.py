# LeetCode 199 Binary Tree Right Side View

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root: return []
        queue = [root]
        rightview = []
        while len(queue) > 0:
            rightview.append(queue[-1].val)
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
        return rightview

