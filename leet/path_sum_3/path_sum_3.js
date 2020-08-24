#!/usr/bin/env node
/*
437. Path Sum III
O(n) time, O(n) space solution.
*/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number}
 */

var count;
var seen;

var dfs = function(root, sum, target) {
    if (!root) return;
    sum += root.val;
    count += seen[sum - target] || 0;
    if (!seen[sum]) seen[sum] = 0;
    seen[sum]++;
    dfs(root.left, sum, target);
    dfs(root.right, sum, target);
    seen[sum]--;
}

var pathSum = function(root, sum) {
    count = 0;
    seen = {0: 1};
    dfs(root, 0, sum);
    return count;
};
