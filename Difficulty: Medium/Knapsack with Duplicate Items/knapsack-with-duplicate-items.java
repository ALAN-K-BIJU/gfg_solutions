//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[] dp = new int[capacity + 1];
        
        // Iterate over each item
        for (int i = 0; i < n; i++) {
            // Update dp array for the current item's weight and value
            for (int j = wt[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }
        
        return dp[capacity];
    }
}
