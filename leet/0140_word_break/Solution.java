import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Trie {
    Trie[] children = new Trie[26];
    String isWord = null;
    
    public void insert(String word)
    {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                node.children[word.charAt(i) - 'a'] = new Trie();
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isWord = word;
    }
}

class Solution {
    Trie root;
    Map<Integer, ArrayList<String>> memo = new HashMap<>();
    List<String> answers = new ArrayList<String>();

    static void p(Object o) { System.out.println(o); }

    public static void main(String args[]) {
        String[] wordDict3 = {"cat", "cats", "and", "sand", "dog"};
        String word3 = "catsanddog";

        String[] wordDict4 = {"apple", "pen", "applepen", "pine", "pineapple"};
        String word4 = "pineapplepenapple";

        p(Arrays.toString(wordDict4) + ": " +
            Arrays.toString(new Solution().wordBreak(word4, Arrays.asList(wordDict4)).toArray()));
    }

    void composeAnswers(String curr, String word, int i) {
        if (i == 0) {
            this.answers.add(curr);
            return;
        }
        if (curr.length() > 0)
            curr = word + " " + curr;
        else
            curr = word;
        for (String prevWord : this.memo.get(i - word.length()))
            composeAnswers(curr, prevWord, i - word.length());
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.root = new Trie();

        for (String word : wordDict)
            root.insert(word);
        search(s, 0, this.root, null);
        if (this.memo.get(s.length()) != null)
            for (String word : this.memo.get(s.length())) {
                composeAnswers("", word, s.length());
            }
        return this.answers;
    }
    boolean search(String s, int i, Trie node, String match) {
        if (this.memo.containsKey(i)) {
            this.memo.get(i).add(match);
            return true;
        }
        this.memo.put(i, new ArrayList<String>());
        this.memo.get(i).add(match);
        for (; i < s.length(); i++) {
            if (node.children[s.charAt(i) - 'a'] == null)
            {
                return false;
            }
            node = node.children[s.charAt(i) - 'a'];
            if (node.isWord != null)
                search(s, i + 1, this.root, node.isWord);
        }
        return node.isWord != null;
    }
}
