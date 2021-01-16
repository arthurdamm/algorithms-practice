// LeetCode 215. Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/
// O(nlogk) time O(k) space
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if(heap.peek() < num) {
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.peek();
    }
}
