// LeetCode 1675. Minimize Deviation in Array
// https://leetcode.com/problems/minimize-deviation-in-array/
// O(klogn) time, O(n) space
class Solution {
    static void p(Object o) { System.out.println(o); }
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->nums[a]-nums[b]);
        int numsMax[] = new int[nums.length], max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            numsMax[i] = nums[i] << (nums[i] & 1);
            while ((nums[i] & 1) == 0)
                nums[i] >>= 1;
            heap.offer(i);
            max = Math.max(max, nums[i]);
        }
        int diff = Integer.MAX_VALUE;
        while (true) {
            int i = heap.poll();
            diff = Math.min(diff, max - nums[i]);
            if (nums[i] == numsMax[i])
                break;
            max = Math.max(max, nums[i] <<= 1);
            heap.offer(i);
        }
        return diff;
    }
}
