//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            long Arr[] = new long[N];
            String[] S = read.readLine().split(" ");
            for (int i = 0; i < N; i++) Arr[i] = Long.parseLong(S[i]);
            Solution ob = new Solution();
            System.out.println(ob.pairAndSum(N, Arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long pairAndSum(int n, long[] arr) {
        long out = 0;
        for (int i = 0; i < 32; ++i) {
            long cnt = 0;
            for (int j = 0; j < n; ++j)
                if ((arr[j] & (1L << i)) != 0)
                    cnt++;
            long pairs = (cnt * (cnt - 1) / 2);
            out += pairs * (1L << i);
        }
        return out;
    }
}