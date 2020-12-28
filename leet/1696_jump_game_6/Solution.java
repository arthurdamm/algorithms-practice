// LeetCode 1696. Jump Game VI
// https://leetcode.com/problems/jump-game-vi/
// O(nlogn) time O(n) space
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dp[b] - dp[a]);
        dp[dp.length - 1] = nums[nums.length - 1];
        pq.offer(dp.length - 1);
        for (int i = dp.length - 2; i >= 0; i--) {
            while (pq.peek() - i > k)
                pq.poll();
            dp[i] = nums[i] + dp[pq.peek()];
            pq.offer(i);
        }
        return dp[0];
    }
}

// O(n) time O(k) space
class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<int[]> deque = new LinkedList<>();
        int dp = nums[nums.length - 1];
        deque.offer(new int[]{nums.length - 1, dp});
        for (int i = nums.length - 2; i >= 0; i--) {
            if (deque.peekFirst()[0] > i + k)
                deque.pollFirst();
            dp = deque.peekFirst()[1] + nums[i];
            while (!deque.isEmpty() && deque.peekLast()[1] < dp)
                deque.pollLast();
            deque.offer(new int[]{i, dp});
        }
        return dp;
    }
}
