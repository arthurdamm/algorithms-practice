// LeetCode 238. Product of Array Except Self
// https://leetcode.com/problems/product-of-array-except-self/
// O(n) time, O(1) space
function productExceptSelf(nums: number[]): number[] {
    const output = Array(nums.length).fill(1);
    let prefix = 1, suffix = 1;
    for (let i = 0; i < nums.length; i++) {
        output[i] = prefix;
        prefix *= nums[i]; 
    }
    for (let i = nums.length - 1; i >= 0; i--) {
        output[i] *= suffix;
        suffix *= nums[i];   
    }
    return output;
};

