// LeetCode 858. Mirror Reflection
// O(p) time, O(1) space

int mirrorReflection(int p, int q){
    int x = 1, y = 1;
    while (y * p != x * q)
        y = ++x * q / p;
    if (y % 2 == 0 && x % 2 == 1)
        return 0;
    if (y % 2 == 1 && x % 2 == 1)
        return 1;
    if (y % 2 == 1 && x % 2 == 0)
        return 2;
    return -1;
}
