#!/usr/bin/env node
/**
 * LeetCode 112 Path Sum
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */
var hasPathSum = function(root, sum) {
    if (!root) return false;
    if (sum == root.val && !root.left && !root.right)
        return true;
    return hasPathSum(root.left, sum - root.val) ||
        hasPathSum(root.right, sum - root.val);
};

