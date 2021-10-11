// LeetCode 543. Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/
// O(n) time, O(h) space
function diameterOfBinaryTree(root: TreeNode | null): number {
    let diameter = 0;
    const height = (root: TreeNode | null) => {
        if (!root) return 0;
        const leftHeight = height(root.left);
        const rightHeight = height(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    height(root);
    return diameter - 1;
};
