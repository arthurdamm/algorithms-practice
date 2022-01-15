// LeetCode 1345. Jump Game IV
// https://leetcode.com/problems/jump-game-iv/
// O(n) time-and-space
var minJumps = function(arr) {
    const valToIndices = {}
    for (let i = 0; i < arr.length; i++) {
        if (!valToIndices[arr[i]])
            valToIndices[arr[i]] = [];
        valToIndices[arr[i]].push(i);
    }
    const visited = Array(arr.length).fill(false), queue = [0];
    visited[0] = true;
    let steps = 0, x = 0;
    while (queue.length) {
        for (let sz = queue.length - x; sz > 0; sz--) {
            i = queue[x++];
            if (i == arr.length - 1)
                return steps;
            visited[i] = true;
            for (j of valToIndices[arr[i]]) {
                if (!visited[j])
                    queue.push(j)
            }
            valToIndices[arr[i]] = [];
            if (i + 1 < arr.length && !visited[i + 1])
                queue.push(i + 1);
            if (i - 1 >= 0 && !visited[i - 1])
                queue.push(i - 1);
        }
        steps++;
    }
    return steps;

};
