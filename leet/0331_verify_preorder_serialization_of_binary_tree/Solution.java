// LeetCode 331. Verify Preorder Serialization of a Binary Tree
// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// O(n) time, O(height) space
class Solution {
    int i = 0;
    String vals[];
    public boolean isValidSerialization(String preorder) {
        vals = preorder.split(",");
        return preOrder() && i == vals.length - 1;
    }
    private boolean preOrder() {
        if (i == vals.length)
            return false;
        if (vals[i].equals("#"))
            return true;
        i++;
        if (!preOrder())
            return false;
        i++;
        if (!preOrder())
            return false;
        return true;
    }
}
