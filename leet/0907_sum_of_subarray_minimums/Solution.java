// LeetCode 907. Sum of Subarray Minimums
// https://leetcode.com/problems/sum-of-subarray-minimums/
// O(n) time-and-space
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int leftCounts[] = new int[arr.length],
            rightCounts[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                count += leftCounts[stack.pop()];
            leftCounts[i] = count + 1;
            stack.push(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                count += rightCounts[stack.pop()];
            rightCounts[i] = count + 1;
            stack.push(i);
        }
        long sum = 0, MOD = (int)1e9 + 7;
        for (int i = 0; i < arr.length; i++)
            sum = (sum + (long)leftCounts[i] * rightCounts[i] * arr[i]) % MOD;
        return (int)sum;
    }
}
