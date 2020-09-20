import java.util.*;
class Solution {
    int[] numDigitsAndLeadingDigit(int num) {
        int n = (int)1e9, i = 10;
        for (; n >= 10; n /= 10, i--)
            if (num / n != 0)
                break;
        int ret[] = {i, num / n};
        return ret;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int[] ret = numDigitsAndLeadingDigit(low);
        List<Integer> nums = new ArrayList<Integer>();
        for (int numDigits = ret[0]; numDigits <= 9; numDigits++) {
            for (int startingDigit = numDigits == ret[0] ? ret[1] : 1;
                startingDigit <= 9 - numDigits + 1; startingDigit++) {
                int firstDigit = startingDigit;
                int num = firstDigit;
                for (int digit = 1; digit < numDigits; digit++) {
                    num = num * 10 + ++firstDigit;
                }
                if (num > high)
                    return nums;
                if (num >= low)
                    nums.add(num);
            }
        }
        return nums;
    }
}

