// LeetCode 1239. Maximum Length of a Concatenated String with Unique Characters
// O(2^n) time, O(n) space

class Solution {
    String arr[];
    int masks[];
    
    public int maxLength(List<String> arr) {
        this.arr = arr.toArray(new String[0]);
        this.masks = new int[this.arr.length];
        int x = 0;
        for (String s : this.arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                if ((mask & (1 << (s.charAt(i) - 'a'))) != 0)
                {
                    mask = 0;
                    break;
                }
                mask |= 1 << (s.charAt(i) - 'a');
            }
            this.masks[x++] = mask;
        }
        return dfs(0, 0);
    }
    
    int dfs(int i, int mask) {
        if (i >= this.arr.length)
            return 0;
        int bits = this.masks[i];
        int len = dfs(i + 1, mask);
        if (bits != 0 && (bits & mask) == 0)
            len = Math.max(dfs(i + 1, mask | bits) + this.arr[i].length(), len);
        return len;
    }
}
