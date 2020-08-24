#!/usr/bin/env java
/*
437. Path Sum III
O(n) time, O(n) space solution.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.HashMap;

class Solution {
    int count = 0;
    Map<Integer, Integer> seen = new HashMap<>();
    public void dfs(TreeNode root, int sum, int target)
    {
        if (root == null) return;
        sum += root.val;
        count += seen.getOrDefault(sum - target, 0);
        seen.put(sum, seen.getOrDefault(sum, 0) + 1);
        dfs(root.left, sum, target);
        dfs(root.right, sum, target);
        seen.put(sum, seen.get(sum) - 1);
    }
    public int pathSum(TreeNode root, int sum) {
        seen.put(0, 1);
        dfs(root, 0, sum);
        return count;
    }
}
