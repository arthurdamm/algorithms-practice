// LeetCode 1481. Least Number of Unique Integers after K Removals
// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
// O(nlogm) time, O(n + m) space
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : arr)
            count.put(n, count.getOrDefault(n, 0) + 1);
        
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer c : count.values()) {
            if (c <= k) {
                k -= c;
                maxheap.offer(c);
            } else if (!maxheap.isEmpty() && c < maxheap.peek()) {
                k += maxheap.poll();
                k -= c;
                maxheap.offer(c);
            }
        }
        return count.size() - maxheap.size();
    }
}
