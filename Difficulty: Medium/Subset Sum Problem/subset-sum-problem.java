//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;

        // Create a DP table
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: A sum of 0 is always achievable with an empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    // Include or exclude the current element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    // Exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result is stored at dp[n][target]
        return dp[n][target];
    }
}