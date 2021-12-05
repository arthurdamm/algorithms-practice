// LeetCode 337. House Robber III
// https://leetcode.com/problems/house-robber-iii/
// O(n) time, O(h) space
function rob(root: TreeNode | null): number {
    const dfs = (root: TreeNode | null): {inclusive: number, exclusive: number} => {
        if (!root) return {inclusive: 0, exclusive: 0};
        const left = dfs(root.left);
        const right = dfs(root.right);
        return {inclusive: root.val + left.exclusive + right.exclusive,
                exclusive: Math.max(left.exclusive, left.inclusive) +
                        Math.max(right.inclusive, right.exclusive)};
    }
    const result = dfs(root);
    return Math.max(result.inclusive, result.exclusive);
};

