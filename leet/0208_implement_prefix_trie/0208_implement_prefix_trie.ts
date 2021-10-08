// LeetCode 208. Implement Trie (Prefix Tree)
// https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {
    children: {[key: string]: Trie};
    isWord: boolean;

    constructor() {
        this.children = {};
        this.isWord = false;
    }

    insert(word: string): void {
        let node: Trie = this;
        for (let c of word)
            node = c in node.children ? node.children[c]
                : node.children[c] = new Trie();;
        node.isWord = true;
    }

    findNode(prefix: string): Trie | null {
        let node: Trie = this;
        for (let c of prefix) {
            if (!(c in node.children))
                return null;
            node = node.children[c];
        }
        return node;
    }

    search(word: string): boolean {
        let node = this.findNode(word);
        return !!(node && node.isWord);
    }

    startsWith(prefix: string): boolean {
        let node = this.findNode(prefix);
        return !!node;
    }
}
