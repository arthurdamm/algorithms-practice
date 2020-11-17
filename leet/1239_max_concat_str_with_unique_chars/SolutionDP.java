// LeetCode 1239. Maximum Length of a Concatenated String with Unique Characters
// O(n^2) time O(n) space

class SolutionDP {
    public int maxLength(List<String> arr) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        int max = 0;
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                if ((mask & (1 << (s.charAt(i) - 'a'))) != 0)
                {
                    mask = 0;
                    break;
                }
                mask |= 1 << (s.charAt(i) - 'a');
            }
            if (mask == 0)
                continue;            
            Map<Integer, Integer> dp2 = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
                if ((e.getKey() & mask) != 0)
                    continue;
                int len = e.getValue() + s.length();
                dp2.put(e.getKey() | mask, len);
                max = Math.max(max, len);
            }
            dp.putAll(dp2);
        }
        return max;
    }
}
