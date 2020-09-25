// LeetCode 179. Largest Number
// O(nlogn) (assuming bounded length of integers) time, O(n) space
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) {
		int[] nums = {2, 10, 33, 30, 9, 12, 121};
		System.out.println(new Solution().largestNumber(nums));
	}
	public String largestNumber(int[] nums) {
		return Arrays.stream(nums).sum() == 0 ? "0" : String.join("", Arrays.stream(nums).mapToObj(String::valueOf).sorted((String a, String b) -> (b + a).compareTo(a + b)).collect(Collectors.toList()));
	}
}
