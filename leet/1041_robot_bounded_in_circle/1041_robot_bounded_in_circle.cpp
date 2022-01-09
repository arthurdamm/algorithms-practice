// LeetCode 1041. Robot Bounded In Circle
// https://leetcode.com/problems/robot-bounded-in-circle/
// O(n) time, O(1) space
class Solution {
public:
    bool isRobotBounded(string instructions) {
        int dirs[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int location[2] = {0, 0};
        for (char &c : instructions) {
            switch (c) {
                case 'G':
                    location[0] += dirs[dirIndex][0];
                    location[1] += dirs[dirIndex][1];
                    break;
                case 'R':
                    dirIndex = (dirIndex + 1) % 4;
                    break;
                case 'L':
                    dirIndex = (dirIndex + 3) % 4;
                    break;
            }
        }
        return (location[0] == 0 && location[1] == 0) || dirIndex != 0;
    }
};
