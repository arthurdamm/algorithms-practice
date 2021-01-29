# LeetCode 987. Vertical Order Traversal of a Binary Tree
# https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
# O(nlogn) time, O(n) space
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        nodes = []
        def dfs(root, x, y):
            if not root:
                return
            nodes.append((x, -y, root.val))
            dfs(root.left, x - 1, y - 1)
            dfs(root.right, x + 1, y - 1)
        dfs(root, 0, 0)
        nodes.sort()
        reports = []
        prevX = nodes[0][0]
        prevReport = [nodes[0][2]]
        for i in range(1, len(nodes)):
            if nodes[i][0] != prevX:
                reports.append(prevReport)
                prevX = nodes[i][0]
                prevReport = [nodes[i][2]]
            else:
                prevReport.append(nodes[i][2])
        reports.append(prevReport)
        return reports
