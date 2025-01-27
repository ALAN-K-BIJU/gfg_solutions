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
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 1;
        int end = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            if (dp[i] > result) {
                end = i;
                result = dp[i];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[end]);
        backtrack(dp, arr, end, result - 1, ans);
        Collections.reverse(ans);
        
        return ans;
    }
    private void backtrack(int[] dp, int[] arr, int end, int num, ArrayList<Integer> result) {
        for (int i = 0; i < end; i++) {
            if (dp[i] == num && arr[i] < arr[end]) {
                result.add(arr[i]);
                backtrack(dp, arr, i, num - 1, result);
                break;
            }
        }
    }
}
