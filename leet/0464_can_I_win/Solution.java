// LeetCode 464. Can I Win
// https://leetcode.com/problems/can-i-win/
// O(n*2^n) time, O(2^n) space
class Solution {
    int desiredTotal, maxChoosableInteger;
    Map<Integer, Boolean> memo = new HashMap<>();
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.desiredTotal = desiredTotal;
        this.maxChoosableInteger = maxChoosableInteger;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false;
        return desiredTotal > 0 ? choose(0, 0) : true;
    }
    
    private boolean choose(int chosenBits, int total) {
        if (total >= desiredTotal)
            return false;
        if (memo.containsKey(chosenBits))
            return memo.get(chosenBits);
        boolean result = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((chosenBits & (1 << i)) == 0) {
                if (!choose(chosenBits | (1 << i), total + i + 1)) {
                    result = true;
                    break;
                }
            }
        }
        memo.put(chosenBits, result);
        return result;
    }
}
