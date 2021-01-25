// LeetCode 331. Verify Preorder Serialization of a Binary Tree
// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// O(n) time, O(height) space
var isValidSerialization = function(preorder) {
    let preOrder = function() {
        if (i == vals.length)
            return false;
        if (vals[i] === "#")
            return true;
        i++;
        if (!preOrder())
            return false;
        i++;
        if (!preOrder())
            return false;
        return true;
    }    
    let i = 0;
    let vals = preorder.split(",");
    return preOrder() && i == vals.length - 1;
};
