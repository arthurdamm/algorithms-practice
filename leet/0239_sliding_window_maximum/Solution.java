// LeetCode 239. Sliding Window Maximum
// O(n) time, O(k) space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ret = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (deque.peekFirst() != null && i - deque.peekFirst() >= k)
                deque.removeFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();
            deque.addLast(i);
            if (i >= k - 1)
                ret[j++] = nums[deque.peekFirst()];
        }
        return ret;
    }
}
