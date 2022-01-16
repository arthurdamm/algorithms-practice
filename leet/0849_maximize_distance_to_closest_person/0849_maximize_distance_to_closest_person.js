// LeetCode 849. Maximize Distance to Closest Person
// https://leetcode.com/problems/maximize-distance-to-closest-person/
// O(n) time, O(1) space
var maxDistToClosest = function(seats) {
    const distanceFromLeft = Array(seats.length).fill(0);
    let lastPerson = -1, maxDistance = 0;
    for (let i = 0; i <= seats.length; i++) {
        if (i == seats.length || seats[i] == 1) {
            let distance;
            if (lastPerson == -1)
                distance = i;
            else if (i == seats.length)
                distance = i - 1 - lastPerson;
            else
                distance = Math.trunc((i - lastPerson) / 2);
            lastPerson = i;
            maxDistance = Math.max(maxDistance, distance);
        }
    }
    return maxDistance;
};
