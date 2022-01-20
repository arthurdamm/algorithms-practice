// LeetCode 875. Koko Eating Bananas
// https://leetcode.com/problems/koko-eating-bananas/
// O(nlogk) time, O(1) space
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles)
            maxPile = Math.max(maxPile, pile);
        int lo = 1, hi = maxPile + 1, sufficient = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2, hours = 0;
            for (int i = 0; i < piles.length && hours <= h; i++)
                hours += (piles[i] + mid - 1) / mid; // faster than Math.ceil((double)piles[i] / mid)
            if (hours <= h)
                sufficient = hi = mid;
            else
                lo = mid + 1;
        }
        return sufficient;
    }
}
