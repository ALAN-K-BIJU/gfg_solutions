//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        int n = arr.length; // Number of days
        
        // If there is only one day, return the maximum of the first row
        if (n == 1) {
            return Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        }

        // dp[i][j] represents the maximum points achievable till day i
        // if Geek performs activity j on the i-th day
        int[][] dp = new int[n][3];
        
        // Initialize the first day's values
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]); // Running
            dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]); // Fighting
            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]); // Learning
        }

        // The maximum points achievable on the last day
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}
