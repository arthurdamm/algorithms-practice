// LeetCode 212. Word Search II
// https://leetcode.com/problems/word-search-ii/
// O(m*n*3^l) time, O(w*l) space
class Trie {
    children: {[key: string]: Trie};
    isWord: boolean;
    numWords: number;

    constructor() {
        this.children = {};
        this.isWord = false;
        this.numWords = 0;
    }

    insert(word: string): void {
        let node: Trie = this;
        node.numWords += 1;
        for (let c of word) {
            node = c in node.children ? node.children[c]
                : node.children[c] = new Trie();
            node.numWords += 1;
        }
        node.isWord = true;
    }

    delete(word: string) {
        let node: Trie = this;
        node.numWords -= 1;
        for (let c of word) {
            node = node.children[c];
            node.numWords -= 1;
        }
        node.isWord = false;
    }

}

function findWords(board: string[][], words: string[]): string[] {
    const trie = new Trie();
    const solutions = [];
    const backtrack = (r, c, node, maybeWord) => {
        const char = board[r][c], nextMaybeWord = maybeWord + char,
              nextNode = node.children[char];
        board[r][c] = '#';
        if (nextNode) {
            let numWords = nextNode.numWords, isWord = nextNode.isWord;
            if (isWord) {
                solutions.push(nextMaybeWord);
                numWords--;
                trie.delete(nextMaybeWord);
            }
            if (numWords > 0) {
                for (let [dr, dc] of [[0, 1], [0, -1], [1, 0], [-1, 0]]) {
                    const nextR = r + dr, nextC = c + dc;
                    if (nextR < 0 || nextR >= board.length || nextC < 0 ||
                        nextC >= board[0].length || board[nextR][nextC] == '#') {
                        continue;
                    }
                    backtrack(nextR, nextC, nextNode, nextMaybeWord);
                }
            }
        }
        board[r][c] = char;
    }
    for (let word of words) {
        trie.insert(word);
    }
    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board[0].length; c++) {
            backtrack(r, c, trie, '');
        }
    }
    return solutions;
};
