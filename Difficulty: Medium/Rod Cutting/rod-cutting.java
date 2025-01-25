//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int cutRod(int[] price) {
        
        int n = price.length;
        // create a length array to deal with the 0-indexed prices of rod 
        int[] length = new int[n];
        for( int i = 0; i<n; i++){
            length[i] = i+1;
        }
        
        int[][] table = new int[n+1][n+1];
        
        // 1. initialise all the rows in column 0 as 0, coz no profit when we cut rod of length = 0
        // 2. initialise all the cols in row 0 as 0, coz no profit when no. of cut is 0
        
        // 3. 
        for( int i = 1; i<=n; i++){
            for( int j = 1; j<=n; j++){
                  if(length[i-1] <= j){
                      table[i][j] = Math.max(price[i-1] + table[i][j-length[i-1]], table[i-1][j] );
                  } else {
                      table[i][j] = table[i-1][j];
                  }
            }  
        }
        return table[n][n];
    }
}