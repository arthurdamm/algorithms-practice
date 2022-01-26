# LeetCode 1305. All Elements in Two Binary Search Trees
# https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
# O(n + m) time-and-space
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        def inOrderArray(root: TreeNode, arr: List[int]):
            if root:
                inOrderArray(root.left, arr)
                arr.append(root.val)
                inOrderArray(root.right, arr)
            return arr
        
        def mergeSortedArrays(arr1: List[int], arr2: List[int]) -> List[int]:
            i, j, res = 0, 0, []
            while i < len(arr1) and j < len(arr2):
                if arr1[i] < arr2[j]:
                    res.append(arr1[i])
                    i += 1
                else:
                    res.append(arr2[j])
                    j += 1
            if i < len(arr1):
                res += arr1[i:]
            else:
                res += arr2[j:]
            return res
        
        return mergeSortedArrays(inOrderArray(root1, []), inOrderArray(root2, []))
    
