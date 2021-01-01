// LeetCode 84. Largest Rectangle in Histogram
// https://leetcode.com/problems/largest-rectangle-in-histogram/
// O(n) time O(n) space
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> istack = new Stack<>(), hstack = new Stack<>();
        int max = 0, i, prev;
        for (i = 0; i < heights.length; i++) {
            prev = Integer.MAX_VALUE;
            while (!hstack.isEmpty() && hstack.peek() > heights[i])
                max = Math.max(max, hstack.pop() * (i - (prev = istack.pop())));
            if (hstack.isEmpty() || hstack.peek() < heights[i]) {
                hstack.push(heights[i]);
                istack.push(Math.min(prev, i));
            }
                
        }
        while (!hstack.isEmpty())
            max = Math.max(max, hstack.pop() * (i - istack.pop()));
        return max;
    }
}
