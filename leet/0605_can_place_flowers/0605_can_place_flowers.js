// LeetCode 605. Can Place Flowers
// https://leetcode.com/problems/can-place-flowers/
// O(n) time, O(1) space
var canPlaceFlowers = function(flowerbed, n) {
    for (let i = 0; i < flowerbed.length; i++) {
        if (flowerbed[i] === 0 && (!i || flowerbed[i - 1] === 0) &&
            (i === flowerbed.length - 1 || flowerbed[i + 1] === 0)) {
            n--;
            i++;
        }
    }
    return n <= 0;
};

