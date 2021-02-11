// LeetCode 464. Can I Win
// https://leetcode.com/problems/can-i-win/
// O(n*2^n) time, O(2^n) space
function canIWin(maxChoosableInteger: number, desiredTotal: number): boolean {
    const memo:Map<number, boolean> = new Map();
    const choose = function(chosenBits: number, total: number): boolean {
        if (total >= desiredTotal)
            return false;
        if (memo.has(chosenBits))
            return memo.get(chosenBits);
        let result = false;
        for (let i = 0; i < maxChoosableInteger; i++) {
            if ((chosenBits & (1 << i)) == 0) {
                if (!choose(chosenBits | (1 << i), total + i + 1)) {
                    result = true;
                    break;
                }
            }
        }
        memo.set(chosenBits, result);
        return result;
    }
    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
        return false;
    return desiredTotal ? choose(0, 0) : true;
};
