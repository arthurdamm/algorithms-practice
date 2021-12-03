// 152. Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/
// O(n) time, O(1) space
function maxProduct(nums: number[]): number {
    let max = Number.MIN_SAFE_INTEGER, product = 1;
    for (let i = 0; i < nums.length; i++) {
        product *= nums[i];
        max = Math.max(product, max);
        product = product == 0 ? 1 : product;
    }
    product = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        product *= nums[i];
        max = Math.max(product, max);
        product = product == 0 ? 1 : product;
    }
    return max;
};
