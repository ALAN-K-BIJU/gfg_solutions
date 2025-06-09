

// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    // Function to implement merge sort and count inversions.
    static int mergeSort(int arr[], int temp[], int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            invCount += mergeSort(arr, temp, left, mid);

            // Count inversions in right half
            invCount += mergeSort(arr, temp, mid + 1, right);

            // Count inversions while merging the two halves
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Function to merge two halves and count inversions during the merge process.
    static int merge(int arr[], int temp[], int left, int mid, int right) {
        int i = left;    // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left;    // Starting index to be sorted
        int invCount = 0;

        // Merge the two subarrays while counting inversions
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                // There are (mid - i + 1) inversions because all elements left in
                // the left subarray are greater than arr[j].
                invCount += (mid - i + 1);
            }
        }

        // Copy the remaining elements of the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of the right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray into Original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}