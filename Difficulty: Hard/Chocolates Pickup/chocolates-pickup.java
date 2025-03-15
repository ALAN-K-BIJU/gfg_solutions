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
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
        // Create 3D DP array
        int[][][] dp = new int[n][m][m];
        
        // Initialize with -1
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        // Start recursion from first row with robots at (0,0) and (0,m-1)
        return helper(0, 0, m-1, n, m, grid, dp);
    }
    
    private int helper(int row, int col1, int col2, int n, int m, int[][] grid, int[][][] dp) {
        // Base cases for invalid positions
        if(col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return Integer.MIN_VALUE;
        }
        
        // Reached last row
        if(row == n-1) {
            if(col1 == col2) {
                return grid[row][col1];
            }
            return grid[row][col1] + grid[row][col2];
        }
        
        // If already computed
        if(dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }
        
        // Calculate chocolates at current position
        int chocolates = (col1 == col2) ? grid[row][col1] : 
                                         grid[row][col1] + grid[row][col2];
        
        // Try all possible moves for both robots
        int maxChocolates = Integer.MIN_VALUE;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int value = helper(row + 1, col1 + i, col2 + j, n, m, grid, dp);
                if(value != Integer.MIN_VALUE) {
                    maxChocolates = Math.max(maxChocolates, value);
                }
            }
        }
        
        // Store and return result
        dp[row][col1][col2] = chocolates + maxChocolates;
        return dp[row][col1][col2];
    }
}

