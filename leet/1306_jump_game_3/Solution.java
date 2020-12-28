// LeetCode 1306. Jump Game III
// https://leetcode.com/problems/jump-game-iii/
// O(n) time O(n) space
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean visited[] = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int i = queue.poll();
                if (arr[i] == 0)
                    return true;
                visited[i] = true;
                if (i - arr[i] >= 0 && !visited[i - arr[i]])
                    queue.offer(i - arr[i]);
                if (i + arr[i] < arr.length && !visited[i + arr[i]])
                    queue.offer(i + arr[i]);
            }
        }
        return false;
    }
}
