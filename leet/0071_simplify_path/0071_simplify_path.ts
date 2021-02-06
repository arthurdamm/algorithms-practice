// LeetCode 71. Simplify Path
// https://leetcode.com/problems/simplify-path/
// O(n) time-and-space
function simplifyPath(path: string): string {
    return "/" + path.split("/").reduce((function(stack, part) {
        !this.ignore.has(part)
            ? part === ".."
                ? stack.pop()
                : stack.push(part)
            : 0; return stack})
        .bind({ignore: new Set([".", ""])}), [])
        .join("/");
};

// procedural
function simplifyPath(path: string): string {
    let stack = [], ignore = new Set([".", ""]);
    for (let part of path.split("/")) {
        if (ignore.has(part))
            continue;
        if (part === "..")
            stack.pop();
        else
            stack.push(part);
    }
    return `/${stack.join("/")}`;
};
