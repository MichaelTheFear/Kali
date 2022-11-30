package main;

public class MergeSort {
	// Merges two ordered subarrays, arr[l..m] and arr[m+1..r].
	public void __merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];
		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	private boolean isOrdered(int[] arr, int l, int r) {

		if (arr == null) {
			return true;
		}
		boolean ordered = true;

		for (int i = l; i < r - 1; i++) {
			// System.out.println(arr[i]);
			if (arr[i + 1] < arr[i])
				ordered = false;
		}

		return ordered;
	}

	private boolean isValid(int arr[], int r, int l) {
		if(arr == null)
			return false;
		if (arr.length < r)
			return false;
		if (arr.length < l)
			return false;
		if (l > r)
			return false;
		return true;
	}

	private boolean isValid(int arr[], int r, int l, int m) {
		if (m > r)
			return false;
		if (m < l)
			return false;
		if (m > arr.length)
			return false;
		return isValid(arr, r, l);
	}

	public void merge(int arr[], int l, int m, int r) {
		assert isValid(arr, r, l); // mesma validacao do sort
		assert isValid(arr, r, l, m); // validacao unica do merge

		assert isOrdered(arr, l, m); // verificar sort
		assert isOrdered(arr, m + 1, r); // verifica sort
		__merge(arr, l, m, r);

		assert isOrdered(arr, l, r);
	}

	public void sort(int arr[], int l, int r) {
		assert isValid(arr, r, l);
		__sort(arr, l, r);
		assert isOrdered(arr, l, r);
	}

	// Main function that sorts arr[l..r] using merge()
	private void __sort(int arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			// Sort first and second halves
			__sort(arr, l, m); // assert isSorted
			__sort(arr, m + 1, r);
			// Merge the sorted halves
			merge(arr, l, m, r);
		}

	}
}
