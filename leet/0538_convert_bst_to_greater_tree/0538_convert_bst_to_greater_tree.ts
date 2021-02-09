// LeetCode 538. Convert BST to Greater Tree
// https://leetcode.com/problems/convert-bst-to-greater-tree/
// O(n) time, O(h) space
function convertBST(root: TreeNode | null): TreeNode | null {
    const sumRight = function(root: TreeNode | null, greater: number): number {
        if (!root)
            return greater;
        let rightSum = sumRight(root.right, greater);
        let leftSum = sumRight(root.left, root.val + rightSum);
        root.val += rightSum;
        return leftSum;
    }
    sumRight(root, 0);
    return root;
};
