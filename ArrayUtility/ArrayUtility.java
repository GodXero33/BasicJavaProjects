class ArrayUtility {
	/* public static String toString (int[] arr) {
		int n = arr.length;

		if (n < 1) return "[]";

		StringBuilder output = new StringBuilder("[");

		for (int i = 0; i < n; i++) {
			output.append(arr[i]);

			if (i != n - 1) output.append(", ");
		}

		output.append("]");
		return output.toString();
	} */

	public static String toString (int[] arr) {
		int n = arr.length;

		if (n < 1) return "[]";

		String output = "[";

		for (int i = 0; i < n; i++) {
			output += arr[i];

			if (i != n - 1) output += ", ";
		}

		return output + "]";
	}

	public static int[] push (int[] arr, int value) {
		int n = arr.length;
		int[] tmp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i];
		}

		tmp[n] = value;
		return tmp;
	}

	public static int[] removeDuplicate (int[] arr) {
		int k = 0;
		int n = arr.length;
		int[] temp = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			boolean isDuplicate = false;

			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					isDuplicate = true;
					break;
				}
			}

			if (!isDuplicate) {
				temp[k] = arr[i];
				k++;
			}
		}

		int[] result = new int[k];

		for (int i = 0; i < k; i++) {
			result[i] = temp[k - 1 - i];
		}

		return result;
	}

	public static int[] pop (int[] arr) {
		int n = arr.length;
		int[] result = new int[n - 1];

		for (int i = 0; i < n - 1; i++) {
			result[i] = arr[i];
		}

		return result;
	}

	public static int[] shift (int[] arr) {
		int n = arr.length;
		int[] result = new int[n - 1];

		for (int i = 0; i < n - 1; i++) {
			result[i] = arr[i + 1];
		}

		return result;
	}

	public static int[] unshift (int[] arr, int value) {
		int n = arr.length;
		int[] result = new int[n + 1];

		result[0] = value;

		for (int i = 0; i < n; i++) {
			result[i + 1] = arr[i];
		}

		return result;
	}
}
