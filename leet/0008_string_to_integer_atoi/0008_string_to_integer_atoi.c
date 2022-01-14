// 8. String to Integer (atoi)
int myAtoi(char * str){
    long num = 0;
    int sign = 1;
    if (!str || !*str) return 0;
    while (*str == ' ' || *str == '\t') str++;
    if (*str == '+') {
        str++;
    }
    else if (*str == '-') {
        sign *= -1;
        str++;
    }
    while (*str >= '0' && *str <= '9') {
        num = (num * 10) + (*str - '0') * sign;
        if (num > INT_MAX) return INT_MAX;
        if (num < INT_MIN) return INT_MIN;
        str++;        
    }
    return num;
}

