// LeetCode 745. Prefix and Suffix Search
// https://leetcode.com/problems/prefix-and-suffix-search/
// O(nk) time-and-space
class Trie {
    children: Map<string, Trie>
    index: number;

    constructor(words: string[]|null) {
        this.children = new Map();
        this.index = -1;
        if (words)
            words.forEach((word, i) => this.insert(word, i));
    }

    insert(word: string, index: number) {
        let node:Trie = this;
        for (let i = 0; i < word.length; i++) {
            if (!node.children.has(word[i]))
                node.children.set(word[i], new Trie(null));
            node = node.children.get(word[i]);
        }
        node.index = index;
    }

    findPrefix(prefix: string): number[] {
        let node:Trie = this, result = [];
        for (let i = 0; i < prefix.length; i++)
            if (!(node = node.children.get(prefix[i])))
                return result;
        this.findAll(node, result);
        return result;
    }

    findAll(node: Trie, result: number[]) {
        if (node.index != -1)
            result.push(node.index);
        node.children.forEach(val => this.findAll(val, result));
    }
}

class WordFilter {
    root: Trie;
    reversedRoot: Trie;

    constructor(words: string[]) {
        this.root = new Trie(words);
        this.reversedRoot = new Trie(words.map(w=>w.split('').reverse().join('')));
    }

    f(prefix: string, suffix: string): number {
        let result = this.root.findPrefix(prefix);
        let reversedResult = new Set(this.reversedRoot.findPrefix(suffix.split('').reverse().join('')));
        let r = result.filter(r => reversedResult.has(r));        
        return r.length ? Math.max(...r) : -1;
    }
}
