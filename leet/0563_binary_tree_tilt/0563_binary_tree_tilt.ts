// LeetCode 563. Binary Tree Tilt
// https://leetcode.com/problems/binary-tree-tilt/
// O(n) time, O(h) space
function findTilt(root: TreeNode | null): number {
    let tiltSum = 0;
    const dfs = (root: TreeNode | null): number => {
        if (!root) return 0;
        const leftSum = dfs(root.left);
        const rightSum = dfs(root.right);
        tiltSum += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
    dfs(root);
    return tiltSum;
};

