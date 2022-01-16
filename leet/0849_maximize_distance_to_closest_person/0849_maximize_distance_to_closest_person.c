// LeetCode 849. Maximize Distance to Closest Person
// https://leetcode.com/problems/maximize-distance-to-closest-person/
// O(n) time-and-space
#define MIN(x,y) ((x) < (y) ? (x) : (y))
#define MAX(x,y) ((x) > (y) ? (x) : (y))
int maxDistToClosest(int* seats, int seatsSize) {
    int *distanceFromLeft = malloc(seatsSize * sizeof(int)),
        *distanceFromRight = malloc(seatsSize * sizeof(int));
    for (int i = 0, j = seatsSize - 1; i < seatsSize; i++, j--) {
        if (seats[i] == 1)
            distanceFromLeft[i] = 0;
        else
            distanceFromLeft[i] = !i || distanceFromLeft[i - 1] == INT_MAX
                ? INT_MAX : distanceFromLeft[i - 1] + 1;
        
        if (seats[j] == 1)
            distanceFromRight[j] = 0;
        else
            distanceFromRight[j] = !i || distanceFromRight[j + 1] == INT_MAX
                ? INT_MAX : distanceFromRight[j + 1] + 1;
    }
    int maxDistance = 0;
    for (int i = 0; i < seatsSize; i++) {
        int distance = MIN(distanceFromRight[i], distanceFromLeft[i]);
        maxDistance = MAX(maxDistance, distance);
    }
    return maxDistance;
}
