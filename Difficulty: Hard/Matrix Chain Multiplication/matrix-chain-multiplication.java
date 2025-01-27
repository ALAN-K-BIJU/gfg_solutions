//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int table[][] = new int[n][n];
        // diagonals sohuld be zero!! 
        // at diagonals, i == j, that is matrix can't be formed for i==j, 
        // as we need at least 2 elements of the array to form the matrix. 
        for( int i = 0; i< n; i++){
            for( int j = 0; j<n; j++){
                if( i == j) table[i][j] = 0;   
            }
        }
        // here since the smallest problem will be when the matrix size is smallest,
        // we start from (i = n-1‚ j = n), where we only get 1 matrix
         for( int i = n-1; i>=1; i--){
            for( int j = i+1; j<n; j++){
                int ans = Integer.MAX_VALUE;

                for( int k = i; k <= j-1; k++){
                    int tempAns = table[i][k] + table[k+1][j] + (arr[i-1] * arr[k] * arr[j]);
                    ans = Math.min(tempAns, ans);
                }
                
                table[i][j] = ans;
            }
        }
        // we have our biggest problems answer store at
        // (i = 1, j = n-1)
        // for clarity visualise i and j in the given array
        return table[1][n-1];
    }
}