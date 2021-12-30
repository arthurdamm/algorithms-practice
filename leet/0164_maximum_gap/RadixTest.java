import java.util.Arrays;

public class RadixTest {
	public static void main(String args[]) {
		test(new int[]{3, 1, 2});
		test(new int[]{111, 22, 3});
		test(new int[]{-12312, -3323234, 0, 0, 23234, -1213, 12312313, 234324});
	}

	static void test(int arr[]) {
		new RadixSort().radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
