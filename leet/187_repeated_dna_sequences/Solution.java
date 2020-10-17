// LeetCode 187. Repeated DNA Sequences
// O(n) time, O(n) space

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> ret = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substr = s.substring(i, i + 10);
            if (seen.contains(substr))
                ret.add(substr);
            else
                seen.add(substr);
        }
        return new ArrayList<>(ret);
    }
}
