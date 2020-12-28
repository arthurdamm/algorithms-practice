// LeetCode 1345. Jump Game IV
// https://leetcode.com/problems/jump-game-iv/
// O(n) time O(n) space
class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int steps = 0;
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; sz--) {
                int i = queue.poll();
                if (i == arr.length - 1)
                    return steps;
                if (visited[i])
                    continue;
                visited[i] = true;
                if (i > 0 && !visited[i - 1])
                    queue.offer(i - 1);
                if (i < arr.length - 1 && !visited[i + 1])
                    queue.offer(i + 1);
                if (map.containsKey(arr[i])) {
                    for (int j : map.get(arr[i]))
                        if (!visited[j])
                            queue.offer(j);
                    map.remove(arr[i]);
                }
            }
            steps++;
        }
        return steps;
    }
}
