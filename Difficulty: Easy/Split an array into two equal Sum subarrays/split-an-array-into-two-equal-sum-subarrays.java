//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int j = arr.length - 1;
        int sum = 0;
        int sum1 = arr[j];
        int i = 0;
        while(i != j){
            if(sum <= sum1){
                sum += arr[i];
                i++;
            }else{
                j--;
                sum1 += arr[j];
            }
        }
        if(sum == sum1){
            return true;
        }
        return false;
    }
}