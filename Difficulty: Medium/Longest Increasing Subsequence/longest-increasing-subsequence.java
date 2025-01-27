//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int lis(int nums[]) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        
        // Base case: if there's only 1 number in nums, the longest subsequence is 1.
        memo[0] = 1;

        int longest = memo[0];
        for (int i = 1; i < nums.length; i++) {
            // Set the base case for this num, we have two choices:
            // 1) Either start a new subsequence using the value, 1.
            // 2) Add on to an existing subsequence using the max length of subsequences
            //    before i that ended in a number less than nums[i].
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
            longest = Math.max(longest, memo[i]);
        }
        return longest;
    }
}