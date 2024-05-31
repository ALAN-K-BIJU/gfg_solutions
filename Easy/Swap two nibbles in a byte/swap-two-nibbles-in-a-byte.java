//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int swapNibbles(int n) {
        // Extract the higher and lower nibbles and swap them
        int highNibble = (n & 0xF0) >> 4;
        int lowNibble = (n & 0x0F) << 4;
        return highNibble | lowNibble;
    }
}
