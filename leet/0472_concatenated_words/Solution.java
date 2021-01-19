// LeetCode 472. Concatenated Words
// https://leetcode.com/problems/concatenated-words/
// O(n*k^2) time, O(n*k) space
class Trie {
    Trie children[] = new Trie[26];
    String word = null;
    
    void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (node.children[c] == null)
                node.children[c] = new Trie();
            node = node.children[c];
        }
        node.word = word;
    }
}

class Solution {
    String s;
    int dp[];
    Trie root = new Trie();
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String word : words)
            root.insert(word);
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0)
                continue;
            this.s = word;
            dp = new int[word.length() + 1];
            dp[dp.length - 1] = 1;
            if (search(0))
                ret.add(word);
        }
        return ret;
        
    }
    boolean search(int i) {
        if (dp[i] != 0)
            return dp[i] == 1 ? true : false;
        dp[i] = -1;
        Trie node = root;
        while (i < s.length()) {
            node = node.children[s.charAt(i) - 'a'];
            if (node == null)
                return false;
            if (node.word != null && node.word != s) {
                if (search(i + 1)) {
                    dp[i] = 1;
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
