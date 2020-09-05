"""
1305. All Elements in Two Binary Search Trees
O(N + M) time, O(N + M) space

Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        def bst2list(root, ret):
            if not root: return
            bst2list(root.left, ret)
            ret.append(root.val)
            bst2list(root.right, ret)
            
        list1 = []
        bst2list(root1, list1)
        list2 = []
        bst2list(root2, list2)
        
        i, j = 0, 0
        list3 = []
        while i < len(list1) and j < len(list2):
            if list1[i] < list2[j]:
                list3.append(list1[i])
                i += 1
            else:
                list3.append(list2[j])
                j += 1
        while i < len(list1):
            list3.append(list1[i])
            i += 1
        while j < len(list2):
            list3.append(list2[j])
            j += 1
        return list3
