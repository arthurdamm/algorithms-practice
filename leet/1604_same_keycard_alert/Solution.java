// LeetCode 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
// O(nlogn) time, O(n) space
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, ArrayList<Integer>> workerTimes = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            workerTimes.computeIfAbsent(keyName[i], k -> new ArrayList<>());
            workerTimes.get(keyName[i]).add(stringToMinutes(keyTime[i]));
        }
        
        List<String> ret = new ArrayList<>();
        for (var e : workerTimes.entrySet()) {
            var times = e.getValue();
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    ret.add(e.getKey());
                    break;
                }
            }       
        }
        Collections.sort(ret);
        return ret;
    }
    
    int stringToMinutes(String s) {
        int minutes = (s.charAt(0) - '0') * 10 * 60 +
            (s.charAt(1) - '0') * 60 +
            (s.charAt(3) - '0') * 10 +
            (s.charAt(4) - '0');
        return minutes;
    }
}
