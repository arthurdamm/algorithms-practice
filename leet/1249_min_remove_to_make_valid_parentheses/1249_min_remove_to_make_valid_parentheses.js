// LeetCode 1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// O(n) time-and-space
var minRemoveToMakeValid = function(s) {
    let removeLefts = [], removeRights = [];
    for (let i = 0; i < s.length; i++) {
        if (s[i] == "(")
            removeLefts.push(i)
        else if (s[i] == ")") {
            if (!removeLefts.length)
                removeRights.push(i);
            else
                removeLefts.pop();
        }
    }
    let filterSet = new Set([...removeLefts, ...removeRights]);
    return s.split("").filter((c, i) => !filterSet.has(i)).join("");
};
