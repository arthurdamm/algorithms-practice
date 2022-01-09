// LeetCode 1041. Robot Bounded In Circle
// https://leetcode.com/problems/robot-bounded-in-circle/
// O(n) time, O(1) space
var isRobotBounded = function(instructions) {
    var dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    var dirIndex = 0;
    var location = [0, 0];
    for (instruction of instructions) {
        switch (instruction) {
            case "G":
                location[0] += dirs[dirIndex][0];
                location[1] += dirs[dirIndex][1];
                break;
            case "L":
                dirIndex = (dirIndex + 3) % 4;
                break;
            case "R":
                dirIndex = (dirIndex + 1) % 4;
                break;
        }
    }
    return dirIndex !== 0 || (location[0] === 0 && location[1] === 0);
};
