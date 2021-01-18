// LeetCode 1679. Max Number of K-Sum Pairs
// https://leetcode.com/problems/max-number-of-k-sum-pairs/
// O(nlogn) time, O(1) space
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int pairs = 0, i = 0, j = nums.length - 1;
        while(i < j) {
            if (nums[i] + nums[j] == k) {
                pairs++;
                i++;
                j--;
            } else if (nums[i] + nums[j] > k)
                j--;
            else
                i++;
        }
        return pairs;
    }
}

// O(n) time-and-space
class SolutionLinear {    
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int pairs = 0;
        for (int n : nums) {
            int count = counter.getOrDefault(k - n, 0);
            if (count > 0) {
                pairs++;
                counter.put(k - n, count - 1);
            } else
                counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        return pairs;
    }
}
