// LeetCode 1041. Robot Bounded In Circle
// O(n) time O(1) space
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int[] position = {0, 0};
        int dirFacing = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                dirFacing = (dirFacing + 3) % dirs.length;
            } else if (instructions.charAt(i) == 'R')
                dirFacing = (dirFacing + 1) % dirs.length;       
            else {
                position[0] += dirs[dirFacing][0];
                position[1] += dirs[dirFacing][1];
            }   
        }
        return dirFacing != 0 || (position[0] == 0 && position[1] == 0);
    }
}
