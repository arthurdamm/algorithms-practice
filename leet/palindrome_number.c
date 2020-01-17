// LeetCode 9. Palindrome Number

bool isPalindrome(int x){
    if (x < 0) return false;
    if (x == 0) return true;
    int digits = 0, xcopy = x;
    long rev = 0;
    while (x) {
        digits++;
        rev = rev * 10 + x % 10;
        x /= 10;
    }
    digits /= 2;
    x = xcopy;
    while (digits) {
        if (rev % 10 != x % 10) return false;
        rev /= 10;
        x /= 10;
        digits--;
    }
    return true;
}

