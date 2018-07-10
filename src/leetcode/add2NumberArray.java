package leetcode;

public class add2NumberArray {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 4, 5, 1, };
		int[] b = new int[] { 6, 2, 3 };

		int[] result = addNumber(a, b);

		for (int num : result) {
			System.out.println(num);
		}

	}

	private static int[] addNumber(int[] a, int[] b) {
		// What is the maximum of input a, b
		// carry over ? overflow ? should a, b same side ? assume a < b
		// find bigger
		int aSize = a.length;
		int bSize = b.length;
		int temp = aSize >= bSize ? aSize : bSize;

		int[] result = new int[temp];
		int carry = 0;
		int sum = 0;
		int index = 0;
		// asume a < b => i < j
		for (int i = aSize - 1, j = bSize - 1; i >= 0 || j >= 0; i--, j--) {
			if (i >= 0 && j >= 0) {
				sum = a[i] + b[j] + carry;
				index = i >= j ? i : j;
			} else if (j >= 0 && i < 0) {
				sum = b[j] + carry;
				index = j;
			} else if (i >= 0 && j < 0) {
				sum = a[i] + carry;
				index = i;
			}
			
			if (sum > 9) {
				result[index] = sum % 10;
				carry = 1;
			} else {
				result[index] = sum;
				carry = 0;
			}

			//
			if (carry > 0)
				result[j + 1] = carry;
		}
		return result;
	}
}