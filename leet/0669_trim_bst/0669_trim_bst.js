// 669. Trim a Binary Search Tree
// https://leetcode.com/problems/trim-a-binary-search-tree/
// O(n) time, O(h) space
var trimBST = function(root, low, high) {
    this.low = low;
    this.high = high;
    return _trimBST(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER); 
     
    function _trimBST(root, low, high) {
        if (root == null)
            return null;
        if (root.val >= this.low && root.val <= this.high) {
            root.left = _trimBST(root.left, low, root.val);
            root.right = _trimBST(root.right, root.val, high);
            return root;
        } else if (root.val < this.low && high >= this.low)
            return _trimBST(root.right, root.val, high);
        else if (root.val > this.high && low <= this.high)
            return _trimBST(root.left, low, root.val);
        return null;
    }    
};
