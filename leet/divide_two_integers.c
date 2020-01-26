# LeetCode 29. Divide Two Integers

#include <stdio.h>
#include <limits.h>
#include <math.h>
#include <stdlib.h>

int divide(int dividend, int divisor) {
    int neg = 1, quotient = 0;
    unsigned int _sum = 0, _dividend, _divisor;
    
    if (divisor == -1)
        return dividend == INT_MIN ? INT_MAX : -dividend;
    if (divisor == 1)
        return dividend;
    if (divisor == INT_MIN)
        _divisor = INT_MAX + 1;
    else
        _divisor = divisor < 0 ? -divisor : divisor;
    if (dividend == INT_MIN)
        _dividend = INT_MAX + 1;
    else
        _dividend = dividend < 0 ? -dividend : dividend;
    neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
    quotient = pow(M_E, log(_dividend) - log(_divisor));
    return neg ? -quotient : quotient;
}

