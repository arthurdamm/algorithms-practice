import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Trie {
    Trie[] children = new Trie[26];
    boolean isWord = false;
    
    public void insert(String word)
    {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                node.children[word.charAt(i) - 'a'] = new Trie();
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isWord = true;
    }
}

class Solution {
    Trie root;
    Set<Integer> memo = new HashSet<>();

    static void p(Object o) { System.out.println(o); }

    public static void main(String args[]) {
        String[] wordDict1 = {"bast", "bastard", "foo"};
        String word1 = "bastardfoo";

        String[] wordDict2 = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        String word2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        p(Arrays.toString(wordDict1) + ": " +
            new Solution().wordBreak(word1, Arrays.asList(wordDict1)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.root = new Trie();

        for (String word : wordDict)
            root.insert(word);
        return search(s, 0, this.root);
    }
    boolean search(String s, int i, Trie node) {
        if (this.memo.contains(i)) {
            return false;
        }
        this.memo.add(i);
        for (; i < s.length(); i++) {
            if (node.children[s.charAt(i) - 'a'] == null)
            {
                return false;
            }
            node = node.children[s.charAt(i) - 'a'];
            if (node.isWord && search(s, i + 1, this.root))
                return true;
        }
        return node.isWord;
    }
}
