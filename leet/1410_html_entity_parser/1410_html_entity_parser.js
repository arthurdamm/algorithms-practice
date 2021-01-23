// LeetCode 1410. HTML Entity Parser
// https://leetcode.com/problems/html-entity-parser/
// O(n) time-and-space
var entityParser = function(text) {
    let mapping = {quot: "\"", apos: "'", amp: "&", gt: ">", lt: "<", frasl: "/"};
    return text.replace(/&([^&;]+);/g, (s0, s1) => mapping[s1] ? mapping[s1] : s0);
};
