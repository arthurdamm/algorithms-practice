#!/usr/bin/env node

/**
 * LeetCode 841 Keys and Rooms
 */
var canVisitAllRooms = function(rooms) {
    visited = {}
    stack = [0]
    while (stack.length) {
        current = stack.pop()
        visited[current] = 1
        for (room of rooms[current])
            if (!visited[room])
                stack.push(room);
    }
    return Object.keys(visited).length == rooms.length
    
};

d = [[1],[2],[3],[]];
console.log("Solution", d, ":", canVisitAllRooms(d));
