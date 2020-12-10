// LeetCode 941. Valid Mountain Array
// O(n) time, O(1) space
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var validMountainArray = function(arr) {
    const UP = 1, DOWN = 2, NONE = 0;
    var state = NONE;
    if (arr.length < 3)
        return false;
    for (var i = 0; i < arr.length - 1; i++) {
        if (arr[i + 1] == arr[i])
            return false;
        if (arr[i + 1] > arr[i]) {
            if (state == DOWN)
                return false;
            state = UP;
        }
        if (arr[i + 1] < arr[i]) {
            if (state == NONE)
                return false;
            state = DOWN;
        }
    }
    return state == DOWN;
};

