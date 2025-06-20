


class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
    int[] left = calculateLIS(nums);
    reverse(nums);
    int[] right = calculateLIS(nums);
    
    int result = 0;
    for (int i = 0; i < n; i++) {
        if (left[i] > 1 && right[n - 1 - i] > 1)
            result = Math.max(result, left[i] + right[n - 1 - i] - 1);
    }
    return result;
    }
    
    private static int[] calculateLIS(int[] nums) {
        int n = nums.length, dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp;
    }
    
    private static void reverse(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }


}
