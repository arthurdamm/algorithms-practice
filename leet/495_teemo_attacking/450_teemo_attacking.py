# 495. Teemo Attacking
# O(n) time O(1) space
class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        if not timeSeries:
            return 0
        poisoned = duration
        last_start = timeSeries[0]
        for i in range(1, len(timeSeries)):
            if timeSeries[i] > timeSeries[i - 1] + duration:
                poisoned += duration
            else:
                poisoned += timeSeries[i] - timeSeries[i - 1];
        return poisoned
