// LeetCode 1041. Robot Bounded In Circle
// O(n) time O(1) space
class SolutionA {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int[] position = {0, 0};
        int dirFacing = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length(); i++) {
                if (instructions.charAt(i) == 'L') {
                    dirFacing--;
                    if (dirFacing < 0)
                        dirFacing += dirs.length;
                } else if (instructions.charAt(i) == 'R')
                    dirFacing = (dirFacing + 1) % dirs.length;       
                else {
                    position[0] += dirs[dirFacing][0];
                    position[1] += dirs[dirFacing][1];
                }   
            }
            if (position[0] == 0 && position[1] == 0)
                return true;

        }
        return position[0] == 0 && position[1] == 0;
    }
}
