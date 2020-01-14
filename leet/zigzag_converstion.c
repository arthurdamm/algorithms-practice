#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char * convert(char * s, int numRows){
    // edge cases
    if (!s || numRows <= 0) return NULL;
    if (numRows == 1) return s;
    // alloc return string space
    int sz = strlen(s);
    char *ret = malloc(sz + 1);
    char *ptr = ret;
    if (!ret) return NULL;
    // first row
    int i = 0;
    int di = (numRows - 1) * 2;
    for(i = 0; i < sz; i += di) {
        *ret++ = s[i];
    }
    // inner rows
    for (int row = 1; row < numRows - 1; row++) {
        i = row;
        int up = 1;
        while (i < sz) {
            *ret++ = s[i];
            di = up ? 2*(numRows - 1 - row) : 2*row;
            i += di;
            up = up ? 0 : 1;
        }
    }
    // last row
    for(i = numRows - 1, di = (numRows - 1) * 2; i < sz; i += di) {
        *ret++ = s[i];
    }
    *ret = 0;
    return ptr;
}

int main(int argc, char **args) {
    char *s = "PAYPALISHIRING";
    printf("Solution to %s, 3: %s\n", s, convert(s, 3));
    return EXIT_SUCCESS;
}
