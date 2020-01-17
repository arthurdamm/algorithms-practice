#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int _isMatch(char * s, char * p, int **memo, char *a, char *b) {
    if (memo[s-a][p-b]) {
      return 0;
    }
    memo[s-a][p-b] = 1;

    if (!*p) return !*s;
    // if string is empty the pattern must match it
    if (!*s) {
        // wildchars ok
        while (*p == '*')
          p++;
        // else must be empty
        return !*p;
    }
    // default case is the current chars match
    if (*s == *p) {
        return _isMatch(s + 1, p + 1, memo, a, b);
    }
    // Check special pattern chars first
    // * can match anything or not
    if (*p == '*') {
        while (*(p + 1) == '*')
            p++;
        return _isMatch(s + 1, p, memo, a, b) || _isMatch(s, p + 1, memo, a, b);

    }
    // similar for ? except it can't keep matching
    if (*p == '?') {
        return _isMatch(s + 1, p + 1, memo, a, b);
    }
    
    return 0;
}

int isMatch(char * s, char * p) {
    // 2-D memoization array for the positions of characters in two strings
    int **memo = malloc((strlen(s) + 1) * sizeof(int *));
    for (int i = 0, sz = strlen(p) + 1; i < strlen(s) + 1; i++) {
        memo[i] = malloc(sz * sizeof(int));
        memset(memo[i], 0, sz * sizeof(int));
    }
    return _isMatch(s, p, memo, s, p);
}

int main(void)
{
  char *s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
  char *p = "**aa*****ba*a*bb**aa*ab****a*aa";
  printf("Solution: %s %s: %d\n", s, p, isMatch(s, p));
  return (EXIT_SUCCESS);
}
