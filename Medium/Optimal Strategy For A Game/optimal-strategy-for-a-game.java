//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends


class solve {
    static long countMaximum(int n, int arr[]) {
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                long pickFirst = arr[i] + (i + 2 <= j ? Math.min(dp[i + 2][j], dp[i + 1][j - 1]) : 0);
                long pickLast = arr[j] + (i + 1 <= j - 1 ? Math.min(dp[i + 1][j - 1], dp[i][j - 2]) : 0);

                dp[i][j] = Math.max(pickFirst, pickLast);
            }
        }
        return dp[0][n - 1];
    }
}
