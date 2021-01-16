// LeetCode 1248. Count Number of Nice Subarrays
// https://leetcode.com/problems/count-number-of-nice-subarrays/
// O(n) time O(k) space
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int num = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) {
                k--;
                deque.offerLast(j);
            }
            if (k < 0) {
                while (nums[i] % 2 == 0)
                    i++;
                i++;
                k++;
                while (!deque.isEmpty() && deque.peekFirst() < i)
                    deque.pollFirst();
            }
            if (k == 0) {
                num += deque.peekFirst() - i + 1;
            }
        }
        return num;
    }
}
