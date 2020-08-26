class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
    
    public void insert(String word)
    {
        TrieNode node = this;
        for (char letter : word.toCharArray())
        {
           if (node.children.get(letter) == null)
               node.children.put(letter, new TrieNode());
            node = node.children.get(letter);
        }
        node.isWord = true;
    }
}

class StreamChecker {

    TrieNode root = new TrieNode();
    StringBuilder stream = new StringBuilder();
    
    public StreamChecker(String[] words) {
        for (String word : words)
            this.root.insert(new StringBuilder().append(word).reverse().toString());
    }
    
    public boolean query(char letter) {
        TrieNode node = this.root;
        this.stream.insert(0, letter);
        for (int i = 0; i < this.stream.length(); i++)
        {
            char c = this.stream.charAt(i);
            if((node = node.children.getOrDefault(c, null)) == null)
                break;
            if (node.isWord)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
