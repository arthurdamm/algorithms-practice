# LeetCode 7. Reverse Integer
#include <limits.h>

int reverse(int x){
    long num = 0;
    while (x) {
        num = num * 10 + x % 10;
        x /= 10;
    }
    if (num > INT_MAX || num < INT_MIN)
        return (0);
    return (num);
}

