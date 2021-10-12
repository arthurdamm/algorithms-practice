// LeetCode 374. Guess Number Higher or Lower
// https://leetcode.com/problems/guess-number-higher-or-lower/
// O(logn) time, O(1) space
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2, guess = guess(mid);
            if (guess < 0)
                hi = mid - 1;
            else if (guess > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }
}
