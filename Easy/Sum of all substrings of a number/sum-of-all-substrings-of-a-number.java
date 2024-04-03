//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static long sumSubstrings(String num) {
        final int MOD = 1000000007;
        long res = 0;
        int n = num.length();
        int[] sumOfDigit = new int[n];
        sumOfDigit[0] = num.charAt(0) - '0';
        res = sumOfDigit[0];
        for (int i = 1; i < n; i++) {
            int numi = num.charAt(i) - '0';
            sumOfDigit[i] = (int) (((long) (i + 1) * numi + 10L * sumOfDigit[i - 1]) % MOD);
            res = (res + sumOfDigit[i]) % MOD;
        }
        return res;
    }
}
