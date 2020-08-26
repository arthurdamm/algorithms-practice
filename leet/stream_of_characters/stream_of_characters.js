#!/usr/bin/env node

var TreeNode = function() {
    this.children = {};
    this.value = false;
};


/**
 * @param {string[]} words
 */
var StreamChecker = function(words) {
    this.root = new TreeNode();
    this.stream = [];
    for (let word of words)
    { 
        word = word.split('').reverse().join('');
        let node = this.root;
        for (let char of word)
        {
            if (!node.children[char])
                node.children[char] = new TreeNode();
            node = node.children[char];
        }
        node.value = true;
    }
};

/** 
 * @param {character} letter
 * @return {boolean}
 */
StreamChecker.prototype.query = function(letter) {
    this.stream.unshift(letter);
    let node = this.root;
    for (let char of this.stream)
    {
        if (node.children[char])
        {
            node = node.children[char];
            if (node.value)
                return true;
        }
        else
            break;
    }
    return false;
};

/** 
 * Your StreamChecker object will be instantiated and called as such:
 * var obj = new StreamChecker(words)
 * var param_1 = obj.query(letter)
 */

words = ["cd","f","kl"];
stream = [["a"],["b"],["c"],["d"],["e"]]
obj = new StreamChecker(words)
for (char of stream)
{
    console.log(char[0], obj.query(char[0]));
}
