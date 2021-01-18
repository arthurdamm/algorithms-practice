# LeetCode 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
# https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
# O(nlogn) time, O(n) space
class Solution:
    def alertNames(self, keyName: List[str], keyTime: List[str]) -> List[str]:
        workerTimes = defaultdict(list)
        for i in range(len(keyName)):
            s = keyTime[i]
            minutes = int(s[0]) * 60 * 10 + int(s[1]) * 60 + int(s[3]) * 10 + int(s[4])
            workerTimes[keyName[i]].append(minutes)
        ret = []
        for name, times in workerTimes.items():
            times.sort()
            for i in range(2, len(times)):
                if times[i] - times[i - 2] <= 60:
                    ret.append(name)
                    break
        return sorted(ret)
