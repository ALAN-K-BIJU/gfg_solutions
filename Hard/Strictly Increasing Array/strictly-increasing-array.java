//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            long ans = ob.min_operations(nums);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
  public int min_operations(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1); 
    for (int i = 1; i < nums.length; i++) {
      int maxLIS = 0;

      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i] && (nums[i] - nums[j] > i - j - 1)) {
          maxLIS = Math.max(maxLIS, dp[j]);
        }
      }
      dp[i] = Math.max(dp[i], 1 + maxLIS);
    }
    int lis = Arrays.stream(dp).max().getAsInt();
    return nums.length - lis;
  }
}