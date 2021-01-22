// LeetCode 497. Random Point in Non-overlapping Rectangles
// https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
// O(n) time-and-space
class Solution {
    int[][] rects;
    int points;
    public Solution(int[][] rects) {
        this.rects = rects;
        for (var r : rects) {
            int x = r[2] - r[0] + 1;
            int y = r[3] - r[1] + 1;
            points += (x * y);
        }
    }
    
    public int[] pick() {
        int point = (int)(Math.random() * (points + 0)) + 1;
        for (var r : rects) {
            int x = r[2] - r[0] + 1;
            int y = r[3] - r[1] + 1;
            int points = x * y;
            if (point <= points) {
                point--;
                return new int[]{r[0] + point % x, r[1] + point / x};
            } else
                point -= points;
        }
        return null;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
