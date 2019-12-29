/** LeetCode 11 Container With Most Water
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let i = 0, j = height.length - 1, max = Number.MIN_SAFE_INTEGER;
    while (i < j) {
        let water = Math.min(height[i], height[j]) * (j - i);
        max = Math.max(max, water);
        if (height[i] < height[j])
            i++;
        else
            j--;
    }
    return max;
};

