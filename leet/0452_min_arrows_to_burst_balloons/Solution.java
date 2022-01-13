// LeetCode 452. Minimum Number of Arrows to Burst Balloons
// O(nlogn) time, O(1) space
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (p1, p2) -> p1[0] < p2[0] ? -1 : 1);
        int[] cover = new int[2];
        int arrows = 1;
        boolean covering = false;
        for (int i = 1; i < points.length; i++) {
            if (!covering) {
                if (points[i - 1][1] < points[i][0]) {
                    arrows++;
                } else {
                    cover[0] = points[i][0];
                    cover[1] = Math.min(points[i][1], points[i - 1][1]);
                    covering = true;
                }
            } else {
                if (cover[1] < points[i][0]) {
                    arrows++;
                    covering = false;
                } else {
                    cover[1] = Math.min(points[i][1], cover[1]);
                }
            }
        }
        return arrows;
    }
}

