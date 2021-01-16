// LeetCode 1311. Get Watched Videos by Your Friends
// https://leetcode.com/problems/get-watched-videos-by-your-friends/
// O(n + mlogm) time O(n + m) space
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> movieCount = new HashMap<>();
        boolean visited[] = new boolean[friends.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);    
        visited[id] = true;
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; sz--) {
                int currId = queue.poll();
                if (level == 0) {
                    for (String movie: watchedVideos.get(currId))
                        movieCount.put(movie, movieCount.getOrDefault(movie, 0) + 1);
                } else {
                    for (int friend : friends[currId]) {
                        if (!visited[friend]) {
                            visited[friend] = true;
                            queue.offer(friend);
                        }
                    }
                }
            }
            level--;
        }
        List<String>movies = new ArrayList(movieCount.keySet());
        Collections.sort(movies, (a, b) -> movieCount.get(a) - movieCount.get(b) == 0 ?
            a.compareTo(b) : movieCount.get(a) - movieCount.get(b));
        return movies;
    }
}
