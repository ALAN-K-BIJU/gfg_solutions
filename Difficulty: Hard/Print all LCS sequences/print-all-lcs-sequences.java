//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
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
    public List<String> all_longest_common_subsequences(String s, String t) {
        int m = s.length() , n = t.length();
        // find length of LCS
        int[][] dp = new int[m+1][n+1];
        for(int i = 1 ; i <= m ;i++){
            for(int j = 1;j<= n ;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        Set<String> res = new LinkedHashSet<>();
        Map<String,Set<String>> dpMap = new HashMap<>();
        findLongestString(dp,s,t,m,n,res,new StringBuilder(),dpMap);
        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }
    private void findLongestString(int[][] dp ,String s , String t, int i , int j , Set<String> res , StringBuilder cur,Map<String,Set<String>> dpMap){
        if(i == 0 || j == 0){
            res.add(cur.reverse().toString());// add answer
            cur.reverse(); // again reverse the cur
            return;
        }
        
        String key = i + ","+ j + cur.toString(); // memoziation
        if(dpMap.containsKey(key)){
            res.addAll(dpMap.get(key));
            return ;
        }
        if(s.charAt(i-1) == t.charAt(j-1)){
            cur.append(s.charAt(i-1));
            findLongestString(dp,s,t,i-1,j-1,res,cur,dpMap);
            cur.deleteCharAt(cur.length()-1);
        }
        else{ 
            // check two diagonals , thats why two if clause
            if(dp[i-1][j] == dp[i][j]){
                findLongestString(dp,s,t,i-1,j,res,cur,dpMap);
            
            }
            if(dp[i][j-1] == dp[i][j]){
                findLongestString(dp,s,t,i,j-1,res,cur,dpMap);
            }
        }
        dpMap.put(key,new HashSet<>(res)); // store the result to the map like dp array
        
    }
}