// 495. Teemo Attacking
// O(n) time, O(1) space
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        int poisoned = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > timeSeries[i - 1] + duration)
                poisoned += duration;
            else
                poisoned += timeSeries[i] - timeSeries[i - 1];
        }
        return poisoned;
            
    }
}
