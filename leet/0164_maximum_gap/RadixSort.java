import java.util.Arrays;

class RadixSort {
	final static int BASE = 10;

	int[] countingSort(int[] A, int[] B, int div) {
		int[] count = new int[BASE];

		for (int i = 0; i < A.length; i++)
			count[A[i] / div % BASE]++;
		for (int i = 1; i < BASE; i++)
			count[i] += count[i - 1];
		for (int i = B.length - 1; i >= 0; i--) {
			B[--count[A[i] / div % BASE]] = A[i];
		}

		return B;
	}

	void radixSortPositives(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int num : A)
			max = Math.max(num, max);
		int[] B = new int[A.length];
		for (int div = 1; max / div > 0; div *= BASE) {
			B = countingSort(A, B, div);
			System.arraycopy(B, 0, A, 0, B.length);
		}
	}

	void radixSort(int[] A) {
		int negativeCount = 0, i = 0, j = 0;
		for (int n : A)
			if (n < 0)
				negativeCount++;
		int[] positives = new int[A.length - negativeCount],
			negatives = new int[negativeCount];

		for (int n : A)
			if (n < 0)
				negatives[j++] = -n;
			else
				positives[i++] = n;

		radixSortPositives(negatives);
		radixSortPositives(positives);
		for (i = 0, j = negatives.length - 1; j >= 0; i++, j--)
			A[i] = -negatives[j];
		for (j = 0; j < positives.length; i++, j++)
			A[i] = positives[j];
	}
}