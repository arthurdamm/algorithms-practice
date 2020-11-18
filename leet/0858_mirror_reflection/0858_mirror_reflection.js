// LeetCode 858. Mirror Reflection
// O(p) time, O(1) space
/**
 * @param {number} p
 * @param {number} q
 * @return {number}
 */
var mirrorReflection = function(p, q) {
    let a = 1, b = 1;
    while (a * p != b * q)
        a = parseInt(++b * q / p);
    if (a % 2 == 1 && b % 2 == 0)
        return 2;
    if (a % 2 == 1 && b % 2 == 1)
        return 1;
    if (a % 2 == 0 && b % 2 == 1)
        return 0;
};
