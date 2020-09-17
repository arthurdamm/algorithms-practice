// LeetCode 421. Maximum XOR of Two Numbers in an Array
// O(n) time-and-space
class Trie {
    Trie[] childs = {null, null};
    Integer val = null;
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie curr = root;
            Trie other = root;
            for (int i = 31; i >= 0; i--) {
                int bit = num >> i & 1;
                if (curr.childs[bit] == null)
                    curr.childs[bit] = new Trie();
                curr = curr.childs[bit];
                if (other.childs[bit ^ 1] != null)
                    other = other.childs[bit ^ 1];
                else
                    other = other.childs[bit];
            }
            curr.val = num;
            max = Math.max(max, other.val ^ curr.val);
        }
        return max;
    }
}

